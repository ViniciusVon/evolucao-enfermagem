package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "exame_fisico_neuro")
public class ExameFisicoNeuro extends BaseEntity {
    @Id
    private UUID id;

    private Long rass;

    private Boolean consciente;

    private Boolean semTosseVa;

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

    public Long getRass() {
        return rass;
    }

    public void setRass(Long rass) {
        this.rass = rass;
    }

    public Boolean getConsciente() {
        return consciente;
    }

    public void setConsciente(Boolean consciente) {
        this.consciente = consciente;
    }

    public Boolean getSemTosseVa() {
        return semTosseVa;
    }

    public void setSemTosseVa(Boolean semTosseVa) {
        this.semTosseVa = semTosseVa;
    }

    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }
}
