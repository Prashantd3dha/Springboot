package com.prashant.SpringCore.config;

import com.prashant.SpringCore.common.Coach;
import com.prashant.SpringCore.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
// default bean id = method name
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
