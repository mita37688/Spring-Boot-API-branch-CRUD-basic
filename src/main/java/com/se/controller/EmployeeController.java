package com.se.controller;

import com.se.entity.Employee;
import com.se.model.EmployeeDTO;
import com.se.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDTO> dtoList = new ArrayList<>();
        for (Employee employee : employees){
            dtoList.add(new EmployeeDTO(employee));
        }
        return dtoList;
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
