package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Exercise object Extended by Cardio and Strength
 * TODO JSON example object
 */
@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonIgnoreProperties("user")
    private User user;

    @NotNull
    private int duration;
    @NotNull
    private Date date;
    private String type;

    public Exercise() { }

    public Exercise(User user, int duration, Date date, String type) {
        this.user = user;
        this.duration = duration;
        this.date = date;
        this.type = type;
    }

    public Exercise(Exercise exercise) { }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}