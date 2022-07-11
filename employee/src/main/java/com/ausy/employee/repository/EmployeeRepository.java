package com.ausy.employee.repository;

import com.ausy.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByFirstNameOrLastName(String firstName , String lastName);
}