package com.javatechie.crud.example.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.javatechie.crud.example.entity.ProductType;
import com.javatechie.crud.example.service.ProductTypeService;

@Controller
public class BaseController {

	@Autowired
	public ProductTypeService _productTypeService;
	
	@PostConstruct
	@ModelAttribute("listProductType")
	public List<ProductType> getAllCustomers() {
	    
		return _productTypeService.findAll();
	}
}
