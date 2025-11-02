package com.pm.evolucaoenfermagem.controller;

import com.pm.evolucaoenfermagem.dto.respiracao.RespiracaoRequestDTO;
import com.pm.evolucaoenfermagem.dto.respiracao.RespiracaoResponseDTO;
import com.pm.evolucaoenfermagem.model.Respiracao;
import com.pm.evolucaoenfermagem.service.RespiracaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pacientes/respiracao")
@Tag(name = "Respiração", description = "API para gerenciamento de respirações")
public class RespiracaoController {
    private final RespiracaoService respiracaoService;

    public RespiracaoController(RespiracaoService respiracaoService) {
        this.respiracaoService = respiracaoService;
    }

    @GetMapping
    @Operation(summary = "Listar todas as respirações")
    public ResponseEntity<List<RespiracaoResponseDTO>> buscarTodas() {
        return ResponseEntity.ok(respiracaoService.buscarTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar respiração por Id")
    public ResponseEntity<RespiracaoResponseDTO> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.ok(respiracaoService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Criar nova respiração")
    public ResponseEntity<RespiracaoResponseDTO> criar(
            @RequestBody RespiracaoRequestDTO dto) {
        return ResponseEntity.ok(respiracaoService.criar(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar respiração existente")
    public ResponseEntity<RespiracaoResponseDTO> atualizar(
            @PathVariable UUID id,
            @RequestBody RespiracaoRequestDTO dto) {
        return ResponseEntity.ok(respiracaoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar respiração existente")
    public ResponseEntity<RespiracaoResponseDTO> deletar(@PathVariable UUID id) {
        respiracaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
