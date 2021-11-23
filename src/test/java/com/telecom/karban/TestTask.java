package com.telecom.karban;

import java.util.Collection;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import domain.Task;
import repository.TaskRepository;
import repository.TaskStatusRepository;
import repository.TaskTypeRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")

public class TestTask {
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Test
	public void testFindAllTasks() {
		Collection<Task> tasks = this.taskRepository.findAll();
		Assert.assertEquals(1, tasks.size());
	}	
}
