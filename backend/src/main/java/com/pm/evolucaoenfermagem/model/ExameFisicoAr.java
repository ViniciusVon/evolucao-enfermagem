package com.pm.evolucaoenfermagem.model;

import com.pm.evolucaoenfermagem.enums.MvfEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "exame_fisico_ar")
public class ExameFisicoAr extends BaseEntity {
    @Id
    private UUID id;

    private Boolean semRa;

    private Boolean isToraxSimetrico;

    private Boolean vm;

    @Size(min = 1, max = 255)
    private String parametros;

    @Enumerated(EnumType.STRING)
    private MvfEnum mvf;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private ExameFisico exameFisico;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getSemRa() {
        return semRa;
    }

    public void setSemRa(Boolean semRa) {
        this.semRa = semRa;
    }

    public Boolean getToraxSimetrico() {
        return isToraxSimetrico;
    }

    public void setToraxSimetrico(Boolean toraxSimetrico) {
        isToraxSimetrico = toraxSimetrico;
    }

    public Boolean getVm() {
        return vm;
    }

    public void setVm(Boolean vm) {
        this.vm = vm;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public MvfEnum getMvf() {
        return mvf;
    }

    public void setMvf(MvfEnum mvf) {
        this.mvf = mvf;
    }

    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }
}
