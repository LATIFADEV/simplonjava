package com.manageremployee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {

	    @GetMapping("/login")
	    public String viewLoginPage() {
	        return "login";
	    }
	 
	    @GetMapping("/")
	    public String hello() {
	        return "home";
	    }
	

}
