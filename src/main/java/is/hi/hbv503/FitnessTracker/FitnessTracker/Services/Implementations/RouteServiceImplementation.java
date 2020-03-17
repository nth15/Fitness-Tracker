package is.hi.hbv503.FitnessTracker.FitnessTracker.Services.Implementations;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Route;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Repositories.RouteRepository;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImplementation implements RouteService {

    RouteRepository repository;

    @Autowired
    public RouteServiceImplementation(RouteRepository routeRepository) {
        this.repository = routeRepository;
    }
}