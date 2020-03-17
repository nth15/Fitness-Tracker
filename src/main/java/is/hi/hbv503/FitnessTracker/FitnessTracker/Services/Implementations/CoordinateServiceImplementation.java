package is.hi.hbv503.FitnessTracker.FitnessTracker.Services.Implementations;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Coordinate;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Repositories.CoordinateRepository;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinateServiceImplementation implements CoordinateService {

    CoordinateRepository repository;

    @Autowired
    public CoordinateServiceImplementation(CoordinateRepository coordinateRepository) {
        this.repository = coordinateRepository;
    }
}