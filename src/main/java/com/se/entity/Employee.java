package com.se.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "tbl_employee")
public class Employee {
    @Id
    @GeneratedValue
    private long employeeId;

    @NotBlank (message = "Please input your first name!")
    @Length(max = 10, min = 1, message = "Less than ten and greater than one")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Email is not valid")
    @Column(name = "email")
    private String email;
}
