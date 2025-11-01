package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameFisicoAcv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameFisicoAcvRepository extends JpaRepository<ExameFisicoAcv, UUID> {
}
