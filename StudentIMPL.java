package com.NewStudent.Service.impl;

import com.NewStudent.Dto.StudentDto;
import com.NewStudent.Entity.Student;
import com.NewStudent.Repo.StudentRepo;
import com.NewStudent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentIMPL implements StudentService {
    @Autowired
    private StudentRepo studentRepo;
    @Override
    public String addStudent(Student student) {
       // Student student=new Student();
        studentRepo.save(student);

        return student.getStudentname();
    }
}
