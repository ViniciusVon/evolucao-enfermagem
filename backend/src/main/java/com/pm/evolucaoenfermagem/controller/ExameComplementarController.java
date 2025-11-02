package com.pm.evolucaoenfermagem.controller;

import com.pm.evolucaoenfermagem.dto.exameComplementar.ExameComplementarRequestDTO;
import com.pm.evolucaoenfermagem.dto.exameComplementar.ExameComplementarResponseDTO;
import com.pm.evolucaoenfermagem.service.ExameComplementarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes/exame-complementar")
@Tag(name = "Exame Complementar", description = "API para gerenciar exames complementares")
public class ExameComplementarController {

    private final ExameComplementarService exameComplementarService;

    public ExameComplementarController(ExameComplementarService exameComplementarService) {
        this.exameComplementarService = exameComplementarService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os exames complementares")
    public ResponseEntity<List<ExameComplementarResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(exameComplementarService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar exame complementar por Id")
    public ResponseEntity<ExameComplementarResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(exameComplementarService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar novo exame complementar")
    public ResponseEntity<ExameComplementarResponseDTO> criar(
            @RequestBody ExameComplementarRequestDTO dto) {
        return ResponseEntity.ok(exameComplementarService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar exame complementar existente")
    public ResponseEntity<ExameComplementarResponseDTO> atualizar(
            @PathVariable UUID id,
            @RequestBody ExameComplementarRequestDTO dto) {
        return ResponseEntity.ok(exameComplementarService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar exame complementar existente")
    public ResponseEntity<ExameComplementarResponseDTO> deletar(@PathVariable UUID id) {
        exameComplementarService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
