package com.infotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.entity.Company;
import com.infotech.entity.Job;
import com.infotech.entity.Review;
import com.infotech.repository.ReviewRepository;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	ReviewRepository reviewRepo;
	
	@Autowired
	CompanyService companyService;
	
	@Override
	public List<Review> getReviews(Long cid) {
		return reviewRepo.findByCompanyId(cid);
	}

	@Override
	public Review getReview(Long cid,Long id) {
		List<Review> reviews = reviewRepo.findByCompanyId(cid);		
		return reviews.stream()
				.filter(r->r.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public boolean createReview(Long cid,Review review) {
		Company company= companyService.getCompany(cid);
		review.setCompany(company);
		Review save = reviewRepo.save(review);
		if(save!=null)
			return true;
		return false;
	}

	@Override
	public boolean updateReview(Long cid,Long id, Review review) {
		Company company= companyService.getCompany(cid);
		if(company!=null) {
			review.setCompany(company);
			review.setId(id);
			reviewRepo.save(review);
			return true;
		}
			return false;

}


	@Override
	public boolean deleteReview(Long cid,Long id) {
		Optional<Review> findById = reviewRepo.findById(id);
		Company company= companyService.getCompany(cid);
		if(company!=null && findById.isPresent()){
			reviewRepo.deleteById(id);	
			return true;
		}
		return false;	}
	}