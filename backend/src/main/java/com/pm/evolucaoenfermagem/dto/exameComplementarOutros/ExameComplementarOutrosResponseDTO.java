package com.pm.evolucaoenfermagem.dto.exameComplementarOutros;

import java.util.UUID;

public class ExameComplementarOutrosResponseDTO {
    private UUID id;
    private UUID exameComplementarId;
    private String nomeExame;
    private String valor;
    private String unidade;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getExameComplementarId() {
        return exameComplementarId;
    }

    public void setExameComplementarId(UUID exameComplementarId) {
        this.exameComplementarId = exameComplementarId;
    }

    public String getNomeExame() {
        return nomeExame;
    }

    public void setNomeExame(String nomeExame) {
        this.nomeExame = nomeExame;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
