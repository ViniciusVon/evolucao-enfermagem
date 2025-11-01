package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.DispositivoSne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispositivoSneRepository extends JpaRepository<DispositivoSne, UUID> {
}
