package com.prashant.SpringCore;

import org.springframework.stereotype.Component;

@Component
public class CriketCoach implements Coach {

    @Override
    public String getExercise() {
        return "Do 15 mins fast bowling practise.....";
    }
}
