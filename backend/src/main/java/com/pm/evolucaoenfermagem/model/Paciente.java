package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "paciente")
public class Paciente extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String nome;

    @NotNull
    private Long ses;

    @Column(precision = 5, scale = 2)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal peso;

    @OneToOne(mappedBy = "paciente")
    private Hpp hpp;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ExameFisico> examesFisico;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dispositivo> dispositivos;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EvolucaoEnfermagem> evolucoesEnfermagem;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Cefalocaudal> cefalocaudais;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getSes() {
        return ses;
    }

    public void setSes(Long ses) {
        this.ses = ses;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public List<ExameFisico> getExamesFisico() {
        return examesFisico;
    }

    public void setExamesFisico(List<ExameFisico> examesFisico) {
        this.examesFisico = examesFisico;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    public List<EvolucaoEnfermagem> getEvolucoesEnfermagem() {
        return evolucoesEnfermagem;
    }

    public void setEvolucoesEnfermagem(List<EvolucaoEnfermagem> evolucoesEnfermagem) {
        this.evolucoesEnfermagem = evolucoesEnfermagem;
    }

    public Hpp getHpp() {
        return hpp;
    }

    public void setHpp(Hpp hpp) {
        this.hpp = hpp;
    }

    public List<Cefalocaudal> getCefalocaudais() {
        return cefalocaudais;
    }

    public void setCefalocaudais(List<Cefalocaudal> cefalocaudais) {
        this.cefalocaudais = cefalocaudais;
    }
}
