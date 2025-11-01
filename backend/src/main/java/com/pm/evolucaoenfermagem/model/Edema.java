package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "edema")
public class Edema extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Boolean extremidadesQuentes;

    @Size(min = 1, max = 50)
    private String local;

    @Size(min = 1, max = 50)
    private String grau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cefalocaudal_id", nullable = true)
    private Cefalocaudal cefalocaudal;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getExtremidadesQuentes() {
        return extremidadesQuentes;
    }

    public void setExtremidadesQuentes(Boolean extremidadesQuentes) {
        this.extremidadesQuentes = extremidadesQuentes;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public Cefalocaudal getCefalocaudal() {
        return cefalocaudal;
    }

    public void setCefalocaudal(Cefalocaudal cefalocaudal) {
        this.cefalocaudal = cefalocaudal;
    }
}
