package org.example.sis_eventos.mapper;

import org.example.sis_eventos.dto.PaymentDTO;
import org.example.sis_eventos.entity.PaymentEntity; // Usando la nomenclatura y paquete 'sis_eventos'
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentDTO paymentEntityAPaymentDTO(PaymentEntity paymentEntity);

    List<PaymentDTO> paymentsEntitiesAPaymentDTOs(List<PaymentEntity> paymentEntities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    PaymentEntity paymentDTOAPaymentEntity(PaymentDTO paymentDTO);
}