package org.example.sis_eventos.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.sis_eventos.dto.UsersDTO;
import org.example.sis_eventos.service.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public ResponseEntity<List<UsersDTO>> finfAll() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(usersService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsersDTO> save(@Valid @RequestBody UsersDTO usersDTO) {
        return new ResponseEntity<>(usersService.save(usersDTO), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDTO> update(@PathVariable Long id,@Valid @RequestBody UsersDTO usersDTO) {
        return new ResponseEntity<>(usersService.update(id,usersDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usersService.delete(id);
        return new ResponseEntity<>("eliminado", HttpStatus.OK);
    }
}
