package com.pm.evolucaoenfermagem.dto.dispositivo;

import com.pm.evolucaoenfermagem.enums.CurativoEnum;
import com.pm.evolucaoenfermagem.enums.TipoDispositivoEnum;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class DispositivoResponseDTO {

    private UUID id;
    private TipoDispositivoEnum tipoDispositivoEnum;
    private Boolean isUtilizado;
    private Date dataInstalacao;
    private UUID pacienteId;
    private String pacienteNome;

    // Campos específicos das subtabelas
    private String local; // CVC, PAI, ACESSO_VENOSO
    private CurativoEnum curativo; // ACESSO_VENOSO
    private Boolean isAbertaDrenagem; // SNE
    private Boolean isEmUso; // SNE
    private String calibre; // TOT
    private String modo; // VM
    private String vc;   // VM
    private String peep; // VM
    private String fr;   // VM
    private BigDecimal fiO2; // VM

    // Getters e Setters de todos os campos
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public TipoDispositivoEnum getTipoDispositivoEnum() { return tipoDispositivoEnum; }
    public void setTipoDispositivoEnum(TipoDispositivoEnum tipoDispositivoEnum) { this.tipoDispositivoEnum = tipoDispositivoEnum; }

    public Boolean getIsUtilizado() { return isUtilizado; }
    public void setIsUtilizado(Boolean isUtilizado) { this.isUtilizado = isUtilizado; }

    public Date getDataInstalacao() { return dataInstalacao; }
    public void setDataInstalacao(Date dataInstalacao) { this.dataInstalacao = dataInstalacao; }

    public UUID getPacienteId() { return pacienteId; }
    public void setPacienteId(UUID pacienteId) { this.pacienteId = pacienteId; }

    public String getPacienteNome() { return pacienteNome; }
    public void setPacienteNome(String pacienteNome) { this.pacienteNome = pacienteNome; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public CurativoEnum getCurativo() { return curativo; }
    public void setCurativo(CurativoEnum curativo) { this.curativo = curativo; }

    public Boolean getIsAbertaDrenagem() { return isAbertaDrenagem; }
    public void setIsAbertaDrenagem(Boolean isAbertaDrenagem) { this.isAbertaDrenagem = isAbertaDrenagem; }

    public Boolean getIsEmUso() { return isEmUso; }
    public void setIsEmUso(Boolean isEmUso) { this.isEmUso = isEmUso; }

    public String getCalibre() { return calibre; }
    public void setCalibre(String calibre) { this.calibre = calibre; }

    public String getModo() { return modo; }
    public void setModo(String modo) { this.modo = modo; }

    public String getVc() { return vc; }
    public void setVc(String vc) { this.vc = vc; }

    public String getPeep() { return peep; }
    public void setPeep(String peep) { this.peep = peep; }

    public String getFr() { return fr; }
    public void setFr(String fr) { this.fr = fr; }

    public BigDecimal getFiO2() { return fiO2; }
    public void setFiO2(BigDecimal fiO2) { this.fiO2 = fiO2; }
}
