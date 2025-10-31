package org.example.sis_eventos.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.sis_eventos.dto.EventDatesDTO;
import org.example.sis_eventos.mapper.EventDatesMapper;
import org.example.sis_eventos.repository.EventDatesRepository;
import org.example.sis_eventos.service.EventDatesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventDatesServiceImpl implements EventDatesService {

    private final EventDatesRepository eventDatesRepository;
    private final EventDatesMapper eventDatesMapper;

    @Override
    public List<EventDatesDTO> findAll() {
        return List.of();
    }

    @Override
    public EventDatesDTO findById(Long id) {
        return null;
    }

    @Override
    public EventDatesDTO save(EventDatesDTO eventDatesDTO) {
        return null;
    }

    @Override
    public EventDatesDTO update(Long id, EventDatesDTO eventDatesDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
