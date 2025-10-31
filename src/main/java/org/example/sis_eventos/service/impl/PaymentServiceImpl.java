package org.example.sis_eventos.service.impl;

import org.example.sis_eventos.dto.PaymentDTO;
import org.example.sis_eventos.entity.PaymentEntity;
import org.example.sis_eventos.mapper.PaymentMapper;
import org.example.sis_eventos.repository.PaymentRepository;
import org.example.sis_eventos.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    private static final String PAGO_NO_ENCONTRADO = "Pago no encontrado con ID: ";

    @Override
    @Transactional(readOnly = true) // Solo lectura
    public List<PaymentDTO> listar() {
        List<PaymentEntity> payments = paymentRepository.findAll();
        return paymentMapper.paymentsEntitiesAPaymentDTOs(payments);
    }

    @Override
    @Transactional(readOnly = true)
    public PaymentDTO buscarPorId(Long id) {
        PaymentEntity paymentEntity = paymentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(PAGO_NO_ENCONTRADO + id));
        return paymentMapper.paymentEntityAPaymentDTO(paymentEntity);
    }

    @Override
    @Transactional
    public PaymentDTO guardar(PaymentDTO paymentDTO) {
        PaymentEntity paymentEntity = paymentMapper.paymentDTOAPaymentEntity(paymentDTO);

        PaymentEntity savedEntity = paymentRepository.save(paymentEntity);

        return paymentMapper.paymentEntityAPaymentDTO(savedEntity);
    }

    @Override
    @Transactional
    public PaymentDTO editar(PaymentDTO paymentDTO) {
        if (paymentDTO.getId() == null) {
            throw new IllegalArgumentException("El ID del pago es requerido para la edición.");
        }

        PaymentEntity existingEntity = paymentRepository.findById(paymentDTO.getId())
                .orElseThrow(() -> new NoSuchElementException(PAGO_NO_ENCONTRADO + paymentDTO.getId()));

        PaymentEntity updatedEntity = paymentMapper.paymentDTOAPaymentEntity(paymentDTO);

        existingEntity.setRegistrationId(updatedEntity.getRegistrationId());
        existingEntity.setAmount(updatedEntity.getAmount());
        existingEntity.setCurrency(updatedEntity.getCurrency());
        existingEntity.setPaymentMethod(updatedEntity.getPaymentMethod());
        existingEntity.setPaymentStatus(updatedEntity.getPaymentStatus());
        existingEntity.setTransactionReference(updatedEntity.getTransactionReference());
        existingEntity.setPaymentProofUrl(updatedEntity.getPaymentProofUrl());
        existingEntity.setVerifiedBy(updatedEntity.getVerifiedBy());
        existingEntity.setVerifiedAt(updatedEntity.getVerifiedAt());
        existingEntity.setNotes(updatedEntity.getNotes());

        PaymentEntity savedEntity = paymentRepository.save(existingEntity);

        return paymentMapper.paymentEntityAPaymentDTO(savedEntity);
    }

    @Override
    @Transactional
    public void borrar(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new NoSuchElementException(PAGO_NO_ENCONTRADO + id);
        }
        paymentRepository.deleteById(id);
    }
}