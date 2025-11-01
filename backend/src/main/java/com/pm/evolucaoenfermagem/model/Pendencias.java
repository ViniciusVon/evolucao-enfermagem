package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "pendencias")
public class Pendencias extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Boolean aguardandoVagaUti;

    private Boolean coletaExames;

    private Boolean trocaCurativos;

    private Boolean avaliacaoMedica;

    @OneToOne()
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getAguardandoVagaUti() {
        return aguardandoVagaUti;
    }

    public void setAguardandoVagaUti(Boolean aguardandoVagaUti) {
        this.aguardandoVagaUti = aguardandoVagaUti;
    }

    public Boolean getColetaExames() {
        return coletaExames;
    }

    public void setColetaExames(Boolean coletaExames) {
        this.coletaExames = coletaExames;
    }

    public Boolean getTrocaCurativos() {
        return trocaCurativos;
    }

    public void setTrocaCurativos(Boolean trocaCurativos) {
        this.trocaCurativos = trocaCurativos;
    }

    public Boolean getAvaliacaoMedica() {
        return avaliacaoMedica;
    }

    public void setAvaliacaoMedica(Boolean avaliacaoMedica) {
        this.avaliacaoMedica = avaliacaoMedica;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
