package org.example.sis_eventos.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.sis_eventos.dto.EventoDTO;
import org.example.sis_eventos.entity.EventoEntity;
import org.example.sis_eventos.mapper.EventoMapper;
import org.example.sis_eventos.repository.EventoRepository;
import org.example.sis_eventos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoMapper eventoMapper;

    @Override
    public List<EventoDTO> listarTodos() {
        return eventoMapper.eventosEntitiesAEventoDTOs(eventoRepository.findAll());
    }

    @Override
    public EventoDTO obtenerPorId(Long id) {
        EventoEntity eventoEntity = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));
        return eventoMapper.eventoEntityAEventoDTO(eventoEntity);
    }

    @Override
    public EventoDTO crear(EventoDTO eventoDTO) {
        EventoEntity eventoEntity = eventoMapper.EventoDTOAEventoEntity(eventoDTO);
        // 🔹 No pongas ID aquí — debe generarse automáticamente
        EventoEntity guardado = eventoRepository.save(eventoEntity);
        return eventoMapper.eventoEntityAEventoDTO(guardado);
    }

    @Override
    public EventoDTO actualizar(Long id, EventoDTO eventoDTO) {
        EventoEntity eventoEntity = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento no encontrado"));

        // Actualiza solo los campos editables
        eventoEntity.setTitle(eventoDTO.getTitle());
        eventoEntity.setDescription(eventoDTO.getDescription());
        eventoEntity.setLocation(eventoDTO.getLocation());
        eventoEntity.setType(eventoDTO.getType());
        eventoEntity.setOrganizer(eventoDTO.getOrganizer());
        eventoEntity.setMaxCapacity(eventoDTO.getMaxCapacity());
        eventoEntity.setCurrentRegistrations(eventoDTO.getCurrentRegistrations());
        eventoEntity.setIsPaid(eventoDTO.getIsPaid());
        eventoEntity.setPrice(eventoDTO.getPrice());
        eventoEntity.setCurrency(eventoDTO.getCurrency());
        eventoEntity.setRequiresApproval(eventoDTO.getRequiresApproval());
        eventoEntity.setIsPublished(eventoDTO.getIsPublished());
        eventoEntity.setStatus(eventoDTO.getStatus());
        eventoEntity.setImageUrl(eventoDTO.getImageUrl());
        eventoEntity.setRegistrationDeadline(eventoDTO.getRegistrationDeadline());
        eventoEntity.setCreatedBy(eventoDTO.getCreatedBy());

        // ❌ No tocar fechaCreacion, Hibernate la mantiene automáticamente
        EventoEntity actualizado = eventoRepository.save(eventoEntity);
        return eventoMapper.eventoEntityAEventoDTO(actualizado);
    }



    @Override
    public void eliminar(Long id) {
        if (!eventoRepository.existsById(id)) {
            throw new EntityNotFoundException("Evento no encontrado");
        }
        eventoRepository.deleteById(id);
    }
}
