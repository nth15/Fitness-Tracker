package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Strength extends Exercise
 * TODO JSON example object
 */
@Entity
public class Strength extends Exercise {
    
    @NotNull
    private int weight;
    @NotNull
    private int times;

    public Strength() { }

    public Strength(User user, int duration, Date date, String type, int weight, int times) {
        super(user, duration, date, type);
        this.weight = weight;
        this.times = times;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    } 

}