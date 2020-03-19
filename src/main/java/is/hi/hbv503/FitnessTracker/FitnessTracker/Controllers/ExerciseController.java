package is.hi.hbv503.FitnessTracker.FitnessTracker.Controllers;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.ExerciseService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.StrengthService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.CardioService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.*;
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
@RequestMapping("/exercise")
public class ExerciseController {

    private UserService userService;
    private ExerciseService exerciseService;
    private StrengthService strengthService;
    private CardioService cardioService;

    @Autowired
    public ExerciseController(UserService userService, ExerciseService exerciseService) {
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    /**
     * 
     * Request object example:
     * [
     *      {
     *      "id": id,
     *      "duration": duration,
     *      "date": date,
     *      "type": type,
     *      "topspeed": topspeed,
     *      "distance": distance,
     *      "route": route
     *      },
     *      {
     *      "id": id,
     *      "duration": duration,
     *      "date": date,
     *      "type": type,
     *      "weight": weight,
     *      "times": times
     *      }
     * ]
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<GetAllExercisesResponse> exerciseList(@Valid @RequestBody User user, BindingResult result, HttpSession session){
        return new ResponseEntity<>(new GetAllExercisesResponse(exerciseService.findAll()), HttpStatus.OK);
    }


    @RequestMapping(value ="/addstrength", method = RequestMethod.POST)
    public ResponseEntity<AddStrengthResponse> addStrength(@Valid @RequestBody Strength strength, BindingResult result){
        if(result.hasErrors()){
            // TODO something with errors
            return new ResponseEntity<>(new AddStrengthResponse(null, result.getFieldErrors()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new AddStrengthResponse(strengthService.save(strength)), HttpStatus.CREATED);
    }

    

    @RequestMapping(value ="/addcardio", method = RequestMethod.POST)
    public ResponseEntity<AddCardioResponse> addCardio(@Valid @RequestBody Cardio cardio, BindingResult result){
        if(result.hasErrors()){
            // TODO something with errors
            return new ResponseEntity<>(new AddCardioResponse(null, result.getFieldErrors()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new AddCardioResponse(cardioService.save(cardio)), HttpStatus.CREATED);
    }
}