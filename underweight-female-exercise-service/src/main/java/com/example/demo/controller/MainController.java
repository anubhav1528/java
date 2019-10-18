package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UnderWeightFemale;
import com.example.demo.service.UnderWeightService;

@RestController
@CrossOrigin
public class MainController {

	@Autowired
	UnderWeightService overWeightService;
	
	@GetMapping("/workout/{email}")
	public ResponseEntity<?> getAll(@PathVariable("email") String email){
		System.out.println(email);
		return ResponseEntity.ok(overWeightService.getWorkout(email));
	}
	
	@PostMapping("/workout")
	public ResponseEntity<?> postWorkout(@RequestBody UnderWeightFemale female){
		System.out.println(female.toString());
		return ResponseEntity.ok(overWeightService.addworkout(female));
	}
}
