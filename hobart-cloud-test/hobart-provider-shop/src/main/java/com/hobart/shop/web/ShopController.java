package com.hobart.shop.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
	
	@GetMapping(value="/listshop")
	public String listshop(){
		return "Shop list...";
	}
}
