package com.ausy.employee.controller;

import com.ausy.employee.paylod.EmployeeDto;
import com.ausy.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // create employee rest api
    @PostMapping("/api/v1/employees")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    // update employee rest api
    @PutMapping("/api/v1/employees/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable(name = "id") long id){

        EmployeeDto employeeResponse = employeeService.updateEmployee(employeeDto, id);
        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }

    // delete employee rest api
    @DeleteMapping("/api/v1/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") long id){
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee entity deleted successfully.", HttpStatus.OK);
    }

    // get all employees rest api
    @GetMapping("/api/v1/employees")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}
