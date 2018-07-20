package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Subject {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Pattern(regexp="^[a-zA-Z]{1,20}$", message="1-20 CHARACTERS NO NUMBERS OR SYMBOLS")
	private String subjectName;
	@Min(value = 0, message = "The value must be positive")
	@Max(value = 5, message = "The value cannot be greater than 5")	
	private int rating;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Subject() {

	}

	public Subject(String subjectName, int rating) {
		this.subjectName = subjectName;
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	
}