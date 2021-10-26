package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>{

}
