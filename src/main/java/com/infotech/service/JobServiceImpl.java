package com.infotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.entity.Job;
import com.infotech.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	JobRepository jobRepo;
	
	@Override
	public List<Job> getJobs() {
		// TODO Auto-generated method stub
		return jobRepo.findAll();
	}

	@Override
	public Job getJob(Long id) {
		// TODO Auto-generated method stub
		return jobRepo.findById(id).orElse(null);
	}

	@Override
	public boolean createJob(Job job) {
		Job save = jobRepo.save(job);
		if(save!=null)
			return true;
		return false;
	}

	@Override
	public boolean updateJob(Long id, Job job) {
		Optional<Job> findById = jobRepo.findById(id);
		if(findById.isPresent()){
			Job existingJob = findById.get();
			existingJob.setTitle(job.getTitle());
			existingJob.setDescription(job.getDescription());
			existingJob.setMinSalary(job.getMinSalary());
			existingJob.setMaxSalary(job.getMaxSalary());
			existingJob.setLocation(job.getLocation());
			jobRepo.save(existingJob);	
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteJob(Long id) {
		Optional<Job> findById = jobRepo.findById(id);
		if(findById.isPresent()){
			jobRepo.deleteById(id);	
			return true;
		}
		return false;
	}
      
}
