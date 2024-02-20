package com.infotech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.entity.Job;
import com.infotech.service.JobService;

@RestController
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getJobs() {
		List<Job> jobs = jobService.getJobs();
		return new ResponseEntity<>(jobs, HttpStatus.OK);
	}

	@GetMapping("/jobs/{id}")
	public ResponseEntity<Job> getJob(@PathVariable("id") Long id) {
		Job job = jobService.getJob(id);
		return new ResponseEntity<>(job, HttpStatus.OK);
	}
    
	@PostMapping("/jobs")
	public ResponseEntity<String> createJob(@RequestBody Job job) {
		boolean status = jobService.createJob(job);
		if(status)
		return  new ResponseEntity<>("Job Successfully Saved", HttpStatus.OK);
		return  new ResponseEntity<>("Problem Occured in creating the Job", HttpStatus.BAD_REQUEST);
		
	}

	@PutMapping("/jobs/{id}")
	public ResponseEntity<String> updateJob(@PathVariable("id") Long id, @RequestBody Job job) {
		boolean status = jobService.updateJob(id,job);
		if(status)
		return  new ResponseEntity<>("Job Successfully Updated", HttpStatus.OK);
		return  new ResponseEntity<>("No Job Found to Update/Problem Occured in updating the Job", HttpStatus.BAD_REQUEST);
		
	}

	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<String> deleteJob(@PathVariable("id") Long id) {
		boolean status = jobService.deleteJob(id);
		if(status)
		return  new ResponseEntity<>("Job Successfully Deleted", HttpStatus.OK);
		return  new ResponseEntity<>("No Job Found to Delete/ Proble Occured while deleting", HttpStatus.BAD_REQUEST);
	}

}
