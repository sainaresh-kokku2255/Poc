package com.user.job.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.job.model.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {

	public List<Job> findByJobType(String jobType);
	
	
	public List<Job> findByExperience(int experience);

	public List<Job> findByCountry(String country);

	public List<Job> findByAvailability(String availability);
	
	public List<Job> findBySkills(String skills);

}
