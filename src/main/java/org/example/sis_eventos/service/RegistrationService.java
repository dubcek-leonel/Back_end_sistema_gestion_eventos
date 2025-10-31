package org.example.sis_eventos.service;

import org.example.sis_eventos.dto.RegistrationDTO;
import java.util.List;

public interface RegistrationService {

    List<RegistrationDTO> listar();

    RegistrationDTO buscarPorId(Long id);

    RegistrationDTO guardar(RegistrationDTO registrationDTO);

    RegistrationDTO editar(RegistrationDTO registrationDTO);

    void borrar(Long id);
}
