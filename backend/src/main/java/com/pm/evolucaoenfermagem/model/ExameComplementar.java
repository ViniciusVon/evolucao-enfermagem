package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "exame_complementar")
public class ExameComplementar extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Date dataExame;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @OneToOne(mappedBy = "exameComplementar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameComplementarEletrolitos exameComplementarEletrolitos;

    @OneToOne(mappedBy = "exameComplementar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameComplementarEnzimaHepatica exameComplementarEnzimaHepatica;

    @OneToOne(mappedBy = "exameComplementar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameComplementarFuncaoRenal exameComplementarFuncaoRenal;

    @OneToOne(mappedBy = "exameComplementar", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameComplementarHemograma exameComplementarHemograma;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exameComplementar")
    private List<ExameComplementarOutros> exameComplementarOutros;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date data_exame) {
        this.dataExame = data_exame;
    }

    public ExameComplementarEletrolitos getExameComplementarEletrolitos() {
        return exameComplementarEletrolitos;
    }

    public void setExameComplementarEletrolitos(ExameComplementarEletrolitos exameComplementarEletrolitos) {
        this.exameComplementarEletrolitos = exameComplementarEletrolitos;
    }

    public ExameComplementarEnzimaHepatica getExameComplementarEnzimaHepatica() {
        return exameComplementarEnzimaHepatica;
    }

    public void setExameComplementarEnzimaHepatica(ExameComplementarEnzimaHepatica exameComplementarEnzimaHepatica) {
        this.exameComplementarEnzimaHepatica = exameComplementarEnzimaHepatica;
    }

    public ExameComplementarFuncaoRenal getExameComplementarFuncaoRenal() {
        return exameComplementarFuncaoRenal;
    }

    public void setExameComplementarFuncaoRenal(ExameComplementarFuncaoRenal exameComplementarFuncaoRenal) {
        this.exameComplementarFuncaoRenal = exameComplementarFuncaoRenal;
    }

    public ExameComplementarHemograma getExameComplementarHemograma() {
        return exameComplementarHemograma;
    }

    public void setExameComplementarHemograma(ExameComplementarHemograma exameComplementarHemograma) {
        this.exameComplementarHemograma = exameComplementarHemograma;
    }

    public List<ExameComplementarOutros> getExameComplementarOutros() {
        return exameComplementarOutros;
    }

    public void setExameComplementarOutros(List<ExameComplementarOutros> exameComplementarOutros) {
        this.exameComplementarOutros = exameComplementarOutros;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
