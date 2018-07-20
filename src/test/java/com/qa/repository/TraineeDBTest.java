package com.qa.repository;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.domain.Subject;
import com.qa.domain.Trainee;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class TraineeDBTest {
	
	private static final String MOCK_DATA_ARRAY = "[{\"firstName\":\"John\",\"secondName\":\"Doe\"}]";
	
	private static final String MOCK_OBJECT = "{\"firstName\":\"John\",\"secondName\":\"John\",\"subject\":[]}";
	
	@InjectMocks
	private TraineeDB repo;
	
	@Mock 
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	private JSONUtil util;
	
	@Before
	public void setUp() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	
	@Test
	public void testGetAllTrainees() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Trainee> trainees = new ArrayList<Trainee>();
		String[] subject = new String[0];
		trainees.add(new Trainee("John","Doe", subject));
		Mockito.when(query.getResultList()).thenReturn(trainees);
		assertEquals(MOCK_DATA_ARRAY, repo.getAllTrainees());	
	}
	
	@Test
	public void testCreateTrainee() {
		String reply = repo.createTrainee(MOCK_OBJECT); 
		assertEquals(reply,"{\"message\": \"Trainee has been sucessfully added\"}");
	}
	
	@Test
	public void testUpdateTrainee() { 
		String reply = repo.updateTrainee(1L, MOCK_OBJECT);
		assertEquals(reply, "{\"message\": \"Trainee sucessfully updated\"}");
	}
	
	@Test
	public void testDeleteAccount() {
		String reply = repo.deleteTrainee(1L);
		assertEquals(reply, "{\"message\": \"Trainee sucessfully deleted\"}");
	}
}
