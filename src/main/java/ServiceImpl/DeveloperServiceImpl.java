package ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Developer;
import repository.DeveloperRepository;
import service.DeveloperService;

@Service
public class DeveloperServiceImpl implements DeveloperService{
	
	@Autowired
	private DeveloperRepository developerRepository;
	
	@Override
	public List<Developer> findAllDevelopers() {
		return this.developerRepository.findAll();
	}
}
