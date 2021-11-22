package domain;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@Entity
public class Developer {
	
	@Id 
	@GeneratedValue
    private Long id;
	
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private LocalDate startContract;
    
    @ManyToMany(mappedBy="developers", fetch=FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Task> tasks;
    
    public Developer() {
        this.tasks = new HashSet<>();
    }
    
    public void addDeveloper(Long id, String firstname, String lastname, String password, String email, LocalDate startContract, Set<Task> tasks) {
		Developer dev = new Developer();
		dev.id = id;
		dev.setFirstname(firstname);
		dev.setLastname(lastname);
		dev.setPassword(password);
		dev.setEmail(email);
		dev.setStartContract(startContract);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getStartContract() {
		return startContract;
	}

	public void setStartContract(LocalDate startContract) {
		this.startContract = startContract;
	}
    
}

