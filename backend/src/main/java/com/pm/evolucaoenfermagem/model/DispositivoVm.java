package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "dispositivo_vm")
public class DispositivoVm extends Dispositivo {
    @Size(min = 1, max = 30)
    private String modo;

    @Size(min = 1, max = 30)
    private String vc;

    @Size(min = 1, max = 30)
    private String peep;

    @Size(min = 1, max = 30)
    private String fr;

    @Column(precision = 6, scale = 2)
    @Digits(integer = 4, fraction = 2)
    private BigDecimal fiO2;

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getVc() {
        return vc;
    }

    public void setVc(String vc) {
        this.vc = vc;
    }

    public String getPeep() {
        return peep;
    }

    public void setPeep(String peep) {
        this.peep = peep;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public BigDecimal getFiO2() {
        return fiO2;
    }

    public void setFiO2(BigDecimal fiO2) {
        this.fiO2 = fiO2;
    }
}
