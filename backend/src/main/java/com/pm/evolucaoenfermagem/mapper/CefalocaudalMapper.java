package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.cefalocaudal.CefalocaudalRequestDTO;
import com.pm.evolucaoenfermagem.dto.cefalocaudal.CefalocaudalResponseDTO;
import com.pm.evolucaoenfermagem.model.Cefalocaudal;
import com.pm.evolucaoenfermagem.model.Paciente;

import java.time.LocalDateTime;

public class CefalocaudalMapper {
    public static CefalocaudalResponseDTO toDto(Cefalocaudal cefalocaudal) {
        CefalocaudalResponseDTO dto = new CefalocaudalResponseDTO();

        dto.setId(cefalocaudal.getId());
        dto.setPupilasFotorreagentes(cefalocaudal.getPupilasFotorreagentes());
        dto.setOftalmoplegia(cefalocaudal.getOftalmoplegia());
        dto.setRa(cefalocaudal.getRa());
        dto.setReagePalpitacao(cefalocaudal.getReagePalpitacao());
        dto.setRha(cefalocaudal.getRha());
        dto.setAbdome(cefalocaudal.getAbdome());
        dto.setExtremidades(cefalocaudal.getExtremidades());
        dto.setMucosas(cefalocaudal.getMucosas());
        dto.setMvf(cefalocaudal.getMvf());
        dto.setPercussao(cefalocaudal.getPercussao());
        dto.setTecMaiorQue2Segundos(cefalocaudal.getTecMaiorQue2Segundos());

        if (cefalocaudal.getPaciente() != null) {
            dto.setPacienteId(cefalocaudal.getPaciente().getId());
            dto.setPacienteNome(cefalocaudal.getPaciente().getNome());
        }

        return dto;
    }

    public static Cefalocaudal toEntity(CefalocaudalRequestDTO dto, Paciente paciente) {
        Cefalocaudal cefalocaudal = new Cefalocaudal();

        cefalocaudal.setPupilasFotorreagentes(dto.getPupilasFotorreagentes());
        cefalocaudal.setOftalmoplegia(dto.getOftalmoplegia());
        cefalocaudal.setRa(dto.getRa());
        cefalocaudal.setReagePalpitacao(dto.getReagePalpitacao());
        cefalocaudal.setRha(dto.getRha());
        cefalocaudal.setAbdome(dto.getAbdome());
        cefalocaudal.setExtremidades(dto.getExtremidades());
        cefalocaudal.setMucosas(dto.getMucosas());
        cefalocaudal.setMvf(dto.getMvf());
        cefalocaudal.setPercussao(dto.getPercussao());
        cefalocaudal.setTecMaiorQue2Segundos(dto.getTecMaiorQue2Segundos());
        cefalocaudal.setPaciente(paciente);
        cefalocaudal.setCreatedAt(LocalDateTime.now());
        cefalocaudal.setUpdatedAt(null);
        cefalocaudal.setDeletedAt(null);

        return cefalocaudal;
    }

    public static void updateEntityFromDto(CefalocaudalRequestDTO dto, Cefalocaudal cefalocaudal, Paciente paciente) {
        cefalocaudal.setPupilasFotorreagentes(dto.getPupilasFotorreagentes());
        cefalocaudal.setOftalmoplegia(dto.getOftalmoplegia());
        cefalocaudal.setRa(dto.getRa());
        cefalocaudal.setReagePalpitacao(dto.getReagePalpitacao());
        cefalocaudal.setRha(dto.getRha());
        cefalocaudal.setPaciente(paciente);
        cefalocaudal.setAbdome(dto.getAbdome());
        cefalocaudal.setExtremidades(dto.getExtremidades());
        cefalocaudal.setMucosas(dto.getMucosas());
        cefalocaudal.setMvf(dto.getMvf());
        cefalocaudal.setPercussao(dto.getPercussao());
        cefalocaudal.setTecMaiorQue2Segundos(dto.getTecMaiorQue2Segundos());
    }
}
