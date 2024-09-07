package com.prashant.demo.dao;

import com.prashant.demo.entity.Course;
import com.prashant.demo.entity.Instructor;
import com.prashant.demo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);
    void save(Course course);

    Instructor findInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    Course findCourseById(int courseId);
    Course findCourseAndReviewsByCourseId(int courseId);

    void deleteInstructorById(int id);
    void deleteInstructorDetailById(int id);
    void deleteCourseById(int courseId);

    void update(Instructor instructor);
    void update(Course course);
}
