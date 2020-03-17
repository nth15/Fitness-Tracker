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
    public List<Exercise> getCardio() {
        return repository.getCardio();
    }

    @Override
    public List<Exercise> getStrength() {
        return repository.getStrength();
    }

    @Override
    public List<Exercise> findAll() {
        return repository.findAll();
    }    

    @Override
    public List<Exercise> findByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public List<Exercise> findByPeriod(Date start, Date end) {
        return repository.findByPeriod(start, end);
    }

    @Override
    public List<Exercise> findByRoute(String name) {
        return repository.findByRoute(name);
    }
    
    @Override
    public Optional<Exercise> findById(long id) {
        return repository.findById(id);
    }
}
