package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.edema.EdemaRequestDTO;
import com.pm.evolucaoenfermagem.dto.edema.EdemaResponseDTO;
import com.pm.evolucaoenfermagem.model.Edema;
import com.pm.evolucaoenfermagem.model.Cefalocaudal;

import java.time.LocalDateTime;

public class EdemaMapper {

    public static EdemaResponseDTO toDto(Edema edema) {
        EdemaResponseDTO dto = new EdemaResponseDTO();

        dto.setId(edema.getId());
        dto.setExtremidadesQuentes(edema.getExtremidadesQuentes());
        dto.setLocal(edema.getLocal());
        dto.setGrau(edema.getGrau());

        if (edema.getCefalocaudal() != null) {
            dto.setCefalocaudalId(edema.getCefalocaudal().getId());
        }

        return dto;
    }

    public static Edema toEntity(EdemaRequestDTO dto, Cefalocaudal cefalocaudal) {
        Edema edema = new Edema();
        edema.setExtremidadesQuentes(dto.getExtremidadesQuentes());
        edema.setLocal(dto.getLocal());
        edema.setGrau(dto.getGrau());
        edema.setCreatedAt(LocalDateTime.now());
        edema.setUpdatedAt(null);
        edema.setDeletedAt(null);

        if (cefalocaudal != null) {
            edema.setCefalocaudal(cefalocaudal);
        }

        return edema;
    }

    public static void updateEntityFromDto(EdemaRequestDTO dto, Edema edema, Cefalocaudal cefalocaudal) {
        edema.setExtremidadesQuentes(dto.getExtremidadesQuentes());
        edema.setLocal(dto.getLocal());
        edema.setGrau(dto.getGrau());
        edema.setCefalocaudal(cefalocaudal);
    }

}
