package com.pm.evolucaoenfermagem.model;

import com.pm.evolucaoenfermagem.enums.CurativoEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dispositivo_acesso_venoso")
public class DispositivoAcessoVenoso extends Dispositivo {
    @Size(min = 1, max = 50)
    private String local;

    @Enumerated(EnumType.STRING)
    private CurativoEnum curativo;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public CurativoEnum getCurativo() {
        return curativo;
    }

    public void setCurativo(CurativoEnum curativo) {
        this.curativo = curativo;
    }
}
