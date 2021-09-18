package com.se.service;

import com.se.entity.Employee;
import com.se.error.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException;

    void deleteById(Long employeeId);

    Employee updateEmployeeById(Long employeeId, Employee employee);

}
