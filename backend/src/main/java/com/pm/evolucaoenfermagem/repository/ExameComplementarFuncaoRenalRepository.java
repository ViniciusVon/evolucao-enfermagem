package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameComplementarFuncaoRenal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExameComplementarFuncaoRenalRepository extends JpaRepository<ExameComplementarFuncaoRenal, UUID> {
}
