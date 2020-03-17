package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Cardio extends Exercise {

    private int topSpeed;
    @NotNull
    private int distance;
    private Route route;

    public Cardio(int topSpeed,int distance, Route route) {
        this.topSpeed = topSpeed;
        this.distance = distance;
        this.route = route;
    }

    public Cardio(Cardio cardio) { }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}