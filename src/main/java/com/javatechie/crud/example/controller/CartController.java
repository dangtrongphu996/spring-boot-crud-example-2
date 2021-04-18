package com.javatechie.crud.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatechie.crud.example.entity.BillDetail;
import com.javatechie.crud.example.entity.Bills;
import com.javatechie.crud.example.entity.Cart;
import com.javatechie.crud.example.entity.CartInfo;
import com.javatechie.crud.example.entity.CartLineInfo;
import com.javatechie.crud.example.entity.Products;
import com.javatechie.crud.example.entity.Utils;
import com.javatechie.crud.example.repository.BillDetailRepository;
import com.javatechie.crud.example.repository.BillsRepository;
import com.javatechie.crud.example.service.ProductsService;

@Controller
@RequestMapping(value = "cart")
public class CartController extends BaseController{

	@Autowired
    private ProductsService productsService;
	
	@Autowired 
	private BillDetailRepository billDetailRepository; 
	
	@Autowired 
	private BillsRepository billsRepository; 
	
	@RequestMapping(value = "add/{id}", method = RequestMethod.GET)
    public String viewAdd(ModelMap mm, HttpSession session, @PathVariable("id") Integer id) {
        HashMap<Integer, Cart> cartItems = (HashMap<Integer, Cart>) session.getAttribute("myCartItems");
        if (cartItems == null) {
            cartItems = new HashMap<>();
        }
        Products product = productsService.findById(id);
        if (product != null) {
            if (cartItems.containsKey(id)) {
                Cart item = cartItems.get(id);
                item.setProducts(product);
                item.setQuantity(item.getQuantity() + 1);
                cartItems.put(id, item);
            } else {
                Cart item = new Cart();
                item.setProducts(product);
                item.setQuantity(1);
                cartItems.put(id, item);
            }
        }
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", totalPrice(cartItems));
        session.setAttribute("myCartNum", cartItems.size());
        return "redirect:/";
    }
	
	@RequestMapping({ "/removeCart/{id}" })
    public String removeProductHandler(HttpServletRequest request,HttpSession session, Model model, //
            @PathVariable Integer id) {
        
		Products product = null;
        if (id != null) {
        	
        	product = productsService.findById(id);
        }
        if (product != null) {
 
            CartInfo cartInfo = Utils.getCartInSession(request);
 
            Products productInfo = product;
 
            cartInfo.removeProduct(productInfo);
            session.setAttribute("myCartItems", cartInfo.getCartLines());
            session.setAttribute("myCartTotal", cartInfo.getAmountTotal());
            session.setAttribute("myCartNum", cartInfo.getQuantityTotal());
        }
        return "redirect:/cart/shoppingCart";
    }
	
