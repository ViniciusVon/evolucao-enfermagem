package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Cefalocaudal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CefalocaudalRepository extends JpaRepository<Cefalocaudal, UUID> {
    List<Cefalocaudal> findByPacienteId(UUID pacienteId);
}
