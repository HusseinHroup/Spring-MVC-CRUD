package com.luv2code.springboot.crude.Thymeleafdemo.service;

import com.luv2code.springboot.crude.Thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);
    //always remember what you want  return ??
    //+ when create argument for the method save this meaning edit the employee

    void deleteById(int theId);

}
