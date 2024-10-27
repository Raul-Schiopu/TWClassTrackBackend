package com.example.demo.Assignment;

import com.example.demo.Classroom.Classroom;
import com.example.demo.Student.Student;
import jakarta.persistence.*;

import java.time.LocalDate;

public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "grade")
    private double grade;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student forStudent;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom forClassroom;


    public Assignment(){

    }

    public Assignment(LocalDate date, double grade, Student forStudent, Classroom forClassroom) {
        this.date = date;
        this.grade = grade;
        this.forStudent = forStudent;
        this.forClassroom = forClassroom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Student getForStudent() {
        return forStudent;
    }

    public void setForStudent(Student forStudent) {
        this.forStudent = forStudent;
    }

    public Classroom getForClassroom() {
        return forClassroom;
    }

    public void setForClassroom(Classroom forClassroom) {
        this.forClassroom = forClassroom;
    }
}
