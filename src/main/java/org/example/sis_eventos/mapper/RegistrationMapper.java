package org.example.sis_eventos.mapper;

import org.example.sis_eventos.dto.RegistrationDTO;
import org.example.sis_eventos.entity.RegistrationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {

    RegistrationMapper INSTANCE = Mappers.getMapper(RegistrationMapper.class);

    RegistrationDTO registrationEntityToDTO(RegistrationEntity registrationEntity);

    List<RegistrationDTO> registrationEntitiesToDTOs(List<RegistrationEntity> registrationEntities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    RegistrationEntity registrationDTOToEntity(RegistrationDTO registrationDTO);
}

