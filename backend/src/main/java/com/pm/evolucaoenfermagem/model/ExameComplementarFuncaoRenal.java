package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "exame_complementar_funcao_renal")
public class ExameComplementarFuncaoRenal extends BaseEntity {
    @Id
    private UUID id;

    @Column(precision = 5, scale = 2)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal ur;

    @Column(precision = 5, scale = 2)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal cr;

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

    public BigDecimal getUr() {
        return ur;
    }

    public void setUr(BigDecimal ur) {
        this.ur = ur;
    }

    public BigDecimal getCr() {
        return cr;
    }

    public void setCr(BigDecimal cr) {
        this.cr = cr;
    }

    public ExameComplementar getExameComplementar() {
        return exameComplementar;
    }

    public void setExameComplementar(ExameComplementar exameComplementar) {
        this.exameComplementar = exameComplementar;
    }
}
