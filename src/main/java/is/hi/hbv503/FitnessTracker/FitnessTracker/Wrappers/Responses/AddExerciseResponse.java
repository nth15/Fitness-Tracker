package is.hi.hbv503.FitnessTracker.FitnessTracker.Wrappers.Responses;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Exercise;
import java.util.List;

/************************
 * Höfundur: Kristján P.*
 ************************/
public class AddExerciseResponse extends GenericResponse {
    private Exercise exercise;

    public AddExerciseResponse() { }

    public AddExerciseResponse(Exercise exercise) {
        this.exercise = exercise;
    }

    public AddExerciseResponse(String message, List<?> errors) {
        this(null, message, errors);
    }
    public AddExerciseResponse(Exercise exercise, String message, List<?> errors) {
        super(message, errors);
        this.exercise = exercise;
    }


    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
