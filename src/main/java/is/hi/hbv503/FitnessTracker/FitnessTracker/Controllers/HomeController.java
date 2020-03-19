package is.hi.hbv503.FitnessTracker.FitnessTracker.Controllers;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.*;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.ExerciseService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.UserService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Wrappers.Responses.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class HomeController {

    private ExerciseService exerciseService;
    private UserService userService;

    @Autowired
    public HomeController(ExerciseService exerciseService, UserService userService) {
        this.exerciseService = exerciseService;
        this.userService = userService;
    }
    
    /**
     * Home
     * @return
     */
    @RequestMapping("/")
    public ResponseEntity<GetExercisesResponse> Home() {
        return new ResponseEntity<>(new GetExercisesResponse(exerciseService.findAll()), HttpStatus.OK);
    }


    /**
     * Login user
     * Request object example:
     * {
     *     "userName": username,
     *     "password": password
     * }
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginAndSignUpResponse> loginPOST(@Valid @RequestBody User user, BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return new ResponseEntity<>(new LoginAndSignUpResponse(user, null, result.getFieldErrors()), HttpStatus.BAD_REQUEST);
        }
        User exists = userService.login(user);
        if(exists != null){
            session.setAttribute("LoggedInUser", user);
            return new ResponseEntity<>(new LoginAndSignUpResponse(user, "Login successful",null), HttpStatus.OK);
        }
        List<String> errors = new ArrayList<>();
        errors.add("Login unsuccessful");
        return new ResponseEntity<>(new LoginAndSignUpResponse(user, null, errors), HttpStatus.BAD_REQUEST);
    }

    
    /**
     * Sign up user
     * Request body example:
     * {
     *     "userName": username,
     *     "password": password
     * }
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<LoginAndSignUpResponse> signUpPOST(@Valid @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(new LoginAndSignUpResponse(user, null, result.getFieldErrors()), HttpStatus.BAD_REQUEST);
        }
        User exists = userService.findByUserName(user.userName);
        if(exists == null) {
            userService.save(user);
        } else {
            List<String> errors = new ArrayList<>();
            errors.add("Username already taken");
            return new ResponseEntity<>(new LoginAndSignUpResponse(user, null, errors), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new LoginAndSignUpResponse(user, "User created successfully", null), HttpStatus.CREATED);
    }


    @RequestMapping(value ="/addexercise", method = RequestMethod.POST)
    public ResponseEntity<AddExerciseResponse> addExercise(@Valid @RequestBody Exercise exercise, BindingResult result){
        if(result.hasErrors()){
            // TODO something with errors
            return new ResponseEntity<>(new AddExerciseResponse(null, result.getFieldErrors()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new AddExerciseResponse(exerciseService.save(exercise)), HttpStatus.CREATED);
    }

}