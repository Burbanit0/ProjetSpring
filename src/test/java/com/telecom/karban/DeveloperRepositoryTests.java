package com.telecom.karban;

import java.util.Collection;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import domain.Developer;
import repository.DeveloperRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {KanbanApplication.class})
@ActiveProfiles(profiles = "test")

public class DeveloperRepositoryTests {

	@Autowired
	private DeveloperRepository developerRepository;
		
	@Test
	public void testFindAllDevelopers() {
		Collection<Developer> tasks = this.developerRepository.findAll();
		Assert.assertEquals(2, tasks.size());
	}

	
}
