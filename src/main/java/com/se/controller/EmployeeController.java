package com.se.controller;

import com.se.entity.Employee;
import com.se.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @PostMapping("/employees")
//    Employee saveEmployee(@Valid @RequestBody Employee employee){
//        return employeeService.saveEmployee(employee);
//    }

    @PostMapping("/employees")
    ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    Employee getEmployeeId(@PathVariable("id") Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/employees/{id}")
    String deleteById(@PathVariable("id") Long employeeId){
        employeeService.deleteById(employeeId);
        return "OK";
    }

    @PutMapping("/employees/{id}")
    Employee updateById(@PathVariable("id") Long employeeId, @RequestBody Employee employee){
        return employeeService.updateEmployeeById(employeeId, employee);
    }
}
