package com.pm.evolucaoenfermagem.dto.exameFisico;

import com.pm.evolucaoenfermagem.enums.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class ExameFisicoRequestDTO {

    private Date dataExame;
    private UUID pacienteId;

    // Subtabela Abdome
    private Boolean rha;
    private AbdomeEnum abdome;
    private PercussaoEnum percussao;

    // Subtabela ACV
    private Boolean ritmoRegular;
    private Boolean taquicardico;
    private Long tec;
    private PulsosPerifericosEnum pulsos;

    // Subtabela AR
    private Boolean semRa;
    private Boolean toraxSimetrico;
    private Boolean vm;
    private String parametros;
    private MvfEnum mvf;

    // Subtabela Ext
    private UUID edemaId; // apenas referência ao Edema

    // Subtabela Neuro
    private Long rass;
    private Boolean consciente;
    private Boolean semTosseVa;

    // Subtabela SSVV
    private Long paSistolica;
    private Long paDiastolica;
    private Long fc;
    private Long pulso;
    private BigDecimal spO2;
    private BigDecimal tax;

    // Subtabela Tergumentar
    private Boolean afebril;
    private CorEnum cor;

    // Getters e Setters
    public Date getDataExame() { return dataExame; }
    public void setDataExame(Date dataExame) { this.dataExame = dataExame; }

    public UUID getPacienteId() { return pacienteId; }
    public void setPacienteId(UUID pacienteId) { this.pacienteId = pacienteId; }

    public Boolean getRha() { return rha; }
    public void setRha(Boolean rha) { this.rha = rha; }

    public AbdomeEnum getAbdome() { return abdome; }
    public void setAbdome(AbdomeEnum abdome) { this.abdome = abdome; }

    public PercussaoEnum getPercussao() { return percussao; }
    public void setPercussao(PercussaoEnum percussao) { this.percussao = percussao; }

    public Boolean getRitmoRegular() { return ritmoRegular; }
    public void setRitmoRegular(Boolean ritmoRegular) { this.ritmoRegular = ritmoRegular; }

    public Boolean getTaquicardico() { return taquicardico; }
    public void setTaquicardico(Boolean taquicardico) { this.taquicardico = taquicardico; }

    public Long getTec() { return tec; }
    public void setTec(Long tec) { this.tec = tec; }

    public PulsosPerifericosEnum getPulsos() { return pulsos; }
    public void setPulsos(PulsosPerifericosEnum pulsos) { this.pulsos = pulsos; }

    public Boolean getSemRa() { return semRa; }
    public void setSemRa(Boolean semRa) { this.semRa = semRa; }

    public Boolean getToraxSimetrico() { return toraxSimetrico; }
    public void setToraxSimetrico(Boolean toraxSimetrico) { this.toraxSimetrico = toraxSimetrico; }

    public Boolean getVm() { return vm; }
    public void setVm(Boolean vm) { this.vm = vm; }

    public String getParametros() { return parametros; }
    public void setParametros(String parametros) { this.parametros = parametros; }

    public MvfEnum getMvf() { return mvf; }
    public void setMvf(MvfEnum mvf) { this.mvf = mvf; }

    public UUID getEdemaId() { return edemaId; }
    public void setEdemaId(UUID edemaId) { this.edemaId = edemaId; }

    public Long getRass() { return rass; }
    public void setRass(Long rass) { this.rass = rass; }

    public Boolean getConsciente() { return consciente; }
    public void setConsciente(Boolean consciente) { this.consciente = consciente; }

    public Boolean getSemTosseVa() { return semTosseVa; }
    public void setSemTosseVa(Boolean semTosseVa) { this.semTosseVa = semTosseVa; }

    public Long getPaSistolica() { return paSistolica; }
    public void setPaSistolica(Long paSistolica) { this.paSistolica = paSistolica; }

    public Long getPaDiastolica() { return paDiastolica; }
    public void setPaDiastolica(Long paDiastolica) { this.paDiastolica = paDiastolica; }

    public Long getFc() { return fc; }
    public void setFc(Long fc) { this.fc = fc; }

    public Long getPulso() { return pulso; }
    public void setPulso(Long pulso) { this.pulso = pulso; }

    public BigDecimal getSpO2() { return spO2; }
    public void setSpO2(BigDecimal spO2) { this.spO2 = spO2; }

    public BigDecimal getTax() { return tax; }
    public void setTax(BigDecimal tax) { this.tax = tax; }

    public Boolean getAfebril() { return afebril; }
    public void setAfebril(Boolean afebril) { this.afebril = afebril; }

    public CorEnum getCor() { return cor; }
    public void setCor(CorEnum cor) { this.cor = cor; }
}
