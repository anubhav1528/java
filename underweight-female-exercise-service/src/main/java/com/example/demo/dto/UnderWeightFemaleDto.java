package com.example.demo.dto;

public class UnderWeightFemaleDto {
	private String exerciseName;
	private int actual_amount;
	private int expected_amount;

	public UnderWeightFemaleDto() {
		super();
	}

	public UnderWeightFemaleDto(String exerciseName, int actual_amount, int expected_amount) {
		super();
		this.exerciseName = exerciseName;
		this.actual_amount = actual_amount;
		this.expected_amount = expected_amount;
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

	
}
