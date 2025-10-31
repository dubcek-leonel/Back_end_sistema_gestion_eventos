package org.example.sis_eventos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class AttendanceDTO {

    private Long id;

    private Date checkInTime;
    private Date checkOutTime;

    private String checkInMethod;

    private String notes;

    private Date createdAt;
    private Date updatedAt;
}
