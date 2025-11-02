package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.exameComplementar.ExameComplementarRequestDTO;
import com.pm.evolucaoenfermagem.dto.exameComplementar.ExameComplementarResponseDTO;
import com.pm.evolucaoenfermagem.model.*;

import java.time.LocalDateTime;

public class ExameComplementarMapper {
    public static ExameComplementarResponseDTO toDto(ExameComplementar exameComplementar) {
        ExameComplementarResponseDTO dto = new ExameComplementarResponseDTO();

        dto.setId(exameComplementar.getId());
        dto.setDataExame(exameComplementar.getDataExame());

        if (exameComplementar.getPaciente() != null) {
            dto.setPacienteId(exameComplementar.getPaciente().getId());
            dto.setPacienteNome(exameComplementar.getPaciente().getNome());
        }

        if(exameComplementar.getExameComplementarEletrolitos() != null) {
            ExameComplementarEletrolitos eletrolitos = exameComplementar.getExameComplementarEletrolitos();
            dto.setNa(eletrolitos.getNa());
            dto.setK(eletrolitos.getK());
        }

        if(exameComplementar.getExameComplementarEnzimaHepatica() != null) {
            ExameComplementarEnzimaHepatica enzimaHepatica = exameComplementar.getExameComplementarEnzimaHepatica();
            dto.setTgo(enzimaHepatica.getTgo());
            dto.setTgp(enzimaHepatica.getTgp());
            dto.setFal(enzimaHepatica.getFal());
            dto.setGgt(enzimaHepatica.getGgt());
        }

        if(exameComplementar.getExameComplementarFuncaoRenal() != null) {
            ExameComplementarFuncaoRenal funcaoRenal = exameComplementar.getExameComplementarFuncaoRenal();
            dto.setUr(funcaoRenal.getUr());
            dto.setCr(funcaoRenal.getCr());
        }

        if(exameComplementar.getExameComplementarHemograma() != null) {
            ExameComplementarHemograma hemograma = exameComplementar.getExameComplementarHemograma();
            dto.setHb(hemograma.getHb());
            dto.setHt(hemograma.getHt());
            dto.setLeucocitos(hemograma.getLeucocitos());
            dto.setPlaquetas(hemograma.getPlaquetas());
        }

        return dto;
    }

    public static ExameComplementar toEntity(ExameComplementarRequestDTO dto, Paciente paciente) {
        ExameComplementar exameComplementar = new ExameComplementar();

        exameComplementar.setDataExame(dto.getDataExame());
        exameComplementar.setPaciente(paciente);
        exameComplementar.setCreatedAt(LocalDateTime.now());
        exameComplementar.setUpdatedAt(null);
        exameComplementar.setDeletedAt(null);

        // Criar e associar Eletrolitos
        if (dto.getNa() != null || dto.getK() != null) {
            ExameComplementarEletrolitos eletrolitos = new ExameComplementarEletrolitos();
            eletrolitos.setNa(dto.getNa());
            eletrolitos.setK(dto.getK());
            eletrolitos.setExameComplementar(exameComplementar);
            exameComplementar.setExameComplementarEletrolitos(eletrolitos);
        }

        // Criar e associar Enzima Hepática
        if (dto.getTgo() != null || dto.getTgp() != null || dto.getFal() != null || dto.getGgt() != null) {
            ExameComplementarEnzimaHepatica enzimaHepatica = new ExameComplementarEnzimaHepatica();
            enzimaHepatica.setTgo(dto.getTgo());
            enzimaHepatica.setTgp(dto.getTgp());
            enzimaHepatica.setFal(dto.getFal());
            enzimaHepatica.setGgt(dto.getGgt());
            enzimaHepatica.setExameComplementar(exameComplementar);
            exameComplementar.setExameComplementarEnzimaHepatica(enzimaHepatica);
        }

        // Criar e associar Função Renal
        if (dto.getUr() != null || dto.getCr() != null) {
            ExameComplementarFuncaoRenal funcaoRenal = new ExameComplementarFuncaoRenal();
            funcaoRenal.setUr(dto.getUr());
            funcaoRenal.setCr(dto.getCr());
            funcaoRenal.setExameComplementar(exameComplementar);
            exameComplementar.setExameComplementarFuncaoRenal(funcaoRenal);
        }

        // Criar e associar Hemograma
        if (dto.getHb() != null || dto.getHt() != null || dto.getLeucocitos() != null || dto.getPlaquetas() != null) {
            ExameComplementarHemograma hemograma = new ExameComplementarHemograma();
            hemograma.setHb(dto.getHb());
            hemograma.setHt(dto.getHt());
            hemograma.setLeucocitos(dto.getLeucocitos());
            hemograma.setPlaquetas(dto.getPlaquetas());
            hemograma.setExameComplementar(exameComplementar);
            exameComplementar.setExameComplementarHemograma(hemograma);
        }

        return exameComplementar;
    }

