package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameFisicoNeuro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameFisicoNeuroRepository extends JpaRepository<ExameFisicoNeuro, UUID> {
}
