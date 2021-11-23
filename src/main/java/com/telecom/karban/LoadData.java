package com.telecom.karban;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import domain.Developer;
import domain.Task;
import domain.TaskStatus;
import domain.TaskType;
import repository.DeveloperRepository;
import repository.TaskRepository;
import repository.TaskStatusRepository;
import repository.TaskTypeRepository;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadData {
	
	public static final long STATUS_1_ID = 0;
	public static final long STATUS_2_ID = 0;
	public static final long STATUS_3_ID = 0;
	
	
	@Bean
	@Profile("test")
	CommandLineRunner initDatabase(DeveloperRepository developerRepository, TaskRepository taskRepository,
			TaskStatusRepository taskStatusRepository, TaskTypeRepository taskTypeRepository) {
		return args -> {
			initTaskStatusAndTypes(taskStatusRepository, taskTypeRepository);
			initDevelopers(developerRepository);
			
			Developer dev2 = new Developer();
			dev2.setEmail("dev2@gmail.com");
			dev2.setFirstname("dev2");
			dev2.setLastname("dev_2");
			dev2.setStartContract(LocalDate.of(2019, Month.MARCH, 12));
			dev2.setPassword("dev2");
			developerRepository.save(dev2);
			
			Task task1 = new Task();
			task1.setCreated(LocalDate.now());
			task1.setTitle("task1");
			task1.setNbHoursForecast(0);
			task1.setNbHoursReal(0);
			task1.setTaskStatus(null);
			//task1.setTaskType(taskTypeRepository.findById(Constants.TASK_TYPE));
			task1.addDeveloper(dev2);
			taskRepository.save(task1);
			
		};
	}
	
	private void initDevelopers(DeveloperRepository developerRepository) {
		Developer dev1 = new Developer();
		dev1.setEmail("dev1@gmail.com");
		dev1.setFirstname("dev1");
		dev1.setLastname("dev_1");
		dev1.setStartContract(LocalDate.of(2021, Month.AUGUST, 6));
		dev1.setPassword("dev1");
		developerRepository.save(dev1);
		
	}
	
	private void initTaskStatusAndTypes(TaskStatusRepository taskStatusRepository, TaskTypeRepository taskTypeRepository) {
		TaskStatus enDev = new TaskStatus("en cours de developpement");
		taskStatusRepository.save(enDev);
		
		TaskStatus waiting = new TaskStatus("en attente");
		taskStatusRepository.save(waiting);
		
		TaskStatus finish = new TaskStatus("terminé");
		taskStatusRepository.save(finish);
		
		TaskType type1 = new TaskType("type1");
		taskTypeRepository.save(type1);
		
		TaskType type2 = new TaskType("type2");
		taskTypeRepository.save(type2);
	}
}
