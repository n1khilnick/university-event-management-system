package com.geeekster.university.event.management.system.models;

import com.geeekster.university.event.management.system.enums.Department;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;


    @Pattern(regexp = "^[A-Z][a-z]*$",message = "First letter must be capital !")
    @NotBlank(message = "firstName is required !!" )
    private String firstName;

    @Pattern(regexp = "^[A-Z][a-z]*$",message = "First letter must be capital !")
    @NotBlank(message = "Please enter lastName properly !!")
    private String lastName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Department department;
}
