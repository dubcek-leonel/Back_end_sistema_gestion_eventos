package org.example.sis_eventos.service;


import org.example.sis_eventos.dto.EventDatesDTO;

import java.util.List;

public interface EventDatesService {

    List<EventDatesDTO> findAll();
    EventDatesDTO findById(Long id);
    EventDatesDTO save(EventDatesDTO eventDatesDTO);
    EventDatesDTO update(Long id, EventDatesDTO eventDatesDTO);
    void delete(Long id);
}
