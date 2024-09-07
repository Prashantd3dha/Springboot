package com.prashant.demo;

import com.prashant.demo.dao.AppDao;
import com.prashant.demo.entity.Instructor;
import com.prashant.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner -> {
			deleteInstructorDetail(appDao);
		};
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int id = 2;
		appDao.deleteInstructorDetailById(id);

		System.out.println("Instructor detail deleted with ID: "+id);

	}

	private void findInstructorDetail(AppDao appDao) {
		int id = 2;
		InstructorDetail tempInstructorDetail = appDao.findInstructorDetailById(id);

		System.out.println("Instructor Detail : "+tempInstructorDetail);
		System.out.println("Instructor only : "+tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDao appDao) {
		int id = 1;
		appDao.deleteInstructorById(id);

		System.out.println("Instructor deleted with ID: "+id);
	}

	private void findInstructor(AppDao appDao) {
		int id = 1;
		Instructor tempInstructor = appDao.findInstructorById(id);

		System.out.println("Instructor : "+tempInstructor);
		System.out.println("Instructor details only : "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDao appDao) {
		Instructor tempInstructor = new Instructor(
				"John",
				"Doe",
				"johndoe@spring.com"
		);

		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"https://www.youtube.com/watch?v=dQw4w9WgXcQ",
				"Rick Roll"
		);

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//this will also save the instructor_details becoz of cascade= CascadeType.ALL
		System.out.println("Saving instructor...");
		appDao.save(tempInstructor);
	}
}