	@RequestMapping({ "/buy/{code}" })
    public String listProductHandler(HttpServletRequest request,HttpSession session,Model model,
    		@PathVariable("code") Integer code) {
 
        Products product = null;
        if (code != null) {
            product = productsService.findById(code);
        }
        CartInfo cartInfo = Utils.getCartInSession(request);
        if (product != null) {

            Products productInfo = product;
 
            cartInfo.addProduct(productInfo, 1);
        }
        session.setAttribute("myCartItems", cartInfo.getCartLines());
        session.setAttribute("myCartTotal", cartInfo.getAmountTotal());
        session.setAttribute("myCartNum", cartInfo.getQuantityTotal());
        return "redirect:/cart/shoppingCart";
    }
    @RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.GET)
    public String shoppingCartHandler(HttpServletRequest request, Model model) {
        CartInfo myCart = Utils.getCartInSession(request);
        if(myCart.isEmpty()) {
        	
        	return "redirect:/";
        }
        //model.addAttribute("listProductType",_mvShare.getAttribute("listProductType"));
        model.addAttribute("cartForm", myCart);
        return "checkout1";
    }
    
    // POST: Gửi đơn hàng (Save).
    @RequestMapping(value = { "/shoppingCartConfirmation" }, method = RequestMethod.GET)
    public String shoppingCartConfirmationSave(HttpServletRequest request,HttpSession session, Model model) {
        CartInfo cartInfo = Utils.getCartInSession(request);
 
        if (cartInfo == null || cartInfo.isEmpty()) {
 
            return "redirect:/shoppingCart";
        } 
        int i = 0;
        List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
        try {
        	Bills bills = new Bills(i, new java.util.Date(),(float)cartInfo.getAmountTotal() , "Tiền mặt", "không có");
        	billsRepository.save(bills);
        	cartLines = cartInfo.getCartLines();
        	for (CartLineInfo cartLineInfo : cartLines) {
        		BillDetail billDetail = new BillDetail(i, bills.getId(), cartLineInfo.getProducts().getId(), cartLineInfo.getQuantity(),cartLineInfo.getProducts().getUnit_price());
            	billDetailRepository.save(billDetail);
            	i++;
			}
        	
        	
        } catch (Exception e) {
 
            return "redirect:/";
        }
 
        // Xóa giỏ hàng khỏi session.
        Utils.removeCartInSession(request);
        session.removeAttribute("myCartItems");
        session.removeAttribute("myCartTotal");
        session.removeAttribute("myCartNum");
        // Lưu thông tin đơn hàng cuối đã xác nhận mua.
        Utils.storeLastOrderedCartInSession(request, cartInfo);
 
        return "redirect:/";
    }
	public double totalPrice(HashMap<Integer, Cart> cartItems) {
        int count = 0;
        for (Map.Entry<Integer, Cart> list : cartItems.entrySet()) {
            count += list.getValue().getProducts().getUnit_price() * list.getValue().getQuantity();
        }
        return count;
    }
	
	@RequestMapping(value = { "/shoppingCart" }, method = RequestMethod.POST)
    public String shoppingCartUpdateQty(HttpServletRequest request,HttpSession session, //
            Model model, //
            @ModelAttribute("cartForm") CartInfo cartForm) {
 
        CartInfo cartInfo = Utils.getCartInSession(request);
        cartInfo.updateQuantity(cartForm);
        session.setAttribute("myCartItems", cartInfo.getCartLines());
        session.setAttribute("myCartTotal", cartInfo.getAmountTotal());
        session.setAttribute("myCartNum", cartInfo.getQuantityTotal());
        return "redirect:/cart/shoppingCart";
    }
	
	@GetMapping("/checkout")
    public String viewCheckoutPage(ModelMap model,HttpSession session) {
		
		/*
		 * Products product = productsService.findById(Integer.parseInt(id));
		 * model.addAttribute("listProductType",_mvShare.getAttribute("listProductType")
		 * ); model.addAttribute("product",product); List<Products> listProductByType =
		 * new ArrayList<Products>(); listProductByType =
		 * productsService.findByProductType(product.getProductType().getId());
		 * model.addAttribute("listProductByType",listProductByType);
		 */
		session.setAttribute("myCartItems", session.getAttribute("myCartItems"));
        session.setAttribute("myCartTotal", session.getAttribute("myCartTotal"));
        session.setAttribute("myCartNum", session.getAttribute("myCartNum"));
		//model.addAttribute("listProductType",_mvShare.getAttribute("listProductType"));
		model.addAttribute("myCartItems",session.getAttribute("myCartItems"));
        return "checkout";
    }
	
	@PostMapping("/checkout")
    public String viewPostCheckoutPage(ModelMap model,HttpSession session, HttpServletRequest request,@ModelAttribute("cart")Cart cart) {
		
		/*
		 * Products product = productsService.findById(Integer.parseInt(id));
		 * model.addAttribute("listProductType",_mvShare.getAttribute("listProductType")
		 * ); model.addAttribute("product",product); List<Products> listProductByType =
		 * new ArrayList<Products>(); listProductByType =
		 * productsService.findByProductType(product.getProductType().getId());
		 * model.addAttribute("listProductByType",listProductByType);
		 */
		session.setAttribute("myCartItems", session.getAttribute("myCartItems"));
        session.setAttribute("myCartTotal", session.getAttribute("myCartTotal"));
        session.setAttribute("myCartNum", session.getAttribute("myCartNum"));
		//model.addAttribute("listProductType",_mvShare.getAttribute("listProductType"));
		model.addAttribute("myCartItems",session.getAttribute("myCartItems"));
        return "checkout";
    }
}
