package com.satisfactionrating.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satisfactionrating.model.Rating;
import com.satisfactionrating.repository.RatingRepository;

@Service
public class RatingService {
	
	@Autowired
	private RatingRepository ratingRepository;
	
	public Rating save(Rating rating) {
		return this.ratingRepository.save(rating);
	}
	
	public int getCount(String ratingType) {
		return this.ratingRepository.getCount(ratingType);
	}
}
