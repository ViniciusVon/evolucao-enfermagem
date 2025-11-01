package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "exame_complementar_enzima_hepatica")
public class ExameComplementarEnzimaHepatica extends BaseEntity {
    @Id
    private UUID id;

    @Column(precision = 6, scale = 2)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal tgo;

    @Column(precision = 6, scale = 2)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal tgp;

    @Column(precision = 6, scale = 2)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal fal;

    @Column(precision = 6, scale = 2)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal ggt;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private ExameComplementar exameComplementar;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getTgo() {
        return tgo;
    }

    public void setTgo(BigDecimal tgo) {
        this.tgo = tgo;
    }

    public BigDecimal getTgp() {
        return tgp;
    }

    public void setTgp(BigDecimal tgp) {
        this.tgp = tgp;
    }

    public BigDecimal getFal() {
        return fal;
    }

    public void setFal(BigDecimal fal) {
        this.fal = fal;
    }

    public BigDecimal getGgt() {
        return ggt;
    }

    public void setGgt(BigDecimal ggt) {
        this.ggt = ggt;
    }

    public ExameComplementar getExameComplementar() {
        return exameComplementar;
    }

    public void setExameComplementar(ExameComplementar exameComplementar) {
        this.exameComplementar = exameComplementar;
    }
}
