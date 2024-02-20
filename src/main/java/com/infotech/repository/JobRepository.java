package com.infotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
