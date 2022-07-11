package com.ausy.employee.service.impl;

import com.ausy.employee.entity.Employee;
import com.ausy.employee.exception.ResourceNotFoundException;
import com.ausy.employee.paylod.EmployeeDto;
import com.ausy.employee.repository.EmployeeRepository;
import com.ausy.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;

    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        // convert DTO to entity
        Employee employee = mapToEntity(employeeDto);
        Employee newEmployee = employeeRepository.save(employee);

        // convert entity to DTO
        EmployeeDto employeeResponse = mapToDTO(newEmployee);
        return employeeResponse;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto, long id) {
        // get employee by id from the database
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setActions(employeeDto.getActions());
        employee.setCompetences(employeeDto.getCompetences());
        employee.setDcUpdated(employeeDto.getDcUpdated());
        employee.setDept(employeeDto.getDept());
        employee.setDomain(employeeDto.getDomain());
        employee.setExp(employeeDto.getExp());
        employee.setDateStart(employeeDto.getDateStart());
        employee.setMajDC(employeeDto.getMajDC());
        employee.setManager(employeeDto.getManager());
        employee.setManagerMeeting(employeeDto.getManagerMeeting());
        employee.setMobilityFr(employeeDto.getMobilityFr());
        employee.setSeriousConstraint(employeeDto.getSeriousConstraint());
        employee.setStatusOfChecking(employeeDto.getStatusOfChecking());
        employee.setTalent(employeeDto.getTalent());
        employee.setSponsor(employeeDto.getSponsor());

        Employee updatedEmployee = employeeRepository.save(employee);
        return mapToDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeeRepository.delete(employee);    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> mapToDTO(employee)).collect(Collectors.toList());
    }

    // convert Entity into DTO
    private EmployeeDto mapToDTO(Employee employee){
        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }

    // convert DTO to entity
    private Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee = mapper.map(employeeDto, Employee.class);
        return employee;
    }


}
