package domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Task {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private int nbHoursForecast;
	private int nbHoursReal;
	private LocalDate created;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<Developer> developers;
	
	@ManyToOne
	private TaskStatus taskStatus;
	
	@ManyToOne
	private TaskType taskType;
	
	@ManyToMany(mappedBy="task",cascade={CascadeType.ALL})
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private Set<ChangeLog> changeLogs;
	
	public Task() {
		this.developers = new HashSet<>();
		this.changeLogs = new HashSet<>();
	}
	
	public void addDeveloper(Developer developer) {
		this.developers.add(developer);
	}
}
    