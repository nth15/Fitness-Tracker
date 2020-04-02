package is.hi.hbv503.FitnessTracker.FitnessTracker.Controllers;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.ExerciseService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.StrengthService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.CardioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.*;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Wrappers.Responses.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/exercise")    
public class ExerciseController {

    private ExerciseService exerciseService;
    private StrengthService strengthService;
    private CardioService cardioService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService, StrengthService strengthService, CardioService cardioService) {
        this.exerciseService = exerciseService;
        this.strengthService = strengthService;
        this.cardioService = cardioService;
    }

    /**
     * 
     * Return object example
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

    /**
     * Request object example:
     * {
     *      "id": id,
     *      "user": user,
     *      "duration": duration,
     *      "date": date,
     *      "type": type,
     *      "weight": weight,
     *      "times": times
     * }
     */
    @RequestMapping(value ="/addstrength", method = RequestMethod.POST)
    public ResponseEntity<AddStrengthResponse> addStrength(@Valid @RequestBody Strength strength, BindingResult result){
        if(result.hasErrors()){
            // TODO something with errors
            return new ResponseEntity<>(new AddStrengthResponse(null, result.getFieldErrors()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new AddStrengthResponse(strengthService.save(strength)), HttpStatus.CREATED);
    }

    /**
     * Request object example:
     * {
     *      "id": id,
     *      "user": user,
     *      "duration": duration,
     *      "date": date,
     *      "type": type,
     *      "topspeed": topspeed,
     *      "distance": distance,
     *      "route": route
     * }
     */
    @RequestMapping(value ="/addcardio", method = RequestMethod.POST)
    public ResponseEntity<AddCardioResponse> addCardio(@Valid @RequestBody Cardio cardio, BindingResult result){
        if(result.hasErrors()){
            // TODO something with errors
            return new ResponseEntity<>(new AddCardioResponse(null, result.getFieldErrors()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new AddCardioResponse(cardioService.save(cardio)), HttpStatus.CREATED);
    }

    /**
     *
     * @param id The exercise ID
     * @return a valid StatusCode with a message
     */
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteExercise(@PathVariable("id") long id){
        try {
            exerciseService.findById(id);
        }
        catch (Exception e){
            List<String> errors = new ArrayList<>();
            errors.add("No exercise with id: " + id + " exists");
            return new ResponseEntity<>(new DeleteExerciseResponse(null, errors), HttpStatus.NOT_FOUND);
        }
        exerciseService.delete(exerciseService.findById(id));
        return ResponseEntity.noContent().build();
    }
}