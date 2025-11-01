package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dispositivo_tot")
public class DispositivoTot extends Dispositivo {
    @Size(min = 1, max = 20)
    private String calibre;

    public String getCalibre() {
        return calibre;
    }

    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }
}
