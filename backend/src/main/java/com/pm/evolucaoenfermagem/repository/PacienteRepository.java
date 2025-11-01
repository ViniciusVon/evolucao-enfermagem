package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
}
