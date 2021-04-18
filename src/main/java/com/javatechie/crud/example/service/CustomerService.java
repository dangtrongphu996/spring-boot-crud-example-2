package com.javatechie.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Customer;
import com.javatechie.crud.example.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getProducts() {
        return repository.findAll();
    }

    public long getProductByName() {
        return repository.findCustomers();
    }
    
    public Page<Customer> getProductByName(Pageable pageable,String keyword) {
        if(keyword == null || keyword == "") {
        	
        	return repository.findCustomers(pageable);
        
        } else {
        	
        	return repository.findByName(pageable, keyword);
        }
    	
    }
    
    public List<Customer> autocomplete(String keyword) {
    	
    	return repository.findByName(keyword);
    }

	public void deleteCustomer(int id) {
		
		repository.deleteById(id);
	}

	public Customer saveProducts(Customer customer) {
		return repository.save(customer);
	}

    

    


}