package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.evolucaoEnfermagem.EvolucaoEnfermagemRequestDTO;
import com.pm.evolucaoenfermagem.dto.evolucaoEnfermagem.EvolucaoEnfermagemResponseDTO;
import com.pm.evolucaoenfermagem.model.EvolucaoEnfermagem;
import com.pm.evolucaoenfermagem.model.Paciente;

import java.time.LocalDateTime;

public class EvolucaoEnfermagemMapper {
    public static EvolucaoEnfermagemResponseDTO toDto(EvolucaoEnfermagem evolucaoEnfermagem) {
        EvolucaoEnfermagemResponseDTO dto = new EvolucaoEnfermagemResponseDTO();

        dto.setId(evolucaoEnfermagem.getId());
        dto.setHemodinamententeEstavel(evolucaoEnfermagem.getHemodinamicamenteEstavel());
        dto.setSala(evolucaoEnfermagem.getSala());
        dto.setUsoDe(evolucaoEnfermagem.getUsoDe());
        dto.setEmUsoDe(evolucaoEnfermagem.getEmUsoDe());
        dto.setEstadoGeral(evolucaoEnfermagem.getEstadoGeral());
        dto.setEstadoPaciente(evolucaoEnfermagem.getEstadoPaciente());
        dto.setPacienteId(evolucaoEnfermagem.getPaciente().getId());

        return dto;
    }

    public static EvolucaoEnfermagem toEntity(EvolucaoEnfermagemRequestDTO dto, Paciente paciente) {
        EvolucaoEnfermagem evolucaoEnfermagem = new EvolucaoEnfermagem();

        evolucaoEnfermagem.setHemodinamicamenteEstavel(dto.getHemodinamententeEstavel());
        evolucaoEnfermagem.setSala(dto.getSala());
        evolucaoEnfermagem.setUsoDe(dto.getUsoDe());
        evolucaoEnfermagem.setEmUsoDe(dto.getEmUsoDe());
        evolucaoEnfermagem.setEstadoGeral(dto.getEstadoGeral());
        evolucaoEnfermagem.setEstadoPaciente(dto.getEstadoPaciente());
        evolucaoEnfermagem.setPaciente(paciente);
        evolucaoEnfermagem.setCreatedAt(LocalDateTime.now());
        evolucaoEnfermagem.setUpdatedAt(null);
        evolucaoEnfermagem.setDeletedAt(null);

        return evolucaoEnfermagem;
    }

    public static void updateEntityFromDto(EvolucaoEnfermagemRequestDTO dto, EvolucaoEnfermagem evolucaoEnfermagem, Paciente paciente) {
        evolucaoEnfermagem.setHemodinamicamenteEstavel(dto.getHemodinamententeEstavel());
        evolucaoEnfermagem.setSala(dto.getSala());
        evolucaoEnfermagem.setUsoDe(dto.getUsoDe());
        evolucaoEnfermagem.setEmUsoDe(dto.getEmUsoDe());
        evolucaoEnfermagem.setEstadoGeral(dto.getEstadoGeral());
        evolucaoEnfermagem.setEstadoPaciente(dto.getEstadoPaciente());
        evolucaoEnfermagem.setPaciente(paciente);
    }
}
