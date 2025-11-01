package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.paciente.PacienteRequestDTO;
import com.pm.evolucaoenfermagem.dto.paciente.PacienteResponseDTO;
import com.pm.evolucaoenfermagem.model.Paciente;

import java.time.LocalDateTime;

public class PacienteMapper {
    public static PacienteResponseDTO toDto(Paciente paciente) {
        PacienteResponseDTO pacienteDTO = new PacienteResponseDTO();
        pacienteDTO.setId(paciente.getId().toString());
        pacienteDTO.setNome(paciente.getNome());
        pacienteDTO.setPeso(paciente.getPeso().toString());
        pacienteDTO.setSes(paciente.getSes().intValue());

        return pacienteDTO;
    }

    public static Paciente toEntity(PacienteRequestDTO pacienteRequestDTO) {
        Paciente paciente = new Paciente();
        paciente.setNome(pacienteRequestDTO.getNome());
        paciente.setSes(pacienteRequestDTO.getSes());
        paciente.setPeso(pacienteRequestDTO.getPeso());
        paciente.setCreatedAt(LocalDateTime.now());
        paciente.setUpdatedAt(null);
        paciente.setDeletedAt(null);

        return paciente;
    }
}
