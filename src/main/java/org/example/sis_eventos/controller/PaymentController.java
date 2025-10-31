package org.example.sis_eventos.controller;

import org.example.sis_eventos.dto.PaymentDTO;
import org.example.sis_eventos.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> listarPagos() {
        return new ResponseEntity<>(paymentService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> obtenerPagoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(paymentService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> crearPago(@Valid @RequestBody PaymentDTO paymentDTO) {
        return new ResponseEntity<>(paymentService.guardar(paymentDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PaymentDTO> actualizarPago(@Valid @RequestBody PaymentDTO paymentDTO) {

        return new ResponseEntity<>(paymentService.editar(paymentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPago(@PathVariable Long id) {
        paymentService.borrar(id);
        return new ResponseEntity<>("Pago con ID " + id + " eliminado con éxito", HttpStatus.OK);

    }
}