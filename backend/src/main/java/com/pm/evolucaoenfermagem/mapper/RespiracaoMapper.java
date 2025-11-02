package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.respiracao.RespiracaoRequestDTO;
import com.pm.evolucaoenfermagem.dto.respiracao.RespiracaoResponseDTO;
import com.pm.evolucaoenfermagem.model.Respiracao;

import java.time.LocalDateTime;

public class RespiracaoMapper {
    public static RespiracaoResponseDTO toDto(Respiracao respiracao) {
        RespiracaoResponseDTO dto = new RespiracaoResponseDTO();

        dto.setId(respiracao.getId());
        dto.setAa(respiracao.getAa());
        dto.setVm(respiracao.getVm());
        dto.setCn(respiracao.getCn());
        dto.setLitros(respiracao.getLitros());
        dto.setOutro(respiracao.getOutro());

        return dto;
    }

    public static Respiracao toEntity(RespiracaoRequestDTO dto) {
        Respiracao respiracao = new Respiracao();

        respiracao.setAa(dto.getAa());
        respiracao.setVm(dto.getVm());
        respiracao.setCn(dto.getCn());
        respiracao.setLitros(dto.getLitros());
        respiracao.setOutro(dto.getOutro());
        respiracao.setCreatedAt(LocalDateTime.now());
        respiracao.setUpdatedAt(null);
        respiracao.setDeletedAt(null);

        return respiracao;
    }

    public static void updateEntityFromDto(RespiracaoRequestDTO dto, Respiracao respiracao) {
        respiracao.setAa(dto.getAa());
        respiracao.setVm(dto.getVm());
        respiracao.setCn(dto.getCn());
        respiracao.setLitros(dto.getLitros());
        respiracao.setOutro(dto.getOutro());
    }
}
