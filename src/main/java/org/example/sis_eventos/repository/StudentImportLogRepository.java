package org.example.sis_eventos.repository;

import org.example.sis_eventos.entity.StudentImportLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentImportLogRepository extends JpaRepository<StudentImportLogEntity, Long> {
}
