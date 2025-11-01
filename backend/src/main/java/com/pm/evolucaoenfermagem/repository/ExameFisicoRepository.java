package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameFisico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameFisicoRepository extends JpaRepository<ExameFisico, UUID> {
}
