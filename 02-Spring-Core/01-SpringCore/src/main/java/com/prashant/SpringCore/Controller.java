package com.prashant.SpringCore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    // field injection
    @Autowired
    private Coach myCoach;

    // constructor injection
//    public Controller(Coach coach){
//        myCoach = coach;
//    }


    @GetMapping("/exercise")
    public String getExercise(){
        return myCoach.getExercise();
    }
}
