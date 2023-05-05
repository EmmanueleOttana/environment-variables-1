package co.develhope.environmentvariables1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    Environment environment;

    @Value("${myCustomProps.authCode}")
    String authCode;
    @Value("${myCustomProps.devName}")
    String devName;

    @GetMapping("/value")
    public String getProperty1(){
        return devName+"/"+authCode;
    }

    @GetMapping("/environment")
    public String getProperty2(){
        System.out.println(environment.toString());
        return environment.getProperty("myCustomProps.devName")+"/"+
                environment.getProperty("myCustomProps.authCode");
    }

}