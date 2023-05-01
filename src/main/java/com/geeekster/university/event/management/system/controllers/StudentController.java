package com.geeekster.university.event.management.system.controllers;

import com.geeekster.university.event.management.system.enums.Department;
import com.geeekster.university.event.management.system.models.Student;
import com.geeekster.university.event.management.system.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping(value = "/saveStudent")
    public String saveStudents(@Valid @RequestBody List<Student> studentList){
        studentService.addStudents(studentList);
        return "Student(s) added !";
    }

    @GetMapping(value = "/getAllStudents")
    public Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/{studentId}")
    public Optional<Student> getStudentById(@PathVariable Integer studentId){
        return studentService.fetchStudentById(studentId);
    }


    @PutMapping(value = "/update/{studentId}/{department}")
    public String updateStudentDepartmentById(@PathVariable Integer studentId, @PathVariable Department department){
        return studentService.modifyDepartmentById(studentId,department);
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public String deleteStudentByID(@PathVariable Integer studentId){
        return studentService.removeStudentById(studentId);
    }



}
