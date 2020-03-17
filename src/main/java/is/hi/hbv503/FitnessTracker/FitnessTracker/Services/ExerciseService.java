package is.hi.hbv503.FitnessTracker.FitnessTracker.Services;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Exercise;

import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface ExerciseService {
    Exercise save(Exercise exercise);
    void delete(Exercise exercise);
    List<Exercise> getCardio();
    List<Exercise> getStrength();
    List<Exercise> findAll();
    List<Exercise> findByType(String type);
    List<Exercise> findByPeriod(Date start, Date end);
    List<Exercise> findByRoute(String name);
    Optional<Exercise> findById(long  id);
}
