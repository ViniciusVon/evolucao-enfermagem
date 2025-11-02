package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, UUID> {
    List<Dispositivo> findByPacienteId(UUID pacienteId);
}
