package com.prashant.SpringCore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach{

    public HockeyCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getExercise() { return "Do 10 mins running."; }
}
