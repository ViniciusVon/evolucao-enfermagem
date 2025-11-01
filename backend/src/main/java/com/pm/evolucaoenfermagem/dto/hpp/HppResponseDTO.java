package com.pm.evolucaoenfermagem.dto.hpp;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class HppResponseDTO {

    private UUID id;
    private Boolean has;

    private Boolean dm;

    private Boolean dopc;

    private Boolean icc;

    private Boolean dac;

    private Boolean ave;

    private Boolean isAlergico;

    private String outrasComorbidades;

    private String medicamentosUsoContinuo;

    private UUID pacienteId;
    private String pacienteNome;

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

    public Boolean getAlergico() {
        return isAlergico;
    }

    public void setAlergico(Boolean alergico) {
        isAlergico = alergico;
    }

    public String getOutrasComorbidades() {
        return outrasComorbidades;
    }

    public void setOutrasComorbidades(String outrasComorbidades) {
        this.outrasComorbidades = outrasComorbidades;
    }

    public String getMedicamentosUsoContinuo() {
        return medicamentosUsoContinuo;
    }

    public void setMedicamentosUsoContinuo(String medicamentosUsoContinuo) {
        this.medicamentosUsoContinuo = medicamentosUsoContinuo;
    }

    public UUID getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(UUID pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getPacienteNome() {
        return pacienteNome;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
