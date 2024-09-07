package com.prashant.SpringCore.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    public FootballCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getExercise() { return "Do 20 mins dribling practise."; }
}
