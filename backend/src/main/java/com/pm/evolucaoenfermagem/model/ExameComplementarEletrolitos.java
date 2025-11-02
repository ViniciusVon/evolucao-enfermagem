package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "exame_complementar_eletrolitos")
public class ExameComplementarEletrolitos extends BaseEntity {
    @Id
    private UUID id;

    @Column(precision = 5, scale = 2)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal na;

    @Column(precision = 5, scale = 2)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal k;

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

    public BigDecimal getNa() {
        return na;
    }

    public void setNa(BigDecimal na) {
        this.na = na;
    }

    public BigDecimal getK() {
        return k;
    }

    public void setK(BigDecimal k) {
        this.k = k;
    }

    public ExameComplementar getExameComplementar() {
        return exameComplementar;
    }

    public void setExameComplementar(ExameComplementar exameComplementar) {
        this.exameComplementar = exameComplementar;
    }
}
