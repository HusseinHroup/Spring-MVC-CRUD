package com.luv2code.springboot.crude.Thymeleafdemo.dao;

import com.luv2code.springboot.crude.Thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
//here not create specific interface
    //add method to sort by last name

    public List<Employee> findAllByOrderByLastNameAsc();
}
