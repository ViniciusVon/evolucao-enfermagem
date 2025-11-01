package com.pm.evolucaoenfermagem.dto.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class PacienteRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome não pode ultrapassar 100 caracteres")
    private String nome;

    private BigDecimal peso;

    @NotNull
    private Long ses;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Long getSes() {
        return ses;
    }

    public void setSes(Long ses) {
        this.ses = ses;
    }
}
