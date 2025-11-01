package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "respiracao")
public class Respiracao extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Boolean aa;

    private Boolean vm;

    private String outro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "evolucao_enfermagem_id", referencedColumnName = "id", nullable = false)
    private EvolucaoEnfermagem evolucaoEnfermagem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getAa() {
        return aa;
    }

    public void setAa(Boolean aa) {
        this.aa = aa;
    }

    public Boolean getVm() {
        return vm;
    }

    public void setVm(Boolean vm) {
        this.vm = vm;
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }

    public EvolucaoEnfermagem getEvolucaoEnfermagem() {
        return evolucaoEnfermagem;
    }

    public void setEvolucaoEnfermagem(EvolucaoEnfermagem evolucaoEnfermagem) {
        this.evolucaoEnfermagem = evolucaoEnfermagem;
    }
}
