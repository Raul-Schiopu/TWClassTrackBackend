package com.example.demo.Student;

import com.example.demo.Account.Account;
import com.example.demo.Classroom.Classroom;
import jakarta.persistence.*;

import java.util.List;

public class Student extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "student_classroom", // Name of the jointable
            joinColumns = @JoinColumn(name = "student_id"), // FK for student id
            inverseJoinColumns = @JoinColumn(name = "classroom_id") // FK for classroom id
    )
    private List<Classroom> classesEnroledInto;

    public Student() {

    }

    public Student(String firstName, String lastName, String password, String memberCode, List<Classroom> classesEnroledInto) {
        super(firstName, lastName, password, memberCode);
        this.classesEnroledInto = classesEnroledInto;
    }



    public List<Classroom> getClassesEnroledInto() {
        return classesEnroledInto;
    }

    public void setClassesEnroledInto(List<Classroom> classesEnroledInto) {
        this.classesEnroledInto = classesEnroledInto;
    }

    @Override
    public String toString() {
        String returnString = "Student{" +
                "id=" + id +
                ", classesEnroledInto=" + classesEnroledInto +
                '}' + super.toString();
        return returnString;
    }
}
