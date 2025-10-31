package org.example.sis_eventos.service.impl;

import org.example.sis_eventos.dto.StudentImportLogDTO;
import org.example.sis_eventos.entity.StudentImportLogEntity;
import org.example.sis_eventos.mapper.StudentImportLogMapper;
import org.example.sis_eventos.repository.StudentImportLogRepository;
import org.example.sis_eventos.service.StudentImportLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentImportLogServiceImpl implements StudentImportLogService {

    @Autowired
    private StudentImportLogRepository repository;

    @Autowired
    private StudentImportLogMapper mapper;

    @Override
    public List<StudentImportLogDTO> listar() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public StudentImportLogDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public StudentImportLogDTO guardar(StudentImportLogDTO dto) {
        StudentImportLogEntity entity = mapper.toEntity(dto);
        entity.setCreatedAt(new Date());
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public StudentImportLogDTO editar(StudentImportLogDTO dto) {
        StudentImportLogEntity entity = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Registro no encontrado"));
        entity.setEventId(dto.getEventId());
        entity.setImportedBy(dto.getImportedBy());
        entity.setTotalRecords(dto.getTotalRecords());
        entity.setSuccessfulRecords(dto.getSuccessfulRecords());
        entity.setFailedRecords(dto.getFailedRecords());
        entity.setErrorLog(dto.getErrorLog());
        entity.setFileName(dto.getFileName());
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void borrar(Long id) {
        repository.deleteById(id);
    }
}
