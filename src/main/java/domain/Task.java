package domain;

import domain.TaskStatus;
import domain.TaskStatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
public class Task {
    
    private @Id @GeneratedValue Long id;
    private String title;
    private int nbHoursForecast;
    private int nbHoursReal;
    private Date created;
    
    @ManyToOne
    private TaskType type;
    
    @ManyToOne
    private TaskStatus status;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Developer> developers;
    
    @OneToMany(mappedBy="task", cascade= {CascadeType.ALL}, orphanRemoval=true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ChangeLog> changeLogs;
    
    public Task() {
        this.developers = new HashSet<>();
        
        this.changeLogs = new HashSet<>();
    }
}