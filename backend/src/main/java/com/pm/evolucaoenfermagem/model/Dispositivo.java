package com.pm.evolucaoenfermagem.model;

import com.pm.evolucaoenfermagem.enums.TipoDispositivoEnum;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "dispositivo")
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispositivo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TipoDispositivoEnum tipoDispositivoEnum;

    private Boolean isUtilizado;

    private Date dataInstalacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TipoDispositivoEnum getDispositivoTipo() {
        return tipoDispositivoEnum;
    }

    public void setDispositivoTipo(TipoDispositivoEnum tipoDispositivoEnum) {
        this.tipoDispositivoEnum = tipoDispositivoEnum;
    }

    public Boolean getUtilizado() {
        return isUtilizado;
    }

    public void setUtilizado(Boolean utilizado) {
        isUtilizado = utilizado;
    }

    public Date getDataInstalacao() {
        return dataInstalacao;
    }

    public void setDataInstalacao(Date dataInstalacao) {
        this.dataInstalacao = dataInstalacao;
    }

    public TipoDispositivoEnum getTipoDispositivoEnum() {
        return tipoDispositivoEnum;
    }

    public void setTipoDispositivoEnum(TipoDispositivoEnum tipoDispositivoEnum) {
        this.tipoDispositivoEnum = tipoDispositivoEnum;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
