package com.qa.service.business;

public interface TraineeService {

	String getAllTrainees();

	String addTrainee(String Trainee);

	String updateTrainee(Long id, String Trainee);

	String deleteTrainee(Long id);

}