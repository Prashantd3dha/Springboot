package com.prashant.springbootrestcrudemployee.dao;

import com.prashant.springbootrestcrudemployee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteById(int id);
}
