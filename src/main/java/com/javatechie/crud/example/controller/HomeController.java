package com.javatechie.crud.example.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javatechie.crud.example.entity.CartInfo;
import com.javatechie.crud.example.entity.CartLineInfo;
import com.javatechie.crud.example.entity.ProductType;
import com.javatechie.crud.example.entity.Products;
import com.javatechie.crud.example.entity.Slide;
import com.javatechie.crud.example.entity.Utils;
import com.javatechie.crud.example.service.ProductTypeService;
import com.javatechie.crud.example.service.ProductsService;
import com.javatechie.crud.example.service.SlideService;

@Controller
public class HomeController extends BaseController{
	
	@Autowired
	private SlideService slideService;
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private ProductTypeService productTypeService;
    
	@GetMapping("/")
    public String viewHomePage(ModelMap model,HttpServletRequest request, HttpSession session) {
		
		List<CartLineInfo> cartItems = (List<CartLineInfo>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new ArrayList<CartLineInfo>();
        }
        CartInfo cartInfo = Utils.getCartInSession(request);
        session.setAttribute("cartInfo", cartInfo);
        model.addAttribute("cartForm", cartInfo);
        session.setAttribute("myCartNum", cartItems.size());
        
		List<Slide> listSlide = new ArrayList<Slide>();
		listSlide = slideService.findAll();
		
		List<Products> listNewProduct = new ArrayList<Products>();
		listNewProduct = productsService.getListNewProduct();
		model.addAttribute("listNewProduct",listNewProduct);
		
		//model.addAttribute("listProductType",_mvShare.getAttribute("listProductType"));
        return "index";
    }
	
	@GetMapping("/gioithieu")
    public String viewAboutPage() {
        return "gioithieu";
    }
	
	@GetMapping("/contact")
    public String viewContactsPage() {
        return "contact";
    }
	
	@GetMapping("/productType/{idType}")
    public String viewProductTypePage(ModelMap model,
    		@PathVariable String idType) {
		
		List<Products> listProductByType = new ArrayList<Products>();
		listProductByType = productsService.findByProductType(Integer.parseInt(idType));
		ProductType productType = productTypeService.findById(Integer.parseInt(idType));
		// model.addAttribute("listProductType",_mvShare.getAttribute("listProductType"));
		model.addAttribute("listProductByType",listProductByType);
		model.addAttribute("size",listProductByType.size());
		model.addAttribute("productType",productType);
        return "product_type";
    }
	
	@GetMapping("/product/{id}")
    public String viewProductPage(ModelMap model,
    		@PathVariable String id) {
		
		Products product = productsService.findById(Integer.parseInt(id));
		//model.addAttribute("listProductType",_mvShare.getAttribute("listProductType"));
		model.addAttribute("product",product);
		List<Products> listProductByType = new ArrayList<Products>();
		listProductByType = productsService.findByProductType(product.getProductType().getId());
		model.addAttribute("listProductByType",listProductByType);
        return "product";
    }
    
}