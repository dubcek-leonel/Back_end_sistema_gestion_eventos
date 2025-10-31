package org.example.sis_eventos.service.impl;

import org.example.sis_eventos.dto.EventoDTO;
import org.example.sis_eventos.service.EventoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventoServiceImpl implements EventoService {

    @Override
    public List<EventoDTO> listarTodos() {
        return null;
    }

    @Override
    public EventoDTO obtenerPorId(Long id) {
        return null;
    }

    @Override
    public EventoDTO crear(EventoDTO eventoDTO) {
        return null;
    }

    @Override
    public EventoDTO actualizar(Long id, EventoDTO eventoDTO) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
