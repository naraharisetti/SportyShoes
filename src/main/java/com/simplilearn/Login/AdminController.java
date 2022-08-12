package com.simplilearn.Login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@GetMapping("/")
	public String Hello() {
		return "Hello World";
	}
	@GetMapping("/userlogin")
	public String loggedInUser() {
		return "I am a registered User and my account is protected";
	}
	@GetMapping("/adminlogin")
	public String adminUser() {
		return "Hello From Admin";
	}
}
