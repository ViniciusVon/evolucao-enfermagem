package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispositivoRepository extends JpaRepository<Dispositivo, UUID> {
}
