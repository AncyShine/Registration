package com.NewStudent.Dto;

import org.springframework.data.mongodb.core.mapping.Field;

public class StudentDto {
    private String studentid;
    private String studentname;
    private String dob;
    public String gender;
    private String newclass;
    private String division;

    public StudentDto(String studentid, String studentname, String dob, String gender, String newclass, String division) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.dob = dob;
        this.gender = gender;
        this.newclass = newclass;
        this.division = division;
    }

    public StudentDto() {
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
        return "StudentDto{" +
                "studentid='" + studentid + '\'' +
                ", studentname='" + studentname + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", newclass='" + newclass + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
