package org.example.sis_eventos.controller;

import org.example.sis_eventos.dto.StudentImportLogDTO;
import org.example.sis_eventos.service.StudentImportLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-import-logs")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentImportLogController {

    @Autowired
    private StudentImportLogService service;

    @GetMapping
    public List<StudentImportLogDTO> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public StudentImportLogDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public StudentImportLogDTO crear(@RequestBody StudentImportLogDTO dto) {
        return service.guardar(dto);
    }

    @PutMapping("/{id}")
    public StudentImportLogDTO editar(@PathVariable Long id, @RequestBody StudentImportLogDTO dto) {
        dto.setId(id);
        return service.editar(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.borrar(id);
    }
}
