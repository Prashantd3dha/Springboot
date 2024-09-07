package com.prashant.demo.dao;

import com.prashant.demo.entity.Instructor;
import com.prashant.demo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}
