package is.hi.hbv503.FitnessTracker.FitnessTracker.Services;

import java.util.List;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.Exercise;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.User;

public interface UserService {
    
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByUserName(String userName);
    User login(User user);
    Exercise save(Exercise exercise);

}
