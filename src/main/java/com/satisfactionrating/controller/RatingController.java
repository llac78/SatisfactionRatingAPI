package com.satisfactionrating.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.satisfactionrating.enums.RatingType;
import com.satisfactionrating.model.Rating;
import com.satisfactionrating.service.RatingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping
	public String index(Model model) {
		
		Rating rating = new Rating();
		model.addAttribute("rating", rating);
		
		return "index";
	}
	
	@PostMapping("/rate")
	public Rating rate(@RequestBody Rating rating) {
		return ratingService.save(rating);
	}
	
	@GetMapping("/types")
	public List<String> getTypes(){
		return Stream.of(RatingType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
	}
	
	@GetMapping("/good")
	public int getCountGood(String ratingGood) {
		return ratingService.getCount(RatingType.GOOD.name());
	}
	
	@GetMapping("/bad")
	public int getCountBad(String ratingBad) {
		return ratingService.getCount(RatingType.BAD.name());
	}
	
	@GetMapping("/notbad")
	public int getCountNotBad(String ratingNotBad) {
		return ratingService.getCount(RatingType.NOT_BAD.name());
	}
	
}
