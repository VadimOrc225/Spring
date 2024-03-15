package ru.gb.homework1;

import org.springframework.context.annotation.Bean;

//@Configuration
public class ApplicationConf {

    @Bean
    StudentRepository myUserRepository(){
        return new StudentRepository();
    }
}
