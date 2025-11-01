package com.pm.evolucaoenfermagem.dto.edema;

import com.pm.evolucaoenfermagem.enums.CurativoEnum;
import com.pm.evolucaoenfermagem.enums.TipoDispositivoEnum;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class EdemaRequestDTO {

    private Boolean extremidadesQuentes;

    private String local;

    private String grau;

    private UUID cefalocaudalId;

    public Boolean getExtremidadesQuentes() {
        return extremidadesQuentes;
    }

    public void setExtremidadesQuentes(Boolean extremidadesQuentes) {
        this.extremidadesQuentes = extremidadesQuentes;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public UUID getCefalocaudalId() {
        return cefalocaudalId;
    }

    public void setCefalocaudalId(UUID cefalocaudalId) {
        this.cefalocaudalId = cefalocaudalId;
    }
}
