package com.pm.evolucaoenfermagem.controller;

import com.pm.evolucaoenfermagem.dto.cefalocaudal.CefalocaudalRequestDTO;
import com.pm.evolucaoenfermagem.dto.cefalocaudal.CefalocaudalResponseDTO;
import com.pm.evolucaoenfermagem.dto.dispositivo.DispositivoResponseDTO;
import com.pm.evolucaoenfermagem.service.CefalocaudalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cefalocaudal")
@Tag(name = "Cefalocaudal", description = "API para gerenciar Cefalocaudal")
public class CefalocaudalController {
    private final CefalocaudalService cefalocaudalService;

    public CefalocaudalController(CefalocaudalService cefalocaudalService) {
        this.cefalocaudalService = cefalocaudalService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os cefalocaudais")
    public ResponseEntity<List<CefalocaudalResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(cefalocaudalService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cefalocaudal por Id")
    public ResponseEntity<CefalocaudalResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(cefalocaudalService.buscarPorId(id));
    }

    @GetMapping("/paciente/{pacienteId}")
    @Operation(summary = "Buscar cefalocaudais por paciente ID")
    public ResponseEntity<List<CefalocaudalResponseDTO>> buscarPorPacienteId(@PathVariable UUID pacienteId) {
        return ResponseEntity.ok(cefalocaudalService.buscarPorPacienteId(pacienteId));
    }

    @PostMapping
    @Operation(summary = "Criar novo cefalocaudal")
    public ResponseEntity<CefalocaudalResponseDTO> criar(
            @RequestBody CefalocaudalRequestDTO dto) {
        return ResponseEntity.ok(cefalocaudalService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar cefalocaudal existente")
    public ResponseEntity<CefalocaudalResponseDTO> atualizar(
            @PathVariable UUID id,
            @RequestBody CefalocaudalRequestDTO dto) {
        return ResponseEntity.ok(cefalocaudalService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar cefalocaudal existente")
    public ResponseEntity<CefalocaudalResponseDTO> deletar(@PathVariable UUID id) {
        cefalocaudalService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
