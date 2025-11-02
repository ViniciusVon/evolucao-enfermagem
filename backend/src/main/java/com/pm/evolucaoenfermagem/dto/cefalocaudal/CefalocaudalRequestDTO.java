package com.pm.evolucaoenfermagem.dto.cefalocaudal;

import com.pm.evolucaoenfermagem.enums.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class CefalocaudalRequestDTO {

    private Boolean pupilasFotorreagentes;

    private Boolean oftalmoplegia;

    private Boolean ra;

    private Boolean reagePalpitacao;

    private Boolean rha;

    private AbdomeEnum abdome;

    private ExtremidadesEnum extremidades;

    private MucosasEnum mucosas;

    private MvfEnum mvf;

    private PercussaoEnum percussao;

    private Boolean tecMaiorQue2Segundos;

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

    public AbdomeEnum getAbdome() {
        return abdome;
    }

    public void setAbdome(AbdomeEnum abdome) {
        this.abdome = abdome;
    }

    public ExtremidadesEnum getExtremidades() {
        return extremidades;
    }

    public void setExtremidades(ExtremidadesEnum extremidades) {
        this.extremidades = extremidades;
    }

    public MucosasEnum getMucosas() {
        return mucosas;
    }

    public void setMucosas(MucosasEnum mucosas) {
        this.mucosas = mucosas;
    }

    public MvfEnum getMvf() {
        return mvf;
    }

    public void setMvf(MvfEnum mvf) {
        this.mvf = mvf;
    }

    public PercussaoEnum getPercussao() {
        return percussao;
    }

    public void setPercussao(PercussaoEnum percussao) {
        this.percussao = percussao;
    }

    public Boolean getTecMaiorQue2Segundos() {
        return tecMaiorQue2Segundos;
    }

    public void setTecMaiorQue2Segundos(Boolean tecMaiorQue2Segundos) {
        this.tecMaiorQue2Segundos = tecMaiorQue2Segundos;
    }

    public UUID getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(UUID pacienteId) {
        this.pacienteId = pacienteId;
    }
}
