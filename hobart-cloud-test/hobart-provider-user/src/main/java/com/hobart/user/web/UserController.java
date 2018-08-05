package com.hobart.user.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping(value="/listuser")
	public String listuser(){
		return "User list...";
	}
}
