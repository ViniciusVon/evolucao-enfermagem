package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.DispositivoPai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispositivoPaiRepository extends JpaRepository<DispositivoPai, UUID> {
}
