package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "exame_fisico_ssvv")
public class ExameFisicoSsvv extends BaseEntity {
    @Id
    private UUID id;

    private Long paSistolica;

    private Long paDiastolica;

    private Long fc;

    private Long pulso;

    @Column(precision = 5, scale = 2)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal spO2;

    @Column(precision = 4, scale = 1)
    @Digits(integer = 3, fraction = 1)
    private BigDecimal tax;

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

    public Long getPaSistolica() {
        return paSistolica;
    }

    public void setPaSistolica(Long paSistolica) {
        this.paSistolica = paSistolica;
    }

    public Long getPaDiastolica() {
        return paDiastolica;
    }

    public void setPaDiastolica(Long paDiastolica) {
        this.paDiastolica = paDiastolica;
    }

    public Long getFc() {
        return fc;
    }

    public void setFc(Long fc) {
        this.fc = fc;
    }

    public Long getPulso() {
        return pulso;
    }

    public void setPulso(Long pulso) {
        this.pulso = pulso;
    }

    public BigDecimal getSpO2() {
        return spO2;
    }

    public void setSpO2(BigDecimal spO2) {
        this.spO2 = spO2;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public ExameFisico getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(ExameFisico exameFisico) {
        this.exameFisico = exameFisico;
    }
}
