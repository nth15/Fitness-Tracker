package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import java.util.Queue;
import javax.persistence.*;

public class Route {

    private String name;
    /** 
     * TODO queue eða eh annað 
     * */
    private Queue<Coordinate> polyline;

    public Route(String name, Queue<Coordinate> polyline) {
        this.name = name;
        this.polyline = polyline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue<Coordinate> getPolyline() {
        return polyline;
    }

    public void setPolyline(Queue<Coordinate> polyline) {
        this.polyline = polyline;
    }
}