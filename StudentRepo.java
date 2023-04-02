package com.NewStudent.Repo;

import com.NewStudent.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
@Repository

public interface StudentRepo extends MongoRepository<Student,String> {

}
