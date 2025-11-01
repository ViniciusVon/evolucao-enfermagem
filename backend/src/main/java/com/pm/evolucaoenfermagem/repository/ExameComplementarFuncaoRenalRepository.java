package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameComplementarFuncaoRenal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameComplementarFuncaoRenalRepository extends JpaRepository<ExameComplementarFuncaoRenal, UUID> {
}
