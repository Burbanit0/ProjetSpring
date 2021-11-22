package domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;
@Entity
public class ChangeLog {
	@Id
	@GeneratedValue
    private  Long id;
	
    private LocalDateTime occured;
    
    @ManyToOne
    @ToString.Exclude
    private Task task;
    
    @ManyToOne
    private TaskStatus targetStatus;
    
    @ManyToOne
    private TaskStatus sourceStatus;
    
    public ChangeLog() {
    }
}