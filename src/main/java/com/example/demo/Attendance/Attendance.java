package com.example.demo.Attendance;

import com.example.demo.Classroom.Classroom;
import com.example.demo.Student.Student;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "is_present")
    private boolean isPresent;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student forStudent;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom forClassroom;

    public Attendance() {

    }

    public Attendance(LocalDate date, boolean isPresent, Student forStudent, Classroom forClassroom) {
        this.date = date;
        this.isPresent = isPresent;
        this.forStudent = forStudent;
        this.forClassroom = forClassroom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
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
