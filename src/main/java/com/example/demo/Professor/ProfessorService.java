package com.example.demo.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessorById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Transactional
    public Professor updateProfessor(Long id, Professor updatedProfessor) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Professor with ID " + id + " not found"));

        professor.setClassesCreated(updatedProfessor.getClassesCreated());
        // Update other fields as needed

        return professor;
    }

    public void deleteProfessor(Long id) {
        if (!professorRepository.existsById(id)) {
            throw new IllegalStateException("Professor with ID " + id + " does not exist");
        }
        professorRepository.deleteById(id);
    }
}
