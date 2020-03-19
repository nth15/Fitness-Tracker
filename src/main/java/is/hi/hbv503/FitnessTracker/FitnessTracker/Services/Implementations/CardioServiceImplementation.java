package is.hi.hbv503.FitnessTracker.FitnessTracker.Services.Implementations;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Cardio;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Repositories.CardioRepository;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.CardioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardioServiceImplementation implements CardioService {

    CardioRepository repository;

    @Autowired
    public CardioServiceImplementation(CardioRepository cardioRepository) {
        this.repository = cardioRepository;
    }

    
    @Override
    public Cardio save(Cardio strength) {
        return repository.save(strength);
    }
}