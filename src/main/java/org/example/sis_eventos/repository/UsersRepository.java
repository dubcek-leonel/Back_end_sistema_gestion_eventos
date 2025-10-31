package org.example.sis_eventos.repository;

import org.example.sis_eventos.dto.UsersDTO;
import org.example.sis_eventos.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
}
