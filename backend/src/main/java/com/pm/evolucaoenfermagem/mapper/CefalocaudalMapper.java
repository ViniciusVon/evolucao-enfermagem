package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.cefalocaudal.CefalocaudalRequestDTO;
import com.pm.evolucaoenfermagem.dto.cefalocaudal.CefalocaudalResponseDTO;
import com.pm.evolucaoenfermagem.enums.*;
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

        // Enums
        if (cefalocaudal.getAbdome() != null)
            dto.setAbdome(cefalocaudal.getAbdome().name());
        if (cefalocaudal.getExtremidades() != null)
            dto.setExtremidades(cefalocaudal.getExtremidades().name());
        if (cefalocaudal.getMucosas() != null)
            dto.setMucosas(cefalocaudal.getMucosas().name());
        if (cefalocaudal.getMvf() != null)
            dto.setMvf(cefalocaudal.getMvf().name());
        if (cefalocaudal.getPercussao() != null)
            dto.setPercussao(cefalocaudal.getPercussao().name());

        dto.setTec(cefalocaudal.getTec());

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
        cefalocaudal.setPaciente(paciente);
        cefalocaudal.setCreatedAt(LocalDateTime.now());
        cefalocaudal.setUpdatedAt(null);
        cefalocaudal.setDeletedAt(null);

        if (dto.getAbdome() != null)
            cefalocaudal.setAbdome(AbdomeEnum.valueOf(dto.getAbdome()));
        if (dto.getExtremidades() != null)
            cefalocaudal.setExtremidades(ExtremidadesEnum.valueOf(dto.getExtremidades()));
        if (dto.getMucosas() != null)
            cefalocaudal.setMucosas(MucosasEnum.valueOf(dto.getMucosas()));
        if (dto.getMvf() != null)
            cefalocaudal.setMvf(MvfEnum.valueOf(dto.getMvf()));
        if (dto.getPercussao() != null)
            cefalocaudal.setPercussao(PercussaoEnum.valueOf(dto.getPercussao()));

        cefalocaudal.setTec(dto.getTec());

        return cefalocaudal;
    }

    public static void updateEntityFromDto(CefalocaudalRequestDTO dto, Cefalocaudal cefalocaudal, Paciente paciente) {
        cefalocaudal.setPupilasFotorreagentes(dto.getPupilasFotorreagentes());
        cefalocaudal.setOftalmoplegia(dto.getOftalmoplegia());
        cefalocaudal.setRa(dto.getRa());
        cefalocaudal.setReagePalpitacao(dto.getReagePalpitacao());
        cefalocaudal.setRha(dto.getRha());
        cefalocaudal.setPaciente(paciente);

        if (dto.getAbdome() != null)
            cefalocaudal.setAbdome(AbdomeEnum.valueOf(dto.getAbdome()));
        if (dto.getExtremidades() != null)
            cefalocaudal.setExtremidades(ExtremidadesEnum.valueOf(dto.getExtremidades()));
        if (dto.getMucosas() != null)
            cefalocaudal.setMucosas(MucosasEnum.valueOf(dto.getMucosas()));
        if (dto.getMvf() != null)
            cefalocaudal.setMvf(MvfEnum.valueOf(dto.getMvf()));
        if (dto.getPercussao() != null)
            cefalocaudal.setPercussao(PercussaoEnum.valueOf(dto.getPercussao()));

        cefalocaudal.setTec(dto.getTec());
    }
}
