package com.infotech.service;

import java.util.List;

import com.infotech.entity.Review;

public interface ReviewService {
	 List<Review> getReviews(Long cid);
	 Review getReview(Long cid,Long id);
	 boolean createReview(Long cid,Review review);
	 boolean updateReview(Long cid,Long id, Review review);
	 boolean deleteReview(Long cid,Long id);
}
