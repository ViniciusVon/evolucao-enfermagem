package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "hpp")
public class Hpp extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Boolean has;

    private Boolean dm;

    private Boolean dopc;

    private Boolean icc;

    private Boolean dac;

    private Boolean ave;

    @Size(min = 3, max = 100)
    private String outrasComorbidades;

    private Boolean isAlergico;

    @Size(min = 3, max = 255)
    private String medicamentosUsoContinuo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private Paciente paciente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getHas() {
        return has;
    }

    public void setHas(Boolean has) {
        this.has = has;
    }

    public Boolean getDm() {
        return dm;
    }

    public void setDm(Boolean dm) {
        this.dm = dm;
    }

    public Boolean getDopc() {
        return dopc;
    }

    public void setDopc(Boolean dopc) {
        this.dopc = dopc;
    }

    public Boolean getIcc() {
        return icc;
    }

    public void setIcc(Boolean icc) {
        this.icc = icc;
    }

    public Boolean getDac() {
        return dac;
    }

    public void setDac(Boolean dac) {
        this.dac = dac;
    }

    public Boolean getAve() {
        return ave;
    }

    public void setAve(Boolean ave) {
        this.ave = ave;
    }

    public String getOutrasComorbidades() {
        return outrasComorbidades;
    }

    public void setOutrasComorbidades(String outrasComorbidades) {
        this.outrasComorbidades = outrasComorbidades;
    }

    public Boolean getAlergico() {
        return isAlergico;
    }

    public void setAlergico(Boolean alergico) {
        isAlergico = alergico;
    }

    public String getMedicamentosUsoContinuo() {
        return medicamentosUsoContinuo;
    }

    public void setMedicamentosUsoContinuo(String medicamentosUsoContinuo) {
        this.medicamentosUsoContinuo = medicamentosUsoContinuo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
