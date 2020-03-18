package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Route object used by Cardio to map out a Route
 * with a Queue<Coordinate>
 * TODO JSON example object
 */
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;
    @OneToMany(mappedBy = "route")
    private List<Coordinate> polyline = new ArrayList<>();

    public Route() { }

    public Route(String name, List<Coordinate> polyline) {
        this.name = name;
        this.polyline = polyline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Coordinate> getPolyline() {
        return polyline;
    }

    public void setPolyline(List<Coordinate> polyline) {
        this.polyline = polyline;
    }
}