package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameComplementarEnzimaHepatica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameComplementarEnzimaHepaticaRepository extends JpaRepository<ExameComplementarEnzimaHepatica, UUID> {
}
