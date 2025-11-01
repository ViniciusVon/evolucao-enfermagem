package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dispositivo_pai")
public class DispositivoPai extends Dispositivo {
    @Size(min = 1, max = 50)
    private String local;

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
