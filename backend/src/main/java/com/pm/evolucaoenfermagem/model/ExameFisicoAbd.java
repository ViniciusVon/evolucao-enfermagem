package com.pm.evolucaoenfermagem.model;

import com.pm.evolucaoenfermagem.enums.AbdomeEnum;
import com.pm.evolucaoenfermagem.enums.PercussaoEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "exame_fisico_abd")
public class ExameFisicoAbd extends BaseEntity {
    @Id
    private UUID id;

    private Boolean rha;

    @Enumerated(EnumType.STRING)
    private AbdomeEnum abdome;

    @Enumerated(EnumType.STRING)
    private PercussaoEnum percussao;

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

    public Boolean getRha() {
        return rha;
    }

    public void setRha(Boolean rha) {
        this.rha = rha;
    }

    public AbdomeEnum getAbdome() {
        return abdome;
    }

    public void setAbdome(AbdomeEnum abdome) {
        this.abdome = abdome;
    }

    public PercussaoEnum getPercussao() {
        return percussao;
    }

    public void setPercussao(PercussaoEnum percussao) {
        this.percussao = percussao;
    }

    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }
}
