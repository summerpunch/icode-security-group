package com.icode.security.cas;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class IcodeSecurityCasApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(IcodeSecurityCasApplication.class);
        springApplication.run(args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }

}
