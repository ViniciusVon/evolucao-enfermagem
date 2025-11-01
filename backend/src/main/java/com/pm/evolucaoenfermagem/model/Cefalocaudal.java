package com.pm.evolucaoenfermagem.model;

import com.pm.evolucaoenfermagem.enums.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cefalocaudal")
public class Cefalocaudal extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Boolean pupilasFotorreagentes;

    private Boolean oftalmoplegia;

    private Boolean ra;

    private Boolean rha;

    private Boolean reagePalpitacao;

    private Integer tec;

    @Enumerated(EnumType.STRING)
    private MucosasEnum mucosas;

    @Enumerated(EnumType.STRING)
    private MvfEnum  mvf;

    @Enumerated(EnumType.STRING)
    private AbdomeEnum abdome;

    @Enumerated(EnumType.STRING)
    private PercussaoEnum percussao;

    @Enumerated(EnumType.STRING)
    private ExtremidadesEnum extremidades;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Edema> edemas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id",  nullable = false)
    private Paciente paciente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Boolean getRha() {
        return rha;
    }

    public void setRha(Boolean rha) {
        this.rha = rha;
    }

    public Boolean getReagePalpitacao() {
        return reagePalpitacao;
    }

    public void setReagePalpitacao(Boolean reagePalpitacao) {
        this.reagePalpitacao = reagePalpitacao;
    }

    public Integer getTec() {
        return tec;
    }

    public void setTec(Integer tec) {
        this.tec = tec;
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

    public AbdomeEnum getAbdome() {
        return abdome;
    }

    public void setAbdome(AbdomeEnum abdome) {
        this.abdome = abdome;
    }

    public PercussaoEnum getPercussao() {
        return percussao;
    }

    public void setPercussao(PercussaoEnum percussao) {
        this.percussao = percussao;
    }

    public ExtremidadesEnum getExtremidades() {
        return extremidades;
    }

    public void setExtremidades(ExtremidadesEnum extremidades) {
        this.extremidades = extremidades;
    }

    public List<Edema> getEdemas() {
        return edemas;
    }

    public void setEdemas(List<Edema> edemas) {
        this.edemas = edemas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
