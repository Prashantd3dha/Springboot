package com.prashant.demo.dao;

import com.prashant.demo.entity.Instructor;

public interface AppDao {
    void save(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
