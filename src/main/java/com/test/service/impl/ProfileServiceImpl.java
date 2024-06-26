package com.test.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.model.Profile;
import com.test.repository.ProfileRepository;
import com.test.service.ProfileService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfileServiceImpl implements ProfileService{
	private final ProfileRepository profileRepos;
	
	@Override
	public Profile saveProfile(Profile profile) {
		return profileRepos.save(profile);
	}

	@Override
	public List<Profile> findAll() {
		return profileRepos.findAll();
	}

	@Override
	public void deleteProfile(long id) {
		profileRepos.deleteById(id);
		
	}

	@Override
	public Profile getProfileById(long id) {
		return profileRepos.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
	}

}
