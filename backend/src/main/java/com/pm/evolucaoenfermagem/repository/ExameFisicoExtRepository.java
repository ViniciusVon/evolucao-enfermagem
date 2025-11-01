package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameFisicoExt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameFisicoExtRepository extends JpaRepository<ExameFisicoExt, UUID> {
}
