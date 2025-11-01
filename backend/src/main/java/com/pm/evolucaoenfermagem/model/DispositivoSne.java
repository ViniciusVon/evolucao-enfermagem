package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dispositivo_sne")
public class DispositivoSne extends Dispositivo {
    private Boolean isAbertaDrenagem;

    private Boolean isEmUso;

    public Boolean getAbertaDrenagem() {
        return isAbertaDrenagem;
    }

    public void setAbertaDrenagem(Boolean abertaDrenagem) {
        isAbertaDrenagem = abertaDrenagem;
    }

    public Boolean getEmUso() {
        return isEmUso;
    }

    public void setEmUso(Boolean emUso) {
        isEmUso = emUso;
    }
}
