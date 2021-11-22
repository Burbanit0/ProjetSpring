package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.Developer;

@Service
public interface DeveloperService {
	public List<Developer> findAllDevelopers();
}
