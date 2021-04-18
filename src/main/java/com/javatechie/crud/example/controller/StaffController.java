package com.javatechie.crud.example.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javatechie.crud.example.entity.Departs;
import com.javatechie.crud.example.entity.Staffs;
import com.javatechie.crud.example.entity.StaffsDto;
import com.javatechie.crud.example.service.DepartsService;
import com.javatechie.crud.example.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@Autowired
	DepartsService departsService;
	
	@GetMapping("/list")
	public String listStaff(ModelMap model) {
		List<Staffs> listStaffs = new ArrayList<Staffs>();
		listStaffs = staffService.findAll();
		model.addAttribute("listStaffs",listStaffs);
		return "view-staffs";
	}
	
	@GetMapping("/addStaff")
	public String addStaff(ModelMap model) {
		 List<Departs> listDeparts = new ArrayList<Departs>(); 
		 listDeparts = departsService.findAll(); 
		 StaffsDto staffsDto = new StaffsDto();
	     model.addAttribute("staffsDto", staffsDto);
		 model.addAttribute("listDeparts",listDeparts);
		return "staff";
	}
	
	@GetMapping("/editStaff/{id}")
    public String findProductById(@PathVariable int id,Model model) {
		 Staffs staffs =  staffService.findById(id);
		 StaffsDto staffsDto = new StaffsDto(staffs.getId(), staffs.getName(), staffs.getGender(), staffs.getBirthday(), staffs.getPhoto(),staffs.getEmail(), staffs.getPhone(), staffs.getSalary(), staffs.getNotes(), staffs.getDeparts().getId());
		 List<Departs> listDeparts = new ArrayList<Departs>(); 
		 SimpleDateFormat sm = new SimpleDateFormat("dd/mm/yyyy");
		 listDeparts = departsService.findAll(); 
		 model.addAttribute("staffsDto", staffsDto);
		 model.addAttribute("pho123", staffs.getPhoto());
		 model.addAttribute("birthday", sm.format(staffs.getBirthday()));
		 model.addAttribute("listDeparts",listDeparts);
    	 return "staff";
    }
	
	@PostMapping(value = "/saveOrUpdate")
    public String addProducts(Model model,@ModelAttribute("staffsDto") StaffsDto staffsDto) {
		Staffs optionalStaffs = null;
		
		if(staffsDto.getId()!=null) {
			optionalStaffs = staffService.findById(staffsDto.getId());
		}
		 
		Path path = Paths.get("uploads/");
		String image  = "";
		Staffs staffs1 = null;
		if(!staffsDto.getPhoto().isEmpty()) {
			try {
				InputStream inputStream = staffsDto.getPhoto().getInputStream();
				Files.copy(inputStream, path.resolve(staffsDto.getPhoto().getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);
				image = staffsDto.getPhoto().getOriginalFilename().toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 

		if(optionalStaffs==null) {
			
			if(null!=image && ""!=image) {
				
				image = "avatar.jpg";
			}
			staffs1 = new Staffs(staffsDto.getId(), staffsDto.getName(), staffsDto.getGender(), staffsDto.getBirthday(), image, staffsDto.getEmail(), staffsDto.getPhone(), staffsDto.getSalary(), staffsDto.getNotes(), new Departs(staffsDto.getDeparts(),""));
			staffService.save(staffs1);
			
		} else {
			

			optionalStaffs.setName(staffsDto.getName());
			optionalStaffs.setGender(staffsDto.getGender());
			optionalStaffs.setBirthday(staffsDto.getBirthday());
			optionalStaffs.setEmail(staffsDto.getEmail());
			optionalStaffs.setPhone(staffsDto.getPhone());
			optionalStaffs.setSalary(staffsDto.getSalary());
			optionalStaffs.setNotes(staffsDto.getNotes());
			optionalStaffs.setDeparts(new Departs(staffsDto.getDeparts(), ""));
			if(null!=image && ""!=image) {
				
				optionalStaffs.setPhoto(image);
			}
			staffService.save(optionalStaffs);
		}

		
		
    	return "redirect:/staff/list";
   
    }
	
	@GetMapping("/delStaff/{id}")
    public String deleteProduct(@PathVariable int id) {
	   Staffs optionalStaffs = staffService.findById(id);
       staffService.delete(optionalStaffs);
       return "redirect:/staff/list";
    }
}
