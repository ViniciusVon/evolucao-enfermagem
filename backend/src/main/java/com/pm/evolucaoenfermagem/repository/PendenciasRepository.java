package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Pendencias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PendenciasRepository extends JpaRepository<Pendencias, UUID> {
}
