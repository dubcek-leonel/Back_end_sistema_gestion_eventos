package org.example.sis_eventos.mapper;

import org.example.sis_eventos.dto.EventDatesDTO;
import org.example.sis_eventos.entity.EventDatesEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventDatesMapper {

    EventDatesDTO eventDateEntityToEventDatesDTO(EventDatesEntity eventDatesEntity);

    List<EventDatesDTO> eventDatesEntitiesToEventDatesDTOs(List<EventDatesEntity> eventDatesEntities);

    EventDatesEntity eventDatesDTOToEventDatesEntity(EventDatesDTO eventDatesDTO);
}
