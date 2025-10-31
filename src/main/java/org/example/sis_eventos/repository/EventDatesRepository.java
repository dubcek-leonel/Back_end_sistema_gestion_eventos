package org.example.sis_eventos.repository;

import org.example.sis_eventos.entity.EventDatesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDatesRepository extends JpaRepository<EventDatesEntity, Long> {
}
