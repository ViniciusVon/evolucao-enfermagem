package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameFisicoTergumentar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameFisicoTergumentarRepository extends JpaRepository<ExameFisicoTergumentar, UUID> {
}
