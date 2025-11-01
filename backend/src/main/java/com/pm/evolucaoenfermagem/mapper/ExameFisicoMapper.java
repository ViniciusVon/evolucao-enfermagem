package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.exameFisico.ExameFisicoRequestDTO;
import com.pm.evolucaoenfermagem.dto.exameFisico.ExameFisicoResponseDTO;
import com.pm.evolucaoenfermagem.model.*;

import java.time.LocalDateTime;
import java.util.UUID;

public class ExameFisicoMapper {

    public static ExameFisicoResponseDTO toDto(ExameFisico exameFisico) {
        ExameFisicoResponseDTO dto = new ExameFisicoResponseDTO();

        dto.setId(exameFisico.getId());
        dto.setDataExame(exameFisico.getData_exame());

        if (exameFisico.getPaciente() != null) {
            dto.setPacienteId(exameFisico.getPaciente().getId());
            dto.setPacienteNome(exameFisico.getPaciente().getNome());
        }

        // Abdome
        if (exameFisico.getExameFisicoAbd() != null) {
            ExameFisicoAbd abd = exameFisico.getExameFisicoAbd();
            dto.setRha(abd.getRha());
            dto.setAbdome(abd.getAbdome());
            dto.setPercussao(abd.getPercussao());
        }

        // ACV
        if (exameFisico.getExameFisicoAcv() != null) {
            ExameFisicoAcv acv = exameFisico.getExameFisicoAcv();
            dto.setRitmoRegular(acv.getRitmoRegular());
            dto.setTaquicardico(acv.getTaquicardico());
            dto.setTec(acv.getTec());
            dto.setPulsos(acv.getPulsos());
        }

        // AR
        if (exameFisico.getExameFisicoAr() != null) {
            ExameFisicoAr ar = exameFisico.getExameFisicoAr();
            dto.setSemRa(ar.getSemRa());
            dto.setToraxSimetrico(ar.getToraxSimetrico());
            dto.setVm(ar.getVm());
            dto.setParametros(ar.getParametros());
            dto.setMvf(ar.getMvf());
        }

        // Ext
        if (exameFisico.getExameFisicoExt() != null) {
            ExameFisicoExt ext = exameFisico.getExameFisicoExt();
            if (ext.getEdema() != null) {
                dto.setEdemaId(ext.getEdema().getId());
            }
        }

        // Neuro
        if (exameFisico.getExameFisicoNeuro() != null) {
            ExameFisicoNeuro neuro = exameFisico.getExameFisicoNeuro();
            dto.setRass(neuro.getRass());
            dto.setConsciente(neuro.getConsciente());
            dto.setSemTosseVa(neuro.getSemTosseVa());
        }

        // SSVV
        if (exameFisico.getExameFisicoSsvv() != null) {
            ExameFisicoSsvv ssvv = exameFisico.getExameFisicoSsvv();
            dto.setPaSistolica(ssvv.getPaSistolica());
            dto.setPaDiastolica(ssvv.getPaDiastolica());
            dto.setFc(ssvv.getFc());
            dto.setPulso(ssvv.getPulso());
            dto.setSpO2(ssvv.getSpO2());
            dto.setTax(ssvv.getTax());
        }

        // Tergumentar
        if (exameFisico.getExameFisicoTergumentar() != null) {
            ExameFisicoTergumentar teg = exameFisico.getExameFisicoTergumentar();
            dto.setAfebril(teg.getAfebril());
            dto.setCor(teg.getCor());
        }

        return dto;
    }

    public static ExameFisico toEntity(ExameFisicoRequestDTO dto, Paciente paciente, Edema edema) {
        ExameFisico exame = new ExameFisico();
        exame.setData_exame(dto.getDataExame());
        exame.setPaciente(paciente);

        // Subtabela Abdome
        if (dto.getRha() != null || dto.getAbdome() != null || dto.getPercussao() != null) {
            ExameFisicoAbd abd = new ExameFisicoAbd();
            abd.setRha(dto.getRha());
            abd.setAbdome(dto.getAbdome());
            abd.setPercussao(dto.getPercussao());
            abd.setExameFisico(exame);
            exame.setExameFisicoAbd(abd);
        }

        // Subtabela ACV
        if (dto.getRitmoRegular() != null || dto.getTaquicardico() != null || dto.getTec() != null || dto.getPulsos() != null) {
            ExameFisicoAcv acv = new ExameFisicoAcv();
            acv.setRitmoRegular(dto.getRitmoRegular());
            acv.setTaquicardico(dto.getTaquicardico());
            acv.setTec(dto.getTec());
            acv.setPulsos(dto.getPulsos());
            acv.setExameFisico(exame);
            exame.setExameFisicoAcv(acv);
        }

        // Subtabela AR
        if (dto.getSemRa() != null || dto.getToraxSimetrico() != null || dto.getVm() != null || dto.getParametros() != null || dto.getMvf() != null) {
            ExameFisicoAr ar = new ExameFisicoAr();
            ar.setSemRa(dto.getSemRa());
            ar.setToraxSimetrico(dto.getToraxSimetrico());
            ar.setVm(dto.getVm());
            ar.setParametros(dto.getParametros());
            ar.setMvf(dto.getMvf());
            ar.setExameFisico(exame);
            exame.setExameFisicoAr(ar);
        }

        // Subtabela Ext
        if (edema != null) {
            ExameFisicoExt ext = new ExameFisicoExt();
            ext.setEdema(edema);
            ext.setExameFisico(exame);
            exame.setExameFisicoExt(ext);
        }

        // Subtabela Neuro
        if (dto.getRass() != null || dto.getConsciente() != null || dto.getSemTosseVa() != null) {
            ExameFisicoNeuro neuro = new ExameFisicoNeuro();
            neuro.setRass(dto.getRass());
            neuro.setConsciente(dto.getConsciente());
            neuro.setSemTosseVa(dto.getSemTosseVa());
            neuro.setExameFisico(exame);
            exame.setExameFisicoNeuro(neuro);
        }

        // Subtabela SSVV
        if (dto.getPaSistolica() != null || dto.getPaDiastolica() != null || dto.getFc() != null || dto.getPulso() != null
                || dto.getSpO2() != null || dto.getTax() != null) {
            ExameFisicoSsvv ssvv = new ExameFisicoSsvv();
            ssvv.setPaSistolica(dto.getPaSistolica());
            ssvv.setPaDiastolica(dto.getPaDiastolica());
            ssvv.setFc(dto.getFc());
            ssvv.setPulso(dto.getPulso());
            ssvv.setSpO2(dto.getSpO2());
            ssvv.setTax(dto.getTax());
            ssvv.setExameFisico(exame);
            exame.setExameFisicoSsvv(ssvv);
        }

        // Subtabela Tergumentar
        if (dto.getAfebril() != null || dto.getCor() != null) {
            ExameFisicoTergumentar teg = new ExameFisicoTergumentar();
            teg.setAfebril(dto.getAfebril());
            teg.setCor(dto.getCor());
            teg.setExameFisico(exame);
            exame.setExameFisicoTergumentar(teg);
        }

        return exame;
    }

    public static void updateEntityFromDto(ExameFisicoRequestDTO dto, ExameFisico exame, Paciente paciente, Edema edema) {
        exame.setData_exame(dto.getDataExame());
        exame.setPaciente(paciente);

        // Subtabela Abdome
        if (dto.getRha() != null || dto.getAbdome() != null || dto.getPercussao() != null) {
            ExameFisicoAbd abd = exame.getExameFisicoAbd();
            if (abd == null) {
                abd = new ExameFisicoAbd();
                abd.setExameFisico(exame);
                exame.setExameFisicoAbd(abd);
            }
            abd.setRha(dto.getRha());
            abd.setAbdome(dto.getAbdome());
            abd.setPercussao(dto.getPercussao());
        }

        // Subtabela ACV
        if (dto.getRitmoRegular() != null || dto.getTaquicardico() != null || dto.getTec() != null || dto.getPulsos() != null) {
            ExameFisicoAcv acv = exame.getExameFisicoAcv();
            if (acv == null) {
                acv = new ExameFisicoAcv();
                acv.setExameFisico(exame);
                exame.setExameFisicoAcv(acv);
            }
            acv.setRitmoRegular(dto.getRitmoRegular());
            acv.setTaquicardico(dto.getTaquicardico());
            acv.setTec(dto.getTec());
            acv.setPulsos(dto.getPulsos());
        }

        // Subtabela AR
        if (dto.getSemRa() != null || dto.getToraxSimetrico() != null || dto.getVm() != null || dto.getParametros() != null || dto.getMvf() != null) {
            ExameFisicoAr ar = exame.getExameFisicoAr();
            if (ar == null) {
                ar = new ExameFisicoAr();
                ar.setExameFisico(exame);
                exame.setExameFisicoAr(ar);
            }
            ar.setSemRa(dto.getSemRa());
            ar.setToraxSimetrico(dto.getToraxSimetrico());
            ar.setVm(dto.getVm());
            ar.setParametros(dto.getParametros());
            ar.setMvf(dto.getMvf());
        }

        // Subtabela Ext
        if (edema != null) {
            ExameFisicoExt ext = exame.getExameFisicoExt();
            if (ext == null) {
                ext = new ExameFisicoExt();
                ext.setExameFisico(exame);
                exame.setExameFisicoExt(ext);
            }
            ext.setEdema(edema);
        }

        // Subtabela Neuro
        if (dto.getRass() != null || dto.getConsciente() != null || dto.getSemTosseVa() != null) {
            ExameFisicoNeuro neuro = exame.getExameFisicoNeuro();
            if (neuro == null) {
                neuro = new ExameFisicoNeuro();
                neuro.setExameFisico(exame);
                exame.setExameFisicoNeuro(neuro);
            }
            neuro.setRass(dto.getRass());
            neuro.setConsciente(dto.getConsciente());
            neuro.setSemTosseVa(dto.getSemTosseVa());
        }

        // Subtabela SSVV
        if (dto.getPaSistolica() != null || dto.getPaDiastolica() != null || dto.getFc() != null ||
                dto.getPulso() != null || dto.getSpO2() != null || dto.getTax() != null) {
            ExameFisicoSsvv ssvv = exame.getExameFisicoSsvv();
            if (ssvv == null) {
                ssvv = new ExameFisicoSsvv();
                ssvv.setExameFisico(exame);
                exame.setExameFisicoSsvv(ssvv);
            }
            ssvv.setPaSistolica(dto.getPaSistolica());
            ssvv.setPaDiastolica(dto.getPaDiastolica());
            ssvv.setFc(dto.getFc());
            ssvv.setPulso(dto.getPulso());
            ssvv.setSpO2(dto.getSpO2());
            ssvv.setTax(dto.getTax());
        }

        // Subtabela Tergumentar
        if (dto.getAfebril() != null || dto.getCor() != null) {
            ExameFisicoTergumentar teg = exame.getExameFisicoTergumentar();
            if (teg == null) {
                teg = new ExameFisicoTergumentar();
                teg.setExameFisico(exame);
                exame.setExameFisicoTergumentar(teg);
            }
            teg.setAfebril(dto.getAfebril());
            teg.setCor(dto.getCor());
        }
    }
}
