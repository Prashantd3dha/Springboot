package com.prashant.SpringCore.rest;

import com.prashant.SpringCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public Controller(
            @Qualifier("cricketCoach") Coach coach,
            @Qualifier("cricketCoach") Coach theCoach){
        System.out.println("In constructor : " + getClass().getSimpleName());
        myCoach = coach;
        anotherCoach = theCoach;
    }


    @GetMapping("/exercise")
    public String getExercise(){
        return myCoach.getExercise();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans:myCoach == anotherCoach, "+(myCoach == anotherCoach);
    }
}
