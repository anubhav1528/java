package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_track")
public class UnderWeightFemale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private int day;
	private String exerciseName;
	private int actual_amount;
	private int expected_amount;

	public UnderWeightFemale() {
		super();
	}

	public UnderWeightFemale(String email, int day, String exerciseName, int actual_amount, int expected_amount) {
		super();
		this.email = email;
		this.day = day;
		this.exerciseName = exerciseName;
		this.actual_amount = actual_amount;
		this.expected_amount = expected_amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public int getActual_amount() {
		return actual_amount;
	}

	public void setActual_amount(int actual_amount) {
		this.actual_amount = actual_amount;
	}

	public int getExpected_amount() {
		return expected_amount;
	}

	public void setExpected_amount(int expected_amount) {
		this.expected_amount = expected_amount;
	}

	@Override
	public String toString() {
		return "UnderWeightFemale [id=" + id + ", email=" + email + ", day=" + day + ", exerciseName=" + exerciseName
				+ ", actual_amount=" + actual_amount + ", expected_amount=" + expected_amount + "]";
	}

	
}
