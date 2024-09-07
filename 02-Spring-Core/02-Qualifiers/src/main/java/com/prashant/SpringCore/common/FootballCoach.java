package com.prashant.SpringCore.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    @Override
    public String getExercise() { return "Do 20 mins dribling practise."; }
}
