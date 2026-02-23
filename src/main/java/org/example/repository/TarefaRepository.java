package org.example.repository;

import org.example.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TarefaRepository extends JpaRepository<TarefaEntity, UUID> {
}