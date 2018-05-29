package com.celnet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.celnet.entity.User;
import com.celnet.restservice.UserService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class UserController {
	@Autowired
	public UserService userservice;
	
	@RequestMapping(value="/userlist",method=RequestMethod.GET)
	public List<User> list() {
		List<User> list_user = userservice.findAll();
		return list_user;
	}
}