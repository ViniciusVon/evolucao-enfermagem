package com.pm.evolucaoenfermagem.dto.cefalocaudal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class CefalocaudalRequestDTO {

    private Boolean pupilasFotorreagentes;

    private Boolean oftalmoplegia;

    private Boolean ra;

    private Boolean reagePalpitacao;

    private Boolean rha;

    @Size(min = 1, max = 255)
    private String abdome;

    @Size(min = 1, max = 255)
    private String extremidades;

    @Size(min = 1, max = 255)
    private String mucosas;

    @Size(min = 1, max = 255)
    private String mvf;

    @Size(min = 1, max = 255)
    private String percussao;

    private Integer tec;

    @NotNull
    private UUID pacienteId;

    public Boolean getPupilasFotorreagentes() {
        return pupilasFotorreagentes;
    }

    public void setPupilasFotorreagentes(Boolean pupilasFotorreagentes) {
        this.pupilasFotorreagentes = pupilasFotorreagentes;
    }

    public Boolean getOftalmoplegia() {
        return oftalmoplegia;
    }

    public void setOftalmoplegia(Boolean oftalmoplegia) {
        this.oftalmoplegia = oftalmoplegia;
    }

    public Boolean getRa() {
        return ra;
    }

    public void setRa(Boolean ra) {
        this.ra = ra;
    }

    public Boolean getReagePalpitacao() {
        return reagePalpitacao;
    }

    public void setReagePalpitacao(Boolean reagePalpitacao) {
        this.reagePalpitacao = reagePalpitacao;
    }

    public Boolean getRha() {
        return rha;
    }

    public void setRha(Boolean rha) {
        this.rha = rha;
    }

    public String getAbdome() {
        return abdome;
    }

    public void setAbdome(String abdome) {
        this.abdome = abdome;
    }

    public String getExtremidades() {
        return extremidades;
    }

    public void setExtremidades(String extremidades) {
        this.extremidades = extremidades;
    }

    public String getMucosas() {
        return mucosas;
    }

    public void setMucosas(String mucosas) {
        this.mucosas = mucosas;
    }

    public String getMvf() {
        return mvf;
    }

    public void setMvf(String mvf) {
        this.mvf = mvf;
    }

    public String getPercussao() {
        return percussao;
    }

    public void setPercussao(String percussao) {
        this.percussao = percussao;
    }

    public Integer getTec() {
        return tec;
    }

    public void setTec(Integer tec) {
        this.tec = tec;
    }

    public UUID getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(UUID pacienteId) {
        this.pacienteId = pacienteId;
    }
}
