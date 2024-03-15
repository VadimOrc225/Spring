package ru.gb.homework1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Homework1Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Homework1Application.class, args);
		StudentRepository repository = new StudentRepository();
//		System.out.println(repository.getAll());
	}

}
