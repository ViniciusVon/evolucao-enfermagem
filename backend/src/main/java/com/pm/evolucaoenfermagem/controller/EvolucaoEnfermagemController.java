package com.pm.evolucaoenfermagem.controller;

import com.pm.evolucaoenfermagem.dto.evolucaoEnfermagem.EvolucaoEnfermagemRequestDTO;
import com.pm.evolucaoenfermagem.dto.evolucaoEnfermagem.EvolucaoEnfermagemResponseDTO;
import com.pm.evolucaoenfermagem.service.EvolucaoEnfermagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes/evolucao-enfermagem")
@Tag(name = "Evolução Enfermagem", description = "API para gerenciar Evoluções de Enfermagem")
public class EvolucaoEnfermagemController {
    public final EvolucaoEnfermagemService evolucaoEnfermagemService;

    public EvolucaoEnfermagemController(EvolucaoEnfermagemService evolucaoEnfermagemService) {
        this.evolucaoEnfermagemService = evolucaoEnfermagemService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as evoluções de enfermagem")
    public ResponseEntity<List<EvolucaoEnfermagemResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(evolucaoEnfermagemService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar evolução de enfermagem por Id")
    public ResponseEntity<EvolucaoEnfermagemResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(evolucaoEnfermagemService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar nova evolução de enfermagem")
    public ResponseEntity<EvolucaoEnfermagemResponseDTO> criar(
            @RequestBody EvolucaoEnfermagemRequestDTO dto) {
        return ResponseEntity.ok(evolucaoEnfermagemService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar evolução de enfermagem existente")
    public ResponseEntity<EvolucaoEnfermagemResponseDTO> atualizar(
            @PathVariable UUID id,
            @RequestBody EvolucaoEnfermagemRequestDTO dto) {
        return ResponseEntity.ok(evolucaoEnfermagemService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar evolução enfermagem existente")
    public ResponseEntity<EvolucaoEnfermagemResponseDTO> deletar(@PathVariable UUID id) {
        evolucaoEnfermagemService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
