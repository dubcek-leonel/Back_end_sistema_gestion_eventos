package org.example.sis_eventos.mapper;

import org.example.sis_eventos.dto.EventoDTO;
import org.example.sis_eventos.entity.EventoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper (componentModel = "spring")

public interface EventoMapper {

    EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);

    EventoDTO eventoEntityAEventoDTO(EventoEntity eventoEntity);

    List<EventoDTO> eventosEntityAEventoDTOs(List<EventoEntity> eventosEntity);

    EventoEntity eventoDTOAEventoEntity(EventoDTO eventoDTO);

}
