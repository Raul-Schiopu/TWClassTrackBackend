package com.example.demo.Professor;

import com.example.demo.Account.Account;
import com.example.demo.Classroom.Classroom;
import jakarta.persistence.*;

import java.util.List;

public class Professor extends Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "professor_classroom", // Name of the jointable
            joinColumns = @JoinColumn(name = "professor_id"), // FK for professor id
            inverseJoinColumns = @JoinColumn(name = "classroom_id") // FK for classroom id
    )
    private List<Classroom> classesCreated;

    public Professor(){

    }

    public Professor(String firstName, String lastName, String password, String memberCode, List<Classroom> classesCreated) {
        super(firstName, lastName, password, memberCode);
        this.classesCreated = classesCreated;
    }

    public List<Classroom> getClassesCreated() {
        return classesCreated;
    }

    public void setClassesCreated(List<Classroom> classesCreated) {
        this.classesCreated = classesCreated;
    }

    @Override
    public String toString() {
        String returnString = "Professor{" +
                "id=" + id +
                ", classesCreated=" + classesCreated +
                '}' + super.toString();
        return returnString;
    }
}
