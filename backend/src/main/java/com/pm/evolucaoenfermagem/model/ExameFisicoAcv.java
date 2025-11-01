package com.pm.evolucaoenfermagem.model;

import com.pm.evolucaoenfermagem.enums.PulsosPerifericosEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "exame_fisico_acv")
public class ExameFisicoAcv extends BaseEntity {
    @Id
    public UUID id;

    private Boolean ritmoRegular;

    private Boolean taquicardico;

    private Long tec;

    @Enumerated(EnumType.STRING)
    private PulsosPerifericosEnum pulsos;

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

    public Boolean getRitmoRegular() {
        return ritmoRegular;
    }

    public void setRitmoRegular(Boolean ritmoRegular) {
        this.ritmoRegular = ritmoRegular;
    }

    public Boolean getTaquicardico() {
        return taquicardico;
    }

    public void setTaquicardico(Boolean taquicardico) {
        this.taquicardico = taquicardico;
    }

    public Long getTec() {
        return tec;
    }

    public void setTec(Long tec) {
        this.tec = tec;
    }

    public PulsosPerifericosEnum getPulsos() {
        return pulsos;
    }

    public void setPulsos(PulsosPerifericosEnum pulsos) {
        this.pulsos = pulsos;
    }

    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }
}
