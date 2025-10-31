package org.example.sis_eventos.dto;

import lombok.Data;
import java.util.Date;

@Data
public class StudentImportLogDTO {

    private Long id;
    private Long eventId;
    private Long importedBy;
    private Integer totalRecords;
    private Integer successfulRecords;
    private Integer failedRecords;
    private String errorLog;
    private String fileName;
    private Date createdAt;
}
