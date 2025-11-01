package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "exame_fisico_ext")
public class ExameFisicoExt extends BaseEntity {
    @Id
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "edema_id")
    private Edema edema;

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

    public Edema getEdema() {
        return edema;
    }

    public void setEdema(Edema edema) {
        this.edema = edema;
    }

    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }
}
