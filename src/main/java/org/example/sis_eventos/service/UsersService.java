package org.example.sis_eventos.service;

import org.example.sis_eventos.dto.UsersDTO;

import java.util.List;

public interface UsersService {

    List<UsersDTO> findAll();

    UsersDTO findById(Long id);

    UsersDTO save(UsersDTO usersDTO);

    UsersDTO update(Long id, UsersDTO usersDTO);

    void delete(Long id);
}
