package com.NewStudent.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@EntityScan
@Document

public class Student {
    @Id
    @Field(name="id")

    private String studentid;
    @Field(name="Name")
    private String studentname;
    @Field(name="DOB")
    private String dob;
    @Field(name="Gender")
    private String gender;
    @Field(name="Class")
    private String newclass;
    @Field(name="Division")
    private String division;

    public Student(String studentid, String studentname, String dob, String gender, String newclass, String division) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.dob = dob;
        this.gender = gender;
        this.newclass = newclass;
        this.division = division;
    }

    public Student() {
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNewclass() {
        return newclass;
    }

    public void setNewclass(String newclass) {
        this.newclass = newclass;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid='" + studentid + '\'' +
                ", studentname='" + studentname + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", newclass='" + newclass + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
