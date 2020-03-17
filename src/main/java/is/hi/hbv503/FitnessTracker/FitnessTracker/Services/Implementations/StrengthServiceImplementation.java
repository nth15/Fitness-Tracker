package is.hi.hbv503.FitnessTracker.FitnessTracker.Services.Implementations;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Strength;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Repositories.StrengthRepository;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.StrengthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrengthServiceImplementation implements StrengthService {

    StrengthRepository repository;

    @Autowired
    public StrengthServiceImplementation(StrengthRepository strengthRepository) {
        this.repository = strengthRepository;
    }
}