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
    public Controller(@Qualifier("aquatic") Coach coach){
        System.out.println("In constructor : " + getClass().getSimpleName());
        myCoach = coach;
    }


    @GetMapping("/exercise")
    public String getExercise(){
        return myCoach.getExercise();
    }

}
