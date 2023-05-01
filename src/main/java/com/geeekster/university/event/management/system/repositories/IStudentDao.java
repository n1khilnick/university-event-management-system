package com.geeekster.university.event.management.system.repositories;
import com.geeekster.university.event.management.system.models.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDao extends CrudRepository<Student, Integer> {

    @Modifying
    @Query(value = "Update Student set DEPARTMENT = :department where STUDENT_ID = :studentId ",nativeQuery = true)
    void modifyDepartmentById(Integer studentId, String department);
}
