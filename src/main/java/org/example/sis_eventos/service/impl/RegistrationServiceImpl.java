package org.example.sis_eventos.service.impl;

import org.example.sis_eventos.dto.RegistrationDTO;
import org.example.sis_eventos.entity.RegistrationEntity;
import org.example.sis_eventos.mapper.RegistrationMapper;
import org.example.sis_eventos.repository.RegistrationRepository;
import org.example.sis_eventos.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationMapper registrationMapper;

    private static final String REGISTRO_NO_ENCONTRADO = "Registro no encontrado con ID: ";

    @Override
    @Transactional(readOnly = true)
    public List<RegistrationDTO> listar() {
        List<RegistrationEntity> registrations = registrationRepository.findAll();
        return registrationMapper.registrationEntitiesToDTOs(registrations);
    }

    @Override
    @Transactional(readOnly = true)
    public RegistrationDTO buscarPorId(Long id) {
        RegistrationEntity registration = registrationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(REGISTRO_NO_ENCONTRADO + id));
        return registrationMapper.registrationEntityToDTO(registration);
    }

    @Override
    @Transactional
    public RegistrationDTO guardar(RegistrationDTO registrationDTO) {
        RegistrationEntity entity = registrationMapper.registrationDTOToEntity(registrationDTO);
        RegistrationEntity saved = registrationRepository.save(entity);
        return registrationMapper.registrationEntityToDTO(saved);
    }

    @Override
    @Transactional
    public RegistrationDTO editar(RegistrationDTO registrationDTO) {
        if (registrationDTO.getId() == null) {
            throw new IllegalArgumentException("El ID del registro es requerido para editar.");
        }

        RegistrationEntity existing = registrationRepository.findById(registrationDTO.getId())
                .orElseThrow(() -> new NoSuchElementException(REGISTRO_NO_ENCONTRADO + registrationDTO.getId()));

        RegistrationEntity updated = registrationMapper.registrationDTOToEntity(registrationDTO);

        existing.setEventId(updated.getEventId());
        existing.setUserId(updated.getUserId());
        existing.setStatus(updated.getStatus());
        existing.setRegistrationType(updated.getRegistrationType());
        existing.setNotes(updated.getNotes());
        existing.setApprovedBy(updated.getApprovedBy());
        existing.setApprovedAt(updated.getApprovedAt());

        RegistrationEntity saved = registrationRepository.save(existing);
        return registrationMapper.registrationEntityToDTO(saved);
    }

    @Override
    @Transactional
    public void borrar(Long id) {
        if (!registrationRepository.existsById(id)) {
            throw new NoSuchElementException(REGISTRO_NO_ENCONTRADO + id);
        }
        registrationRepository.deleteById(id);
    }
}
