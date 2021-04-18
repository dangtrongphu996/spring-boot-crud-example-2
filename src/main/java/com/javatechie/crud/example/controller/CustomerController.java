package com.javatechie.crud.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javatechie.crud.example.entity.Customer;
import com.javatechie.crud.example.service.CustomerService;
@Controller
public class CustomerController {
	
	@Autowired
    private CustomerService service;

	@GetMapping("/list") public String viewHome(Model model,
			  @RequestParam(name = "keyword", required = false, defaultValue = "") String keyword,
			  @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
		      @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
		      @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
		Sort sortable = null;
	    if (sort.equals("ASC")) {
	      sortable = Sort.by("id").ascending();
	    }
	    if (sort.equals("DESC")) {
	      sortable = Sort.by("id").descending();
	    }
	    Pageable pageable = PageRequest.of(page, size, sortable);
	    
	    int totalPages = service.getProductByName(pageable,keyword).getTotalPages();
	    
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
	    model.addAttribute("listCustomer", service.getProductByName(pageable,keyword));
	    long totalRecord = service.getProductByName(pageable,keyword).getTotalElements();
        model.addAttribute("totalRecord", service.getProductByName(pageable,keyword).getTotalElements());
	    model.addAttribute("page",page);
	    if(keyword == null || keyword == "") {
	    	keyword = "";
	    }
	    model.addAttribute("keyword",keyword);
	    long number = 5;
	    
	    number = (page+1)*size;
	    if(number > totalRecord) {
	    	number = totalRecord;
	    }
	    model.addAttribute("number",number);
		return "list"; 
	}
	
	@GetMapping("/delCus/{id}")
    public String deleteProduct(@PathVariable int id) {
       service.deleteCustomer(id);
       return "redirect:/list";
    }
	
	@GetMapping("/addCus")
    public String addProduct(Model model) {
    	Customer customer = new Customer();
        model.addAttribute("customer", customer);
    	return "addCus";
    }
	
	@PostMapping(value = "/addCus",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addProducts(Customer customer) {
		Customer customer1 = service.saveProducts(customer);
    	if(customer1!= null) {
    		return "redirect:/list";
    	}else {
    		return "redirect:/addCus";
    	}
    }
	
	@RequestMapping(value="/plantNamesAutocomplete")
	@ResponseBody
	public List<String> plantNamesAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term)  {
		List<Customer> listCustomer = new ArrayList<Customer>();
		List<String> result = new ArrayList<String>();
		try {
			// only update when term is three characters.
			if (term.length() >= 3) {
				listCustomer = service.autocomplete(term);
			}
			
			if(listCustomer.size() > 0 ) {
				
				for (Customer customer : listCustomer) {
					result.add(customer.getName());
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return result;
	}
}
