package com.pm.evolucaoenfermagem.model;

import com.pm.evolucaoenfermagem.enums.CorEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "exame_fisico_tergumentar")
public class ExameFisicoTergumentar extends BaseEntity {
    @Id
    private UUID id;

    private Boolean afebril;

    @Enumerated(EnumType.STRING)
    private CorEnum cor;

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

    public Boolean getAfebril() {
        return afebril;
    }

    public void setAfebril(Boolean afebril) {
        this.afebril = afebril;
    }

    public CorEnum getCor() {
        return cor;
    }

    public void setCor(CorEnum cor) {
        this.cor = cor;
    }

    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }
}
