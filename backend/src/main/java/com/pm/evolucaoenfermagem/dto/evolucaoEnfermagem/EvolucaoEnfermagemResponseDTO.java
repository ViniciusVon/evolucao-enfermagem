package com.pm.evolucaoenfermagem.dto.evolucaoEnfermagem;

import com.pm.evolucaoenfermagem.enums.EmUsoDeEnum;
import com.pm.evolucaoenfermagem.enums.EstadoGeralEnum;
import com.pm.evolucaoenfermagem.enums.EstadoPacienteEnum;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class EvolucaoEnfermagemResponseDTO {
    private UUID id;

    private Boolean hemodinamententeEstavel;

    private String sala;

    private String usoDe;

    private EmUsoDeEnum emUsoDe;

    private EstadoGeralEnum estadoGeral;

    private EstadoPacienteEnum estadoPaciente;

    @NotNull
    private UUID pacienteId;

    private String pacienteNome;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Boolean getHemodinamententeEstavel() {
        return hemodinamententeEstavel;
    }

    public void setHemodinamententeEstavel(Boolean hemodinamententeEstavel) {
        this.hemodinamententeEstavel = hemodinamententeEstavel;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getUsoDe() {
        return usoDe;
    }

    public void setUsoDe(String usoDe) {
        this.usoDe = usoDe;
    }

    public EmUsoDeEnum getEmUsoDe() {
        return emUsoDe;
    }

    public void setEmUsoDe(EmUsoDeEnum emUsoDe) {
        this.emUsoDe = emUsoDe;
    }

    public EstadoGeralEnum getEstadoGeral() {
        return estadoGeral;
    }

    public void setEstadoGeral(EstadoGeralEnum estadoGeral) {
        this.estadoGeral = estadoGeral;
    }

    public EstadoPacienteEnum getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(EstadoPacienteEnum estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
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
}
