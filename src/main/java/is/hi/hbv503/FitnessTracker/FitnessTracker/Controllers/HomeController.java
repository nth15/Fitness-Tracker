package is.hi.hbv503.FitnessTracker.FitnessTracker.Controllers;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.*;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.ExerciseLogService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.ExerciseService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.time.*;
import java.util.Date;

@RestController
public class HomeController {

    private ExerciseService exerciseService;
    private ExerciseLogService exerciseLogService;
    private UserService userService;

    @Autowired
    public HomeController(ExerciseService exerciseService, ExerciseLogService exerciseLogService, UserService userService) {
        this.exerciseService = exerciseService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String Home() {
        return MovieService;
    }
}