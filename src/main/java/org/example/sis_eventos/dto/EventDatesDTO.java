package org.example.sis_eventos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class EventDatesDTO {
    private Long id;

    private Date starDate;
    private Date endDate;

    boolean isActive;

    private Date createdAt;

}
