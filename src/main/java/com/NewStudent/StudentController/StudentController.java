package com.NewStudent.StudentController;

import com.NewStudent.Dto.StudentDto;
import com.NewStudent.Repo.StudentRepo;
import com.NewStudent.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/Student")

public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping(path="/save")
    public String saveStudent(@RequestBody StudentDto studentDto)
    {
String id=studentService.addStudent(studentDto);
return id;

    }
   // @PostMapping(path="/save")
//    @GetMapping(path="/saving")
//    public List<StudentDto>getAllStudent()
//    {
//      return StudentRepo.findAll();
//    }

}
