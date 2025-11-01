package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.DispositivoAcessoVenoso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DispositivoAcessoVenosoRepository extends JpaRepository<DispositivoAcessoVenoso, UUID> {
}
