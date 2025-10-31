package org.example.sis_eventos.repository;

import org.example.sis_eventos.entity.EventoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryEvento extends JpaRepository<EventoEntity, Long> {

}
