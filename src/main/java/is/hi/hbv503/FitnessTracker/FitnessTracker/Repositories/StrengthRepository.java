package is.hi.hbv503.FitnessTracker.FitnessTracker.Repositories;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Strength;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StrengthRepository extends JpaRepository<Strength, Long> {
    
    Strength save(Strength strength);

}
