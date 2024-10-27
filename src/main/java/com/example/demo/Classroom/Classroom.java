package com.example.demo.Classroom;

import com.example.demo.Professor.Professor;
import com.example.demo.Student.Student;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @ManyToMany
    @JoinTable(
            name = "classroom_student",
            joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> studentList;

    @Column(name = "invite_code")
    private String inviteCode;

    public Classroom() {

    }

    public Classroom(Professor professor, List<Student> studentList, String inviteCode) {
        this.professor = professor;
        this.studentList = studentList;
        this.inviteCode = inviteCode;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
