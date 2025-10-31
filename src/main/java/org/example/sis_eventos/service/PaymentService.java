package org.example.sis_eventos.service;

import org.example.sis_eventos.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    List<PaymentDTO> listar();

    PaymentDTO buscarPorId(Long id);

    PaymentDTO guardar(PaymentDTO paymentDTO);

    PaymentDTO editar(PaymentDTO paymentDTO);

    void borrar(Long id);
}