package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Edema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EdemaRepository extends JpaRepository<Edema, UUID> {
}
