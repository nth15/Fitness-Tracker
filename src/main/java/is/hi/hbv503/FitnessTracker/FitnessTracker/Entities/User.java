package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;

import javax.persistence.*;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User conatins username, password and userExercises
 * TODO JSON example object
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String userName;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private ArrayList<Exercise> userExercises = new ArrayList<>();
    
    /**
     * Initializes user with empty userExercises
     * Used in development
     * @param userName
     * @param password
     */
    public User(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public ArrayList<Exercise> getUserExercises() {
        return userExercises;
    }

    public void setUserExercises(ArrayList<Exercise> exercises) {
        this.userExercises = exercises;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return userName;
    }

    public String getuserName() {
        return userName;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addExercise(Exercise exercise) {
        userExercises.add(exercise);
    }
}