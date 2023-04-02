package com.NewStudent.Service;

import com.NewStudent.Dto.StudentDto;
import com.NewStudent.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

public interface StudentService {

    String addStudent(Student student);

}
