package com.prashant.demo.dao;

import com.prashant.demo.entity.Course;
import com.prashant.demo.entity.Instructor;
import com.prashant.demo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
    List<Course> findCoursesByInstructorId(int id);
    Instructor findInstructorByIdJoinFetch(int id);
    void update(Instructor instructor);
    void update(Course course);
    Course findCourseById(int courseId);
    void deleteCourseById(int courseId);
}
