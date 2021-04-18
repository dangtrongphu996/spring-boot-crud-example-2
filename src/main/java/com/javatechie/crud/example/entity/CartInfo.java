package com.javatechie.crud.example.entity;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {

	 private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
	 
	 public CartInfo() {
		 
	 }
	 public boolean isEmpty() {
	        return this.cartLines.isEmpty();
	    }
	 public void addProduct(Products productInfo, int quantity) {
	        CartLineInfo line = this.findLineByCode(productInfo.getId());
	        if (line == null) {
	            line = new CartLineInfo();
	            line.setQuantity(0);
	            line.setProducts(productInfo);
	            this.cartLines.add(line);
	        }
	        int newQuantity = line.getQuantity() + quantity;
	        if (newQuantity <= 0) {
	            this.cartLines.remove(line);
	        } else {
	            line.setQuantity(newQuantity);
	        }
	    }
	 
	 	private CartLineInfo findLineByCode(Integer code) {
	        for (CartLineInfo line : this.cartLines) {
	            if (line.getProducts().getId() == code) {
	                return line;
	            }
	        }
	        return null;
	    }
	 	
	 	public void updateProduct(Integer code, int quantity) {
	        CartLineInfo line = this.findLineByCode(code);
	 
	        if (line != null) {
	            if (quantity <= 0) {
	                this.cartLines.remove(line);
	            } else {
	                line.setQuantity(quantity);
	            }
	        }
	    }
	 
	    public void removeProduct(Products productInfo) {
	        CartLineInfo line = this.findLineByCode(productInfo.getId());
	        if (line != null) {
	            this.cartLines.remove(line);
	        }
	    }
	    
	    public int getQuantityTotal() {
	        int quantity = 0;
	        for (CartLineInfo line : this.cartLines) {
	            quantity += line.getQuantity();
	        }
	        return quantity;
	    }
	    
	    public double getAmountTotal() {
	        double total = 0;
	        for (CartLineInfo line : this.cartLines) {
	            total += line.getAmount();
	        }
	        return total;
	    }
	    
	    public void updateQuantity(CartInfo cartForm) {
	        if (cartForm != null) {
	            List<CartLineInfo> lines = cartForm.getCartLines();
	            for (CartLineInfo line : lines) {
	                this.updateProduct(line.getProducts().getId(), line.getQuantity());
	            }
	        }
	 
	    }
	    
	    public List<CartLineInfo> getCartLines() {
	        return this.cartLines;
	    }
}
