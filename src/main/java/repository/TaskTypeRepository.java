package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.TaskType;

@Repository
public interface TaskTypeRepository extends JpaRepository<TaskType, Long>{

}
