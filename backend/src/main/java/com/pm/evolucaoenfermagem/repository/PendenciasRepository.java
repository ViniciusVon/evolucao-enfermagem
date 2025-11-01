package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Pendencias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PendenciasRepository extends JpaRepository<Pendencias, UUID> {
}
