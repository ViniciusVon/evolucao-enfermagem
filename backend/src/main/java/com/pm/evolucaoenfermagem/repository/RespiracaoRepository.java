package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Respiracao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RespiracaoRepository extends JpaRepository<Respiracao, UUID> {
}
