package is.hi.hbv503.FitnessTracker.FitnessTracker.Wrappers.Responses;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Exercise;
import org.springframework.validation.ObjectError;

import java.util.List;

/************************
 * Höfundur: Kristján P.*
 ************************/
public class GetAllExercisesResponse extends GenericResponse {

    private List<Exercise> exercises;

    public GetAllExercisesResponse(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public GetAllExercisesResponse(List<Exercise> exercises, String message, List<ObjectError> errors) {
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
