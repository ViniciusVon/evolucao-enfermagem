package com.pm.evolucaoenfermagem.controller;

import com.pm.evolucaoenfermagem.dto.edema.EdemaRequestDTO;
import com.pm.evolucaoenfermagem.dto.edema.EdemaResponseDTO;
import com.pm.evolucaoenfermagem.service.EdemaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes/edemas")
@Tag(name = "Edemas", description = "API para gerenciar edemas do paciente")
public class EdemaController {

    private final EdemaService edemaService;

    public EdemaController(EdemaService edemaService) {
        this.edemaService = edemaService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os edemas")
    public ResponseEntity<List<EdemaResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(edemaService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar edema por ID")
    public ResponseEntity<EdemaResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(edemaService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar novo edema")
    public ResponseEntity<EdemaResponseDTO> criar(@RequestBody EdemaRequestDTO edemaRequestDTO) {
        return ResponseEntity.ok(edemaService.criar(edemaRequestDTO));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um edema existente")
    public ResponseEntity<EdemaResponseDTO> atualizar(
            @PathVariable UUID id,
            @RequestBody EdemaRequestDTO edemaRequestDTO) {
        return ResponseEntity.ok(edemaService.atualizar(id, edemaRequestDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um edema existente")
    public ResponseEntity<EdemaResponseDTO> deletar(@PathVariable UUID id) {
        edemaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
