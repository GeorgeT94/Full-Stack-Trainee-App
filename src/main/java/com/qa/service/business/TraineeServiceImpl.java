package com.qa.service.business;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.repository.TraineeRepository;

public class TraineeServiceImpl implements TraineeService {

	private static final Logger LOGGER = Logger.getLogger(TraineeService.class);

	@Inject
	private TraineeRepository repo;

	public String getAllTrainees() {
		LOGGER.info("In TraineeServiceImpl getAllTrainees ");
		return repo.getAllTrainees();
	}


	public String addTrainee(String Trainee) {
		return repo.createTrainee(Trainee);
	}


	public String updateTrainee(Long id, String Trainee) {
		return repo.updateTrainee(id, Trainee);
	}


	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);

	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}
}
