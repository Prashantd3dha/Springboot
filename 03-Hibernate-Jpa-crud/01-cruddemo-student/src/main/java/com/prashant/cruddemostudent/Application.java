package com.prashant.cruddemostudent;

import com.prashant.cruddemostudent.dao.StudentDAO;
import com.prashant.cruddemostudent.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			queryForStudents(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		studentDAO.deleteAll();
		System.out.println("All students in table Student deleted successfully.");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		studentDAO.delete(studentId);
		System.out.println("Student deleted successfully with ID : " + studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		student.setEmail("john@spring.com");
		studentDAO.update(student);
		System.out.println("Updated student : " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Duck");
		students.forEach(student -> {
			System.out.println(student );
		});
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		students.forEach(student -> {
			System.out.println(student );
		});
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("Jerry","Duck","jerry@spring.com");
		studentDAO.save(student);
		int id = student.getId();
		Student theStudent = studentDAO.findById(id);
		System.out.println("Student : " + theStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Henry","Clinton","henryclinton@spring.com");
		studentDAO.save(student);
		System.out.println("Student is saved with ID : " + student.getId());
	}
}
