package com.test.service;

import java.util.List;

import com.test.model.Profile;

public interface ProfileService {
	
	Profile saveProfile(Profile profile);
	
	List<Profile> findAll();
	
	void deleteProfile(long id);
	
	 Profile getProfileById(long id);
}
