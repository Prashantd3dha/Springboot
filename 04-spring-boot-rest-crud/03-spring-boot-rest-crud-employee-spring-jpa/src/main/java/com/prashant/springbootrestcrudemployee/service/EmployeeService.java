package com.prashant.springbootrestcrudemployee.service;

import com.prashant.springbootrestcrudemployee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void deleteById(int id);

}
