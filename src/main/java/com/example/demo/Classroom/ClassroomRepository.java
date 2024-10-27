package com.example.demo.Classroom;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    // Additional query methods can be added here if needed
}
