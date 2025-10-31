package org.example.sis_eventos.service;

import org.example.sis_eventos.dto.StudentImportLogDTO;
import java.util.List;

public interface StudentImportLogService {

    List<StudentImportLogDTO> listar();

    StudentImportLogDTO buscarPorId(Long id);

    StudentImportLogDTO guardar(StudentImportLogDTO dto);

    StudentImportLogDTO editar(StudentImportLogDTO dto);

    void borrar(Long id);
}
