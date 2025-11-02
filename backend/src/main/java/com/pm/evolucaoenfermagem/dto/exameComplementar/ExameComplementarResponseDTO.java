package com.pm.evolucaoenfermagem.dto.exameComplementar;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class ExameComplementarResponseDTO {
    private UUID id;
    private Date dataExame;
    private UUID pacienteId;
    private String pacienteNome;

    // Subtabela Função Renal
    private BigDecimal ur;
    private BigDecimal cr;

    // Subtabela Hemograma
    private BigDecimal hb;
    private BigDecimal ht;
    private Long leucocitos;
    private Long plaquetas;

    // Subtabela eletrolitos
    private BigDecimal na;
    private BigDecimal k;

    // Subtabela Enzimas Hepaticas
    private BigDecimal tgo;
    private BigDecimal tgp;
    private BigDecimal fal;
    private BigDecimal ggt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDataExame() {
        return dataExame;
    }

    public void setDataExame(Date dataExame) {
        this.dataExame = dataExame;
    }

    public UUID getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(UUID pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getPacienteNome() {
        return pacienteNome;
    }

    public void setPacienteNome(String pacienteNome) {
        this.pacienteNome = pacienteNome;
    }

    public BigDecimal getUr() {
        return ur;
    }

    public void setUr(BigDecimal ur) {
        this.ur = ur;
    }

    public BigDecimal getCr() {
        return cr;
    }

    public void setCr(BigDecimal cr) {
        this.cr = cr;
    }

    public BigDecimal getHb() {
        return hb;
    }

    public void setHb(BigDecimal hb) {
        this.hb = hb;
    }

    public BigDecimal getHt() {
        return ht;
    }

    public void setHt(BigDecimal ht) {
        this.ht = ht;
    }

    public Long getLeucocitos() {
        return leucocitos;
    }

    public void setLeucocitos(Long leucocitos) {
        this.leucocitos = leucocitos;
    }

    public Long getPlaquetas() {
        return plaquetas;
    }

    public void setPlaquetas(Long plaquetas) {
        this.plaquetas = plaquetas;
    }

    public BigDecimal getNa() {
        return na;
    }

    public void setNa(BigDecimal na) {
        this.na = na;
    }

    public BigDecimal getK() {
        return k;
    }

    public void setK(BigDecimal k) {
        this.k = k;
    }

    public BigDecimal getTgo() {
        return tgo;
    }

    public void setTgo(BigDecimal tgo) {
        this.tgo = tgo;
    }

    public BigDecimal getTgp() {
        return tgp;
    }

    public void setTgp(BigDecimal tgp) {
        this.tgp = tgp;
    }

    public BigDecimal getFal() {
        return fal;
    }

    public void setFal(BigDecimal fal) {
        this.fal = fal;
    }

    public BigDecimal getGgt() {
        return ggt;
    }

    public void setGgt(BigDecimal ggt) {
        this.ggt = ggt;
    }
}
