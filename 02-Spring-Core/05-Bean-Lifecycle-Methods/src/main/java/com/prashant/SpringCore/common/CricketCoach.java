package com.prashant.SpringCore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach, InitializingBean, DisposableBean {

    public CricketCoach() {
        System.out.println("In constructor : " + getClass().getSimpleName());
    }

    //init method
/*    @PostConstruct
    public void doStartupStuff() {
        System.out.println("In doStartupStuff : " + getClass().getSimpleName());
    }
*/
    public void afterPropertiesSet() {
        System.out.println("In doStartupStuff : " + getClass().getSimpleName());
    }

/*    @PreDestroy
    public void doCleanupStuff() {
        System.out.println("In doCleanupStuff : " + getClass().getSimpleName());
    }
 */
    public void destroy() {
        System.out.println("In doCleanupStuff : " + getClass().getSimpleName());
    }
    @Override
    public String getExercise() {
        return "Do 15 mins fast bowling practise.";
    }
}
