package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExameFisicoRepository extends JpaRepository<ExameFisico, UUID> {
    List<ExameFisico> findByPacienteId(UUID pacienteId);
}
