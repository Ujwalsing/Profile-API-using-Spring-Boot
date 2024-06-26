package com.test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.test.model.Profile;
import com.test.service.ProfileService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/profile")
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")

public class ProfileController {
	private final ProfileService profileService;
	
	@PostMapping
	public ResponseEntity<Profile> postProfile(@RequestBody Profile profile){
		log.info("POST request for saving Profile: {}", profile);
		Profile savedProfile = profileService.saveProfile(profile);
		return ResponseEntity.ok(savedProfile);
	}
	
	@GetMapping
	public ResponseEntity<List<Profile>> getAllProfiles(){
		log.info("GET request for fetching all Profiles");
		List<Profile> getAllList = profileService.findAll();
		return ResponseEntity.ok(getAllList);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProfile(@PathVariable long id){
		profileService.deleteProfile(id);
		return new ResponseEntity<String>("Id deleted succesfully",HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Profile> getProfileById(@PathVariable long id){
		return ResponseEntity.ok(profileService.getProfileById(id));
	}
}
