package com.prashant.SpringCore.common;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }
    @Override
    public String getExercise() {
        return "Do 15 mins fast bowling practise.";
    }
}
