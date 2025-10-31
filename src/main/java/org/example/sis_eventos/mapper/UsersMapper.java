package org.example.sis_eventos.mapper;

import org.example.sis_eventos.dto.UsersDTO;
import org.example.sis_eventos.entity.UsersEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UsersDTO UsersEntityToUsersDTO(UsersEntity usersEntity);

    List<UsersDTO> UsersEntitiesToUsersDTOs(List<UsersEntity> usersEntities);

    UsersEntity UsersDTOToUsersEntity(UsersDTO usersDTO);
}
