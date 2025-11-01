package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Cefalocaudal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CefalocaudalRepository extends JpaRepository<Cefalocaudal, UUID> {
}
