package is.hi.hbv503.FitnessTracker.FitnessTracker.Repositories;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
    // TODO
}