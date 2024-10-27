package com.example.demo.Classroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }

    public Optional<Classroom> getClassroomById(Long id) {
        return classroomRepository.findById(id);
    }

    public Classroom createClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Transactional
    public Classroom updateClassroom(Long id, Classroom updatedClassroom) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Classroom with ID " + id + " not found"));

        classroom.setProfessor(updatedClassroom.getProfessor());
        classroom.setStudentList(updatedClassroom.getStudentList());
        classroom.setInviteCode(updatedClassroom.getInviteCode());

        return classroom;
    }

    public void deleteClassroom(Long id) {
        if (!classroomRepository.existsById(id)) {
            throw new IllegalStateException("Classroom with ID " + id + " does not exist");
        }
        classroomRepository.deleteById(id);
    }
}
