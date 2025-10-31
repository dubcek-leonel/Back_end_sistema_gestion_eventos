package org.example.sis_eventos.service;

import org.example.sis_eventos.dto.AttendanceDTO;

import java.util.List;

public interface AttendanceService {

    List<AttendanceDTO> findAll();

    AttendanceDTO findById(Long id);

    AttendanceDTO save(AttendanceDTO attendanceDTO);

    AttendanceDTO update(Long id, AttendanceDTO attendanceDTO);

    void delete(Long id);

}
