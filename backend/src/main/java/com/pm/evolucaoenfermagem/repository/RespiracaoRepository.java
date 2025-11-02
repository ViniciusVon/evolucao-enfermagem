package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Respiracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RespiracaoRepository extends JpaRepository<Respiracao, UUID> {
}
