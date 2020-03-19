package is.hi.hbv503.FitnessTracker.FitnessTracker.Services;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Exercise;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Strength;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Cardio;

import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface ExerciseService {

    Exercise save(Exercise exercise);
    void delete(Exercise exercise);
    Exercise findById(long id);
    List<Exercise> findAll();

}
