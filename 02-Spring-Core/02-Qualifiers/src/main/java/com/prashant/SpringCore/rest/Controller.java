package com.prashant.SpringCore.rest;

import com.prashant.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach myCoach;

    @Autowired
    public Controller(@Qualifier("footballCoach") Coach coach){
        myCoach = coach;
    }


    @GetMapping("/exercise")
    public String getExercise(){
        return myCoach.getExercise();
    }
}
