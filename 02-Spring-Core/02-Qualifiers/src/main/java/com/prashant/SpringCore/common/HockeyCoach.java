package com.prashant.SpringCore.common;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach{
    @Override
    public String getExercise() { return "Do 10 mins running."; }
}
