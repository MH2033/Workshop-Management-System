package com.project.workshopmanagment;

import com.project.workshopmanagment.entity.Grader;
import com.project.workshopmanagment.handler.GraderEventHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WorkshopmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopmanagementApplication.class, args);
	}

}
