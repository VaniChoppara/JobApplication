package com.infotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infotech.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
	List<Review> findByCompanyId(Long cid);

}
