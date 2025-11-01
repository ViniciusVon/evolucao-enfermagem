package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.DispositivoTot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispositivoTotRepository extends JpaRepository<DispositivoTot, UUID> {
}
