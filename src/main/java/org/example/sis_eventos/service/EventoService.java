package org.example.sis_eventos.service;

import org.example.sis_eventos.dto.EventoDTO;

import java.util.List;

public interface EventoService {

    List<EventoDTO> listarTodos();
    EventoDTO obtenerPorId(Long id);
    EventoDTO crear(EventoDTO eventoDTO);
    EventoDTO actualizar(Long id, EventoDTO eventoDTO);
    void eliminar(Long id);
}
