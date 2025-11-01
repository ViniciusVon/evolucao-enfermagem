package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.EvolucaoEnfermagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EvolucaoEnfermagemRepository extends JpaRepository<EvolucaoEnfermagem, UUID> {
}
