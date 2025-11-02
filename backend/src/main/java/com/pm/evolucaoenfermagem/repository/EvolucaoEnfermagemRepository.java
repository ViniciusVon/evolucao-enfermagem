package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.EvolucaoEnfermagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EvolucaoEnfermagemRepository extends JpaRepository<EvolucaoEnfermagem, UUID> {
    List<EvolucaoEnfermagem> findByPacienteId(UUID pacienteId);
}
