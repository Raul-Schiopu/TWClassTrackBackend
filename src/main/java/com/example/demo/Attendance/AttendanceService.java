package com.example.demo.Attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Transactional
    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Attendance with ID " + id + " not found"));

        attendance.setDate(updatedAttendance.getDate());
        attendance.setPresent(updatedAttendance.isPresent());
        attendance.setForStudent(updatedAttendance.getForStudent());
        attendance.setForClassroom(updatedAttendance.getForClassroom());

        return attendance;
    }

    public void deleteAttendance(Long id) {
        if (!attendanceRepository.existsById(id)) {
            throw new IllegalStateException("Attendance with ID " + id + " does not exist");
        }
        attendanceRepository.deleteById(id);
    }
}
