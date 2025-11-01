package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameComplementarFuncaoRenal;
import com.pm.evolucaoenfermagem.model.ExameComplementarHemograma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameComplementarHemogramaRepository extends JpaRepository<ExameComplementarHemograma, UUID> {
}
