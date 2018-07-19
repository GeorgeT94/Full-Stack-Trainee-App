package com.qa.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDB implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;


	public String getAllTrainees() {
		Query query = manager.createQuery("Select t FROM Trainee t");
		Collection<Trainee> Trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(Trainees);
	}


	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee aTrainee = util.getObjectForJSON(trainee, Trainee.class);
		manager.persist(aTrainee);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}


	@Transactional(REQUIRED)
	public String updateTrainee(Long id, String traineeToUpdate) {
		Trainee updatedTrainee = util.getObjectForJSON(traineeToUpdate, Trainee.class);
		Trainee TraineeFromDB = findTrainee(id);
		if (traineeToUpdate != null) {
			TraineeFromDB = updatedTrainee;
			manager.merge(TraineeFromDB);
		}
		return "{\"message\": \"Trainee sucessfully updated\"}";
	}


	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Trainee TraineeInDB = findTrainee(id);
		if (TraineeInDB != null) {
			manager.remove(TraineeInDB);
		}
		return "{\"message\": \"Trainee sucessfully deleted\"}";
	}

	private Trainee findTrainee(Long id) {
		return manager.find(Trainee.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
