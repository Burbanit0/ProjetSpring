package ServiceImpl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Constants;

import com.telecom.karban.LoadData;
import domain.Task;
import domain.TaskStatus;
import repository.TaskRepository;
import repository.TaskStatusRepository;
import repository.TaskTypeRepository;
import service.TaskService;

public class TaskServiceImpl {
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private TaskStatusRepository taskStatusRepository;
	
	@Autowired
	private TaskTypeRepository taskTypeRepository;

	@Override
	public Collection<Task> findAllTasks() {
		return this.taskRepository.findAll();
	}

	@Override
	public Optional<Task> findTask(Long id) {
		return this.taskRepository.findById(id);
	}

	@Override
	public Task moveRightTask(Task task) {
		
		String status = task.getTaskStatus().getLabel();
		
		if(status.equals("en attente")) {
			task.setTaskStatus(null);
			
		}else if (status.equals("en cours de developpement")) {
			task.setTaskStatus(null);
		}
		return taskRepository.save(task);
	}

	@Override
	public Task moveLeftTask(Task task) {
		
		String status = task.getTaskStatus().getLabel();
		
		if(status.equals("en cours de developpement")) {
			task.setTaskStatus(null);
		}else if (status.equals("terminé")) {
			task.setTaskStatus(null);
		}
		return taskRepository.save(task);

	}
}
