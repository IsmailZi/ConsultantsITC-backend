package com.ausy.employee.service;

import com.ausy.employee.paylod.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();
    void deleteEmployeeById(long id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto, long id);


}
