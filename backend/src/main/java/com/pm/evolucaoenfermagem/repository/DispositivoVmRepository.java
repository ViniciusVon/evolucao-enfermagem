package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.DispositivoVm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispositivoVmRepository extends JpaRepository<DispositivoVm, UUID> {
}
