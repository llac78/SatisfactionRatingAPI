package com.satisfactionrating.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.satisfactionrating.model.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	@Query(value = "SELECT COUNT(*) FROM rating WHERE rating_type = ?1 ", nativeQuery = true)
	public int getCount(String ratingType);

}
