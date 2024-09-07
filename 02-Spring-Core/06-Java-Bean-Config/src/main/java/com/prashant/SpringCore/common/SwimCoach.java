package com.prashant.SpringCore.common;

public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }

    @Override
    public String getExercise() {
        return "Do 50 meter warm up swim.";
    }
}
