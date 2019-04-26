package com.example.hibernateapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.hibernateapp.entity.User;
import com.example.hibernateapp.service.UserService;

@RestController
@RequestMapping(value= {"/user"})
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping(value="{/id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		User user = userService.findById(id);
		
		if(user == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
		
	}
	
	
	@PostMapping(name="{/create}", headers="Accept=application/json")
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
		userService.createUser(user);
		
		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<>(header, HttpStatus.CREATED);
	}
	 
}
