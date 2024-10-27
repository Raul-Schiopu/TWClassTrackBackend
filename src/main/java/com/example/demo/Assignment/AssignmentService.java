package com.example.demo.Assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getAssignmentById(Long id) {
        return assignmentRepository.findById(id);
    }

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Transactional
    public Assignment updateAssignment(Long id, Assignment updatedAssignment) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Assignment with ID " + id + " not found"));

        assignment.setDate(updatedAssignment.getDate());
        assignment.setGrade(updatedAssignment.getGrade());
        assignment.setForStudent(updatedAssignment.getForStudent());
        assignment.setForClassroom(updatedAssignment.getForClassroom());

        return assignment;
    }

    public void deleteAssignment(Long id) {
        if (!assignmentRepository.existsById(id)) {
            throw new IllegalStateException("Assignment with ID " + id + " does not exist");
        }
        assignmentRepository.deleteById(id);
    }
}
