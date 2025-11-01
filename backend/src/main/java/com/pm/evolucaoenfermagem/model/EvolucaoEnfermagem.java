package com.pm.evolucaoenfermagem.model;

import com.pm.evolucaoenfermagem.enums.EmUsoDeEnum;
import com.pm.evolucaoenfermagem.enums.EstadoGeralEnum;
import com.pm.evolucaoenfermagem.enums.EstadoPacienteEnum;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "evolucao_enfermagem")
public class EvolucaoEnfermagem extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String sala;

    private String usoDe;

    private Boolean hemodinamicamenteEstavel;

    @Enumerated(EnumType.STRING)
    private EstadoGeralEnum estadoGeral;

    @Enumerated(EnumType.STRING)
    private EmUsoDeEnum emUsoDe;

    @Enumerated(EnumType.STRING)
    private EstadoPacienteEnum estadoPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @OneToOne(mappedBy = "evolucaoEnfermagem")
    private Respiracao respiracao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getUsoDe() {
        return usoDe;
    }

    public void setUsoDe(String usoDe) {
        this.usoDe = usoDe;
    }

    public Boolean getHemodinamicamenteEstavel() {
        return hemodinamicamenteEstavel;
    }

    public void setHemodinamicamenteEstavel(Boolean hemodinamicamenteEstavel) {
        this.hemodinamicamenteEstavel = hemodinamicamenteEstavel;
    }

    public EstadoGeralEnum getEstadoGeral() {
        return estadoGeral;
    }

    public void setEstadoGeral(EstadoGeralEnum estadoGeral) {
        this.estadoGeral = estadoGeral;
    }

    public EmUsoDeEnum getEmUsoDe() {
        return emUsoDe;
    }

    public void setEmUsoDe(EmUsoDeEnum emUsoDe) {
        this.emUsoDe = emUsoDe;
    }

    public EstadoPacienteEnum getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(EstadoPacienteEnum estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Respiracao getRespiracao() {
        return respiracao;
    }

    public void setRespiracao(Respiracao respiracao) {
        this.respiracao = respiracao;
    }
}
