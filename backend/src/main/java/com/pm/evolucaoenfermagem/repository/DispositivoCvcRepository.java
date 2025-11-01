package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.DispositivoCvc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispositivoCvcRepository extends JpaRepository<DispositivoCvc, UUID> {
}
