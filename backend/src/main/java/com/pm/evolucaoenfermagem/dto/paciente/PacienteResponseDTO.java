package com.pm.evolucaoenfermagem.dto.paciente;

public class PacienteResponseDTO {
    private String id;
    private String nome;
    private String peso;
    private Integer ses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Integer getSes() {
        return ses;
    }

    public void setSes(Integer ses) {
        this.ses = ses;
    }
}
