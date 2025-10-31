package org.example.sis_eventos.repository;

import org.example.sis_eventos.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {


}
