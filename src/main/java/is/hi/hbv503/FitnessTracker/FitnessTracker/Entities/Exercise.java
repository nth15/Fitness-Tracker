package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private int duration;
    @NotNull
    private Date date;
    private String type;

    public Exercise() { }

    public Exercise(int duration, Date date, String type) {
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