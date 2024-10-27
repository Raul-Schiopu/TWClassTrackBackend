package com.example.demo.Attendance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Custom query methods can be added here if needed
}
