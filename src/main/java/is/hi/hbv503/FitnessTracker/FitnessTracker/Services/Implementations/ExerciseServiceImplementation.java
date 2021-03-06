package is.hi.hbv503.FitnessTracker.FitnessTracker.Services.Implementations;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Exercise;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Repositories.ExerciseRepository;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class ExerciseServiceImplementation implements ExerciseService {

    ExerciseRepository repository;

    @Autowired
    public ExerciseServiceImplementation(ExerciseRepository exerciseRepository) {
        this.repository = exerciseRepository;
    }

    @Override
    public Exercise save(Exercise exercise) {
        return repository.save(exercise);
    }

    @Override
    public void delete(Exercise exercise) {
        repository.delete(exercise);
    }

    @Override
    public Exercise findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Exercise> findAll() {
        return repository.findAll();
    }
}
