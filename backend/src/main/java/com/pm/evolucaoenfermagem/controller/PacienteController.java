package com.pm.evolucaoenfermagem.controller;

import com.pm.evolucaoenfermagem.dto.paciente.PacienteRequestDTO;
import com.pm.evolucaoenfermagem.dto.paciente.PacienteResponseDTO;
import com.pm.evolucaoenfermagem.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes")
@Tag(name = "Pacientes", description = "API para gerenciar Pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    @Operation(summary = "Get Pacientes")
    public ResponseEntity<List<PacienteResponseDTO>> getPacientes() {
        List<PacienteResponseDTO> pacienteDTOLista = pacienteService.buscarTodos();
        return ResponseEntity.ok().body(pacienteDTOLista);
    }

    @PostMapping
    @Operation(summary = "Criar um novo paciente")
    public ResponseEntity<PacienteResponseDTO> criarPacientes(
            @RequestBody PacienteRequestDTO pacienteRequestDTO) {

        PacienteResponseDTO pacienteResponseDTO = pacienteService.salvar(pacienteRequestDTO);

        return ResponseEntity.ok().body(pacienteResponseDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um paciente existente")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente(
            @PathVariable UUID id,
            @RequestBody PacienteRequestDTO pacienteRequestDTO) {

        PacienteResponseDTO pacienteResponseDTO = pacienteService.atualizar(id, pacienteRequestDTO);

        return ResponseEntity.ok().body(pacienteResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um paciente existente")
    public ResponseEntity<Void> deletarPaciente(@PathVariable UUID id) {

        pacienteService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
