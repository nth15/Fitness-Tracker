package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Strength {
    @NotNull
    private int weight;
    @NotNull
    private int times;

    public Strength(int weight, int times) {
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