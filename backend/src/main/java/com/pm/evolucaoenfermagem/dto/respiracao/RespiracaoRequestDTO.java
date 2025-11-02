package com.pm.evolucaoenfermagem.dto.respiracao;

import java.math.BigDecimal;
import java.util.UUID;

public class RespiracaoRequestDTO {
    private Boolean aa;
    private Boolean vm;
    private Boolean cn;
    private BigDecimal litros;

    private String outro;

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

    public Boolean getCn() {
        return cn;
    }

    public void setCn(Boolean cn) {
        this.cn = cn;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
    }

    public String getOutro() {
        return outro;
    }

    public void setOutro(String outro) {
        this.outro = outro;
    }
}
