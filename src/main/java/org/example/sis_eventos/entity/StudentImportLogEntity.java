package org.example.sis_eventos.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "student_import_logs")
public class StudentImportLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Long importedBy;
    private Integer totalRecords;
    private Integer successfulRecords;
    private Integer failedRecords;

    @Column(columnDefinition = "TEXT")
    private String errorLog;

    private String fileName;
    private Date createdAt;
}
