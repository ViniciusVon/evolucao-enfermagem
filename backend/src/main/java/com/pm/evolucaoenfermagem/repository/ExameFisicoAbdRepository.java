package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameFisicoAbd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameFisicoAbdRepository extends JpaRepository<ExameFisicoAbd, UUID> {
}
