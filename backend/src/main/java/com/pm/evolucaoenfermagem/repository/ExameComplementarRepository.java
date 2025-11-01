package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameComplementar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameComplementarRepository extends JpaRepository<ExameComplementar, UUID> {
}
