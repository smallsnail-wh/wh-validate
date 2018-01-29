package com.wh.validate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@PostMapping("/login")
	public String login() {
		return "SUCCESS";
	}	
	
	@PostMapping("/logintest")
	public String loginTest() {
		return "SUCCESS";
	}
	
}
