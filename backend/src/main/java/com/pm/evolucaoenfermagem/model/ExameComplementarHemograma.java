package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "exame_complementar_hemograma")
public class ExameComplementarHemograma extends BaseEntity {
    @Id
    private UUID id;

    @Column(precision = 5, scale = 2)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal hb;

    @Column(precision = 5, scale = 2)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal ht;

    private Long leucocitos;

    private Long plaquetas;

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

    public BigDecimal getHb() {
        return hb;
    }

    public void setHb(BigDecimal hb) {
        this.hb = hb;
    }

    public BigDecimal getHt() {
        return ht;
    }

    public void setHt(BigDecimal ht) {
        this.ht = ht;
    }

    public Long getLeucocitos() {
        return leucocitos;
    }

    public void setLeucocitos(Long leucocitos) {
        this.leucocitos = leucocitos;
    }

    public Long getPlaquetas() {
        return plaquetas;
    }

    public void setPlaquetas(Long plaquetas) {
        this.plaquetas = plaquetas;
    }

    public ExameComplementar getExameComplementar() {
        return exameComplementar;
    }

    public void setExameComplementar(ExameComplementar exameComplementar) {
        this.exameComplementar = exameComplementar;
    }
}
