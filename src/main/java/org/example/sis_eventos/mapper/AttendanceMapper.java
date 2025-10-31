package org.example.sis_eventos.mapper;

import org.example.sis_eventos.dto.AttendanceDTO;
import org.example.sis_eventos.entity.AttendanceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AttendanceMapper {

    AttendanceDTO attendanceEntityToAttendanceDTO(AttendanceEntity attendanceEntity);

    List<AttendanceDTO> attendanceEntitiesToAttendanceDTOs(List<AttendanceEntity> attendanceEntities);

    AttendanceEntity attendanceDTOToAttendanceEntity(AttendanceDTO attendanceDTO);


}
