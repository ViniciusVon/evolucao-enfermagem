package com.pm.evolucaoenfermagem.repository;

import com.pm.evolucaoenfermagem.model.Edema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EdemaRepository extends JpaRepository<Edema, UUID> {
}
