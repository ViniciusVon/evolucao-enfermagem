package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Hpp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HppRepository extends JpaRepository<Hpp, UUID> {
    List<Hpp> findByPacienteId(UUID pacienteId);
}
