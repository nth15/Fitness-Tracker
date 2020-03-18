package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import javax.persistence.*;

import javax.persistence.Entity;

/**
 * Coordinates to map out the route for Route
 * TODO JSON example object
 */
@Entity
public class Coordinate {

    private Double latitude;
    private Double longitude;

    public Coordinate(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}