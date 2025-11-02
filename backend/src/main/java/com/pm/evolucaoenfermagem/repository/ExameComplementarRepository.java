package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameComplementar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExameComplementarRepository extends JpaRepository<ExameComplementar, UUID> {
    List<ExameComplementar> findByPacienteId(UUID pacienteId);
}