    public static void updateEntityFromDto(ExameComplementarRequestDTO dto, ExameComplementar exameComplementar, Paciente paciente) {
        exameComplementar.setDataExame(dto.getDataExame());
        exameComplementar.setPaciente(paciente);

        // Atualizar ou criar Eletrolitos
        if (dto.getNa() != null || dto.getK() != null) {
            ExameComplementarEletrolitos eletrolitos = exameComplementar.getExameComplementarEletrolitos();
            if (eletrolitos == null) {
                eletrolitos = new ExameComplementarEletrolitos();
                eletrolitos.setExameComplementar(exameComplementar);
                exameComplementar.setExameComplementarEletrolitos(eletrolitos);
            }
            eletrolitos.setNa(dto.getNa());
            eletrolitos.setK(dto.getK());
        }

        // Atualizar ou criar Enzima Hepática
        if (dto.getTgo() != null || dto.getTgp() != null || dto.getFal() != null || dto.getGgt() != null) {
            ExameComplementarEnzimaHepatica enzimaHepatica = exameComplementar.getExameComplementarEnzimaHepatica();
            if (enzimaHepatica == null) {
                enzimaHepatica = new ExameComplementarEnzimaHepatica();
                enzimaHepatica.setExameComplementar(exameComplementar);
                exameComplementar.setExameComplementarEnzimaHepatica(enzimaHepatica);
            }
            enzimaHepatica.setTgo(dto.getTgo());
            enzimaHepatica.setTgp(dto.getTgp());
            enzimaHepatica.setFal(dto.getFal());
            enzimaHepatica.setGgt(dto.getGgt());
        }

        // Atualizar ou criar Função Renal
        if (dto.getUr() != null || dto.getCr() != null) {
            ExameComplementarFuncaoRenal funcaoRenal = exameComplementar.getExameComplementarFuncaoRenal();
            if (funcaoRenal == null) {
                funcaoRenal = new ExameComplementarFuncaoRenal();
                funcaoRenal.setExameComplementar(exameComplementar);
                exameComplementar.setExameComplementarFuncaoRenal(funcaoRenal);
            }
            funcaoRenal.setUr(dto.getUr());
            funcaoRenal.setCr(dto.getCr());
        }

        // Atualizar ou criar Hemograma
        if (dto.getHb() != null || dto.getHt() != null || dto.getLeucocitos() != null || dto.getPlaquetas() != null) {
            ExameComplementarHemograma hemograma = exameComplementar.getExameComplementarHemograma();
            if (hemograma == null) {
                hemograma = new ExameComplementarHemograma();
                hemograma.setExameComplementar(exameComplementar);
                exameComplementar.setExameComplementarHemograma(hemograma);
            }
            hemograma.setHb(dto.getHb());
            hemograma.setHt(dto.getHt());
            hemograma.setLeucocitos(dto.getLeucocitos());
            hemograma.setPlaquetas(dto.getPlaquetas());
        }
    }
}