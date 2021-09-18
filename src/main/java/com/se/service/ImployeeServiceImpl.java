package com.se.service;

import com.se.entity.Employee;
import com.se.error.EmployeeNotFoundException;
import com.se.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if(!employee.isPresent())
            throw new EmployeeNotFoundException("Employee Not Found!!!");
        return employee.get();
    }

    @Override
    public void deleteById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployeeById(Long employeeId, Employee employee) {
        Employee e = employeeRepository.findById(employeeId).get();
        e.setEmail(employee.getEmail());
        e.setFirstName(employee.getFirstName());
        e.setLastName(employee.getLastName());
        return employeeRepository.save(e);
    }
}
