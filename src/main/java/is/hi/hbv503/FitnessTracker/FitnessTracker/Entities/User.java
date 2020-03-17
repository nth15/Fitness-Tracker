package is.hi.hbv503.FitnessTracker.FitnessTracker.Entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name = "USER")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public String userName;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private ArrayList<Exercise> userExercices;

    public ArrayList<Exercise> getUserExercice() {
        return userExercices;
    }

    public void setUserExercices(ArrayList<Exercise> exercices) {
        this.userExercices = exercices;
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

    public User(String userName, String password) {
        //super();
        this.userName = userName;
        this.password = password;
        this.userExercices = new ArrayList<Exercise>();
    }

    public void addExercice(Exercise exercise) {
        userExercices.add(exercise);
    }
}