package com.example.demo.Professor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    // Custom query methods can be added here if needed
}
