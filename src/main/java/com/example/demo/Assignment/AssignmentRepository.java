package com.example.demo.Assignment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    // Custom query methods can be added here if needed
}
