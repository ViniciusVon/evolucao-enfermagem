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
    @Operation(summary = "Listar todos os Pacientes")
    public ResponseEntity<List<PacienteResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar paciente por ID")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok().body(pacienteService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar um novo paciente")
    public ResponseEntity<PacienteResponseDTO> criarPacientes(
            @RequestBody PacienteRequestDTO dto) {
        return ResponseEntity.ok(pacienteService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um paciente existente")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente(
            @PathVariable UUID id,
            @RequestBody PacienteRequestDTO pacienteRequestDTO) {
        return  ResponseEntity.ok(pacienteService.atualizar(id, pacienteRequestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um paciente existente")
    public ResponseEntity<Void> deletarPaciente(@PathVariable UUID id) {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
