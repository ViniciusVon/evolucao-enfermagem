package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.hpp.HppRequestDTO;
import com.pm.evolucaoenfermagem.dto.hpp.HppResponseDTO;
import com.pm.evolucaoenfermagem.model.Hpp;
import com.pm.evolucaoenfermagem.model.Paciente;

import java.time.LocalDateTime;

public class HppMapper {

    public static HppResponseDTO toDto(Hpp hpp) {
        HppResponseDTO dto = new HppResponseDTO();

        dto.setId(hpp.getId());
        dto.setHas(hpp.getHas());
        dto.setDm(hpp.getDm());
        dto.setDopc(hpp.getDopc());
        dto.setIcc(hpp.getIcc());
        dto.setDac(hpp.getDac());
        dto.setAve(hpp.getAve());
        dto.setAlergico(hpp.getAlergico());
        dto.setOutrasComorbidades(hpp.getOutrasComorbidades());
        dto.setMedicamentosUsoContinuo(hpp.getMedicamentosUsoContinuo());

        if (hpp.getPaciente() != null) {
            dto.setPacienteId(hpp.getPaciente().getId());
            dto.setPacienteNome(hpp.getPaciente().getNome());
        }

        return dto;
    }

    public static Hpp toEntity(HppRequestDTO dto, Paciente paciente) {
        Hpp hpp = new Hpp();

        hpp.setHas(dto.getHas());
        hpp.setDm(dto.getDm());
        hpp.setDopc(dto.getDopc());
        hpp.setIcc(dto.getIcc());
        hpp.setDac(dto.getDac());
        hpp.setAve(dto.getAve());
        hpp.setAlergico(dto.getAlergico());
        hpp.setOutrasComorbidades(dto.getOutrasComorbidades());
        hpp.setMedicamentosUsoContinuo(dto.getMedicamentosUsoContinuo());
        hpp.setPaciente(paciente);
        hpp.setCreatedAt(LocalDateTime.now());
        hpp.setUpdatedAt(null);
        hpp.setDeletedAt(null);

        return hpp;
    }

    public static void updateEntityFromDto(HppRequestDTO dto, Hpp hpp, Paciente paciente) {
        hpp.setHas(dto.getHas());
        hpp.setDm(dto.getDm());
        hpp.setDopc(dto.getDopc());
        hpp.setIcc(dto.getIcc());
        hpp.setDac(dto.getDac());
        hpp.setAve(dto.getAve());
        hpp.setAlergico(dto.getAlergico());
        hpp.setOutrasComorbidades(dto.getOutrasComorbidades());
        hpp.setMedicamentosUsoContinuo(dto.getMedicamentosUsoContinuo());
        hpp.setPaciente(paciente);
        hpp.setUpdatedAt(LocalDateTime.now());
    }
}
