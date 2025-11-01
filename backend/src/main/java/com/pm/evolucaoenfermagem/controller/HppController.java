package com.pm.evolucaoenfermagem.controller;

import com.pm.evolucaoenfermagem.dto.hpp.HppRequestDTO;
import com.pm.evolucaoenfermagem.dto.hpp.HppResponseDTO;
import com.pm.evolucaoenfermagem.service.HppService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pacientes/hpp")
@Tag(name = "HPP", description = "API para gerenciar o História de Patológica Pregressa (HPP)")
public class HppController {

    private final HppService hppService;

    public HppController(HppService hppService) {
        this.hppService = hppService;
    }

    @GetMapping
    @Operation(summary = "Listar todos os HPPs")
    public ResponseEntity<List<HppResponseDTO>> getTodos() {
        List<HppResponseDTO> lista = hppService.buscarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um HPP pelo ID")
    public ResponseEntity<HppResponseDTO> getPorId(@PathVariable UUID id) {
        HppResponseDTO hpp = hppService.buscarPorId(id);
        return ResponseEntity.ok(hpp);
    }

    @PostMapping
    @Operation(summary = "Criar um novo HPP")
    public ResponseEntity<HppResponseDTO> criar(@RequestBody HppRequestDTO dto) {
        HppResponseDTO criado = hppService.criar(dto);
        return ResponseEntity.ok(criado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar um HPP existente")
    public ResponseEntity<HppResponseDTO> atualizar(
            @PathVariable UUID id,
            @RequestBody HppRequestDTO dto) {
        HppResponseDTO atualizado = hppService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um HPP existente")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        hppService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
