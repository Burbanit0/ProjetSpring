package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.ChangeLog;

@Repository
public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long>{
	
}
