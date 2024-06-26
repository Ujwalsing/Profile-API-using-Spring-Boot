package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.model.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}
