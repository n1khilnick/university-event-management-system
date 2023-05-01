package com.geeekster.university.event.management.system.services;

import com.geeekster.university.event.management.system.enums.Department;
import com.geeekster.university.event.management.system.models.Student;
import com.geeekster.university.event.management.system.repositories.IStudentDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class StudentService {
    @Autowired
    IStudentDao studentDao;

    public String addStudents(List<Student> studentList) {
        Iterable<Student> addedUsers = studentDao.saveAll(studentList);
        return "Yes";
    }

    public Iterable<Student> getAllStudents() {
        return studentDao.findAll();
//       Iterable<Student> allStudents = studentDao.findAll();
//        return allStudents;
    }

    public Optional<Student> fetchStudentById(Integer studentId) {
        return studentDao.findById(studentId);
    }


    public String removeStudentById(Integer studentId) {
       if(studentId != null) {
           Iterable<Student> students = getAllStudents();
           for (Student student:students){
               if(student.getStudentId().equals(studentId)){
                   studentDao.deleteById(studentId);
                   return "Student with id "+studentId+" was removed successfully !!";
               }
           }
       }
       else if (studentId == null) return "StudentId cannot be null";
       else return  "Couldn't found the student with id "+studentId+" !!";

       return "Failed !! unable to remove student !";
    }

    @Transactional
    public String modifyDepartmentById(Integer studentId, Department department) {
        if(studentId == null && department ==null) return  null;
        else if(studentId != null) {
            studentDao.modifyDepartmentById(studentId,department.toString());
            return "Student with id "+studentId+" is updated !!";
        }
        return "Id "+studentId+" doesn't exists !!";

    }
}
