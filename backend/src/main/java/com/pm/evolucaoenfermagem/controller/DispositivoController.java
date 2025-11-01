package com.pm.evolucaoenfermagem.controller;

import com.pm.evolucaoenfermagem.dto.dispositivo.DispositivoRequestDTO;
import com.pm.evolucaoenfermagem.dto.dispositivo.DispositivoResponseDTO;
import com.pm.evolucaoenfermagem.service.DispositivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes/dispositivos")
@Tag(name = "Dispositivos", description = "API para gerenciar dispositivos médicos instalados em pacientes")
public class DispositivoController {

    private final DispositivoService dispositivoService;

    public DispositivoController(DispositivoService dispositivoService) {
        this.dispositivoService = dispositivoService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os dispositivos")
    public ResponseEntity<List<DispositivoResponseDTO>> buscarTodos() {
        return ResponseEntity.ok(dispositivoService.buscarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar dispositivo por ID")
    public ResponseEntity<DispositivoResponseDTO> getPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(dispositivoService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar novo dispositivo")
    public ResponseEntity<DispositivoResponseDTO> criar(@RequestBody DispositivoRequestDTO dto) {
        return ResponseEntity.ok(dispositivoService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar dispositivo existente")
    public ResponseEntity<DispositivoResponseDTO> atualizar(
            @PathVariable UUID id,
            @RequestBody DispositivoRequestDTO dto) {
        return ResponseEntity.ok(dispositivoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar dispositivo existente")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        dispositivoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
