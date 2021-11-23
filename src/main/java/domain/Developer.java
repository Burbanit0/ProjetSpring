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
}

