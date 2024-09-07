package com.prashant.demo;

import com.prashant.demo.dao.AppDao;
import com.prashant.demo.entity.Course;
import com.prashant.demo.entity.Instructor;
import com.prashant.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner -> {
			deleteCourse(appDao);
		};
	}

	private void deleteCourse(AppDao appDao) {
		int id = 10;
		appDao.deleteCourseById(id);

		System.out.println("Deleted course with Id : "+id);
	}

	private void updateCourse(AppDao appDao) {
		int id = 10;
		Course course = appDao.findCourseById(id);

		course.setTitle("Air Hockey : The Master Class");
		appDao.update(course);
		System.out.println("updated Course with id : "+id);
	}

	private void findCourse(AppDao appDao) {
		int id = 10;
		Course course = appDao.findCourseById(id);

		System.out.println("Course : "+course);
	}

	private void updateInstructor(AppDao appDao) {
		int id = 1;
		Instructor instructor = appDao.findInstructorById(id);

		instructor.setLastName("Jhonson");
		appDao.update(instructor);
		System.out.println("updated instructor with id : "+id);
	}

	private void findInstructorWithCourseJoinFetch(AppDao appDao) {
		int id =1;
		Instructor instructor = appDao.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor : "+instructor);
		System.out.println("Associated courses : "+instructor.getCourses());
	}

	private void findCoursesforInstructor(AppDao appDao) {
		int id =1;
		Instructor instructor = appDao.findInstructorById(id);

		List<Course> courses = appDao.findCoursesByInstructorId(id);
		instructor.setCourses(courses);

		System.out.println("Associated courses : "+instructor.getCourses());
	}

	private void findInstructorwithCourses(AppDao appDao) {
		int id = 1;
		Instructor instructor = appDao.findInstructorById(id);

		System.out.println("Instructor : "+instructor);
		System.out.println("Associated courses : "+instructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorwithCourses(AppDao appDao) {
		//create the instructor
		Instructor tempInstructor = new Instructor(
				"John",
				"Doe",
				"johndoe@spring.com"
		);

		//create instructor details
		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"https://www.youtube.com/",
				"Rick Roll"
		);

		// associate instructor details to instructor
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create courses
		Course course_1 = new Course("Air Hockey: A pro");
		Course course_2 = new Course("Mathematics Algebra");

		//add courses to instructor
		tempInstructor.add(course_1);
		tempInstructor.add(course_2);

		//this will also save the instructor_details and courses becoz of cascade= CascadeType.ALL/CascadeType.Persist
		System.out.println("Saving instructor...");
		appDao.save(tempInstructor);
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
				"https://www.youtube.com/",
				"Rick Roll"
		);

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//this will also save the instructor_details becoz of cascade= CascadeType.ALL
		System.out.println("Saving instructor...");
		appDao.save(tempInstructor);
	}
}