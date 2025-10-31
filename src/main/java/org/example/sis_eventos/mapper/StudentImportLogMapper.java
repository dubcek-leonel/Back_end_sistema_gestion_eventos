package org.example.sis_eventos.mapper;

import org.example.sis_eventos.dto.StudentImportLogDTO;
import org.example.sis_eventos.entity.StudentImportLogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentImportLogMapper {

    StudentImportLogMapper INSTANCE = Mappers.getMapper(StudentImportLogMapper.class);

    StudentImportLogDTO toDTO(StudentImportLogEntity entity);

    List<StudentImportLogDTO> toDTOList(List<StudentImportLogEntity> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    StudentImportLogEntity toEntity(StudentImportLogDTO dto);
}
