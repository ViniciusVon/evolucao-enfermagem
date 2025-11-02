package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameComplementarEnzimaHepatica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExameComplementarEnzimaHepaticaRepository extends JpaRepository<ExameComplementarEnzimaHepatica, UUID> {
}
