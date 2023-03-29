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
    public String addStudent(StudentDto studentDto) {
        Student student=new Student(
            studentDto.getStudentid(),
            studentDto.getStudentname(),
                studentDto.getDob(),
            studentDto.getGender(),
                studentDto.getNewclass(),
                studentDto.getDivision()

            );
        studentRepo.save(student);

        return student.getStudentname();
    }
}
