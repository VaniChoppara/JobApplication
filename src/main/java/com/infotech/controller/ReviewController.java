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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infotech.entity.Review;
import com.infotech.service.ReviewService;

@RestController
@RequestMapping("/companies/{cid}")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getReviews(@PathVariable("cid") Long cid) {
		List<Review> reviews = reviewService.getReviews(cid);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	@GetMapping("/reviews/{id}")
	public ResponseEntity<Review> getReview(@PathVariable("cid") Long cid,@PathVariable("id") Long id) {
		Review review = reviewService.getReview(cid,id);
		return new ResponseEntity<>(review, HttpStatus.OK);
	}
    
	@PostMapping("/reviews")
	public ResponseEntity<String> createReview(@PathVariable("cid") Long cid, @RequestBody Review review) {
		boolean status = reviewService.createReview(cid, review);
		if(status)
		return  new ResponseEntity<>("Review Successfully Saved", HttpStatus.OK);
		return  new ResponseEntity<>("Problem Occured in creating the Review", HttpStatus.BAD_REQUEST);
		
	}

	@PutMapping("/reviews/{id}")
	public ResponseEntity<String> updateReview(@PathVariable("cid") Long cid,@PathVariable("id") Long id, @RequestBody Review review) {
		boolean status = reviewService.updateReview(cid,id,review);
		if(status)
		return  new ResponseEntity<>("Review Successfully Updated", HttpStatus.OK);
		return  new ResponseEntity<>("No Review Found to Update/Problem Occured in updating the Review", HttpStatus.BAD_REQUEST);
		
	}

	@DeleteMapping("/reviews/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable("cid") Long cid,@PathVariable("id") Long id) {
		boolean status = reviewService.deleteReview(cid, id);
		if(status)
		return  new ResponseEntity<>("Review Successfully Deleted", HttpStatus.OK);
		return  new ResponseEntity<>("No Review Found to Delete/ Problem Occured while deleting", HttpStatus.BAD_REQUEST);
	}

}
