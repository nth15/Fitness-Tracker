package is.hi.hbv503.FitnessTracker.FitnessTracker.Wrappers.Responses;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Exercise;
import org.springframework.validation.ObjectError;

import java.util.List;

public class GetExercisesResponse extends GenericResponse {

    private List<Exercise> exercises;

    public GetExercisesResponse(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public GetExercisesResponse(List<Exercise> exercises, String message, List<ObjectError> errors) {
        super(message, errors);
        this.exercises = exercises;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
