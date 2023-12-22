package com.webapplication.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapplication.entity.User;
import com.webapplication.payload.ResponseBody;
import com.webapplication.service.UserService;

@RestController

public class HomeController {
	@Autowired
	private UserService userService;
	//testing purpose
	@GetMapping("/")
	public String home() {
		return "welcome to spring boot registation process!!";
	}
	@PostMapping("/saveUser")
	public ResponseEntity<ResponseBody<User>> saveUser(@RequestBody User user) {
	    User createdUser = userService.saveUser(user);
	 
	    ResponseBody<User> responseBody = new ResponseBody<>();
	    responseBody.setStatuscode(HttpStatus.OK.value());
	    responseBody.setStatus("SUCCESS");
	    responseBody.setData(createdUser);
	 
	    return ResponseEntity.ok(responseBody);
	}
	
}


