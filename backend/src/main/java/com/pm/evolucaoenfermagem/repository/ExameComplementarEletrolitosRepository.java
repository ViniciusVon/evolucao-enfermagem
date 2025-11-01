package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.ExameComplementarEletrolitos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExameComplementarEletrolitosRepository extends JpaRepository<ExameComplementarEletrolitos, UUID> {
}
