package com.se.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.se.entity.Employee;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EmployeeDTO {

    private long employeeId;

    private String firstName;

    private String lastName;

    private String email;

    public EmployeeDTO (Employee employee){
        this.employeeId = employee.getEmployeeId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
    }
}
