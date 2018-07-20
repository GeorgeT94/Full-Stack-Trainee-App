package com.qa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Pattern(regexp="^[a-zA-Z]{1,20}$", message="1-20 CHARACTERS NO NUMBERS OR SYMBOLS")
	private String firstName;
	@Pattern(regexp="^[a-zA-Z]{1,20}$", message="1-20 CHARACTERS NO NUMBERS OR SYMBOLS")
	private String secondName;
	@JoinColumn(name = "trainee_id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Subject> subject;

	public Trainee() {

	}

	public Trainee(String firstName, String secondName, String[] subjectRatings) {
		this.firstName = firstName;
		this.secondName = secondName;
	
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
