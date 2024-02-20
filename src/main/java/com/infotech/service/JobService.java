package com.infotech.service;

import java.util.List;

import com.infotech.entity.Job;

public interface JobService {
	 List<Job> getJobs();
	 Job getJob(Long id);
	 boolean createJob(Job job);
	 boolean updateJob(Long id, Job job);
	 boolean deleteJob(Long id);
}
