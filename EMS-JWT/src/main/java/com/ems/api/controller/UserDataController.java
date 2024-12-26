package com.ems.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.api.entity.UserData;
import com.ems.api.service.UserDataService;

@RestController
@RequestMapping(value = "/api/user")
public class UserDataController {
	
	@Autowired
	private UserDataService dataService;
	
	@PostMapping("/add")
	Map<String, Object> addEmp(@RequestBody UserData user){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", dataService.save(user));
		} catch (Exception e) {
			obj.put("Status", "Fail");
			obj.put("Message", e);
		}
		return obj;
	}
	
	@GetMapping("/getAll")
	Map<String, Object> getAllUsers(){
		Map<String, Object> obj = new HashMap<>();
		try {
			obj.put("Status", "Success");
			obj.put("Data", dataService.getAll());
		} catch (Exception e) {
			obj.put("Status", "Fail");
			obj.put("Message", e);
		}
		return obj;
	}

}
