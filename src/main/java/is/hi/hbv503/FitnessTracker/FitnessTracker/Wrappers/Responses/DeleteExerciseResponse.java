package is.hi.hbv503.FitnessTracker.FitnessTracker.Wrappers.Responses;

import java.util.List;

/************************
 * Höfundur: Kristján P.*
 ************************/
public class DeleteExerciseResponse extends GenericResponse {

    public DeleteExerciseResponse() { }

    public DeleteExerciseResponse(String message, List<?> errors) {
        super(message, errors);
    }
}
