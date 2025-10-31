package org.example.sis_eventos.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.sis_eventos.dto.AttendanceDTO;
import org.example.sis_eventos.entity.AttendanceEntity;
import org.example.sis_eventos.mapper.AttendanceMapper;
import org.example.sis_eventos.repository.AttendanceRepository;
import org.example.sis_eventos.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService  {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;



    @Override
    public List<AttendanceDTO> findAll() {


        return attendanceMapper.attendanceEntitiesToAttendanceDTOs(attendanceRepository.findAll());
    }

    @Override
    public AttendanceDTO findById(Long id) {
        AttendanceEntity attendanceEntity = attendanceRepository.findById(id).orElseThrow(()->
                new RuntimeException("Attendance not found"));

        return attendanceMapper.attendanceEntityToAttendanceDTO(attendanceEntity);
    }

    @Override
    public AttendanceDTO save(AttendanceDTO attendanceDTO) {
        return null;
    }

    @Override
    public AttendanceDTO update(Long id, AttendanceDTO attendanceDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if(attendanceRepository.findById(id).isPresent()){
            attendanceRepository.deleteById(id);
        }else {
            throw new RuntimeException("Attendance not found");
        }
    }
}
