package is.hi.hbv503.FitnessTracker.FitnessTracker.Controllers;

import is.hi.hbv503.FitnessTracker.FitnessTracker.Entities.*;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.StrengthService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.CardioService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Services.UserService;
import is.hi.hbv503.FitnessTracker.FitnessTracker.Wrappers.Responses.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.time.ZoneId;


@RestController
@RequestMapping("/makedata")
public class MakeData {

    private UserService userService;
    private CardioService cardioService;
    private StrengthService strengthService;

    @Autowired
    public MakeData() { }
    
    /**
     * Creates sample data to work with in development
     * @return 
     */
    @RequestMapping("/")
    public ResponseEntity<GetUserResponse> makeData(){
        User user = new User("kisi", "pass123");

        User exists = userService.findByUserName(user.userName);
        if(exists == null) {
            userService.save(user);
        } else {
            List<String> errors = new ArrayList<>();
            errors.add("Username already taken");
            return new ResponseEntity<>(new GetUserResponse(user, null, errors), HttpStatus.BAD_REQUEST);
        }
        Cardio c = null;
        Strength s = null;

        String startDate = "2020-01-01";
        LocalDate l = LocalDate.parse(startDate);
        ZoneId defaultZoneId = ZoneId.systemDefault();
        
        for (int i = 0; i < 40; i++) {
            Date d = Date.from(l.plusDays(i).atStartOfDay(defaultZoneId).toInstant());
            int r = (int)Math.round(Math.random());
            switch(r) {
                case 0: c = genCardio(user,d);
                        cardioService.save(c);
                        break;
                case 1: s = genStrength(user, d);
                        strengthService.save(s);
                        break;
            }
        }
        return new ResponseEntity<>(new GetUserResponse(user, "User created successfully", null), HttpStatus.CREATED);
    }

    // Cardio(Exercise(int duration, Date date, String type), duration, topspeed, distance)
    public Cardio genCardio(User user, Date date) {
        String[] t = {"Bikeriding", "running"};
        int duration = (int)(Math.random()* 75 + 25);
        String type = t[(int)Math.round(Math.random())];
        int topSpeed = (int)(Math.random() * 25 + 12);
        int distance = (int)(Math.random() * 25 + 5);
        return new Cardio(user, duration, date, type, topSpeed, distance, null);
    }

    // Strength(Exercise(int duration, Date date, String type), int weight, int times)
    public Strength genStrength(User user, Date date) {
        String[] t = {"veitekki", "ehe", "hehe"};
        int duration = (int)(Math.random()* 75) + 25;
        String type = t[(int)(Math.random() * 3)];
        int weight = (int)(Math.random() * 100) + 5;
        int times = (int)(Math.random() * 40 )+ 5;
        return new Strength(user, duration, date, type, weight, times);
    }
}