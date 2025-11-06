package org.example.sis_eventos.controller;

import org.example.sis_eventos.dto.RegistrationDTO;
import org.example.sis_eventos.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/registrations")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<List<RegistrationDTO>> listarRegistros() {
        return new ResponseEntity<>(registrationService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDTO> obtenerRegistroPorId(@PathVariable Long id) {
        return new ResponseEntity<>(registrationService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegistrationDTO> crearRegistro(@Valid @RequestBody RegistrationDTO registrationDTO) {
        return new ResponseEntity<>(registrationService.guardar(registrationDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RegistrationDTO> actualizarRegistro(@Valid @RequestBody RegistrationDTO registrationDTO) {
        return new ResponseEntity<>(registrationService.editar(registrationDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRegistro(@PathVariable Long id) {
        registrationService.borrar(id);
        return new ResponseEntity<>("Registro con ID " + id + " eliminado correctamente", HttpStatus.OK);
    }
}

