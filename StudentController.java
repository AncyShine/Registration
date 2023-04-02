package com.NewStudent.StudentController;

import java.util.List;
import com.NewStudent.Entity.Student;
import com.NewStudent.Dto.StudentDto;
import com.NewStudent.Repo.StudentRepo;
import com.NewStudent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/Student")

public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepo studentRepo;


    @PostMapping(path="/save")
    public String saveStudent(@RequestBody Student student)
    {
        //generate sequence
String id=studentService.addStudent(student);
return id;

    }

   @GetMapping(path="/student")
  public List<Student> getAllStudent()
    {
   return studentRepo.findAll(Sort.by("studentname"));
    }

}
