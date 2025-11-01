package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.edema.EdemaRequestDTO;
import com.pm.evolucaoenfermagem.dto.paciente.PacienteRequestDTO;
import com.pm.evolucaoenfermagem.dto.paciente.PacienteResponseDTO;
import com.pm.evolucaoenfermagem.model.Cefalocaudal;
import com.pm.evolucaoenfermagem.model.Edema;
import com.pm.evolucaoenfermagem.model.Paciente;

import java.time.LocalDateTime;

public class PacienteMapper {
    public static PacienteResponseDTO toDto(Paciente paciente) {
        PacienteResponseDTO dto = new PacienteResponseDTO();
        dto.setId(paciente.getId().toString());
        dto.setNome(paciente.getNome());
        dto.setPeso(paciente.getPeso().toString());
        dto.setSes(paciente.getSes().intValue());

        return dto;
    }

    public static Paciente toEntity(PacienteRequestDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setSes(dto.getSes());
        paciente.setPeso(dto.getPeso());
        paciente.setCreatedAt(LocalDateTime.now());
        paciente.setUpdatedAt(null);
        paciente.setDeletedAt(null);

        return paciente;
    }

    public static void updateEntityFromDto(PacienteRequestDTO dto, Paciente paciente) {
        paciente.setNome(dto.getNome());
        paciente.setSes(dto.getSes());
        paciente.setPeso(dto.getPeso());
    }
}
