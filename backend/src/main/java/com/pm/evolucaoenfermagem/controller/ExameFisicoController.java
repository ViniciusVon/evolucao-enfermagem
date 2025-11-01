package com.pm.evolucaoenfermagem.controller;

import com.pm.evolucaoenfermagem.dto.exameFisico.ExameFisicoRequestDTO;
import com.pm.evolucaoenfermagem.dto.exameFisico.ExameFisicoResponseDTO;
import com.pm.evolucaoenfermagem.service.ExameFisicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("pacientes/exame-fisico")
public class ExameFisicoController {

    private final ExameFisicoService exameFisicoService;

    public ExameFisicoController(ExameFisicoService exameFisicoService) {
        this.exameFisicoService = exameFisicoService;
    }

    @PostMapping
    public ResponseEntity<ExameFisicoResponseDTO> create(@RequestBody ExameFisicoRequestDTO dto) {
        ExameFisicoResponseDTO response = exameFisicoService.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExameFisicoResponseDTO> getById(@PathVariable UUID id) {
        ExameFisicoResponseDTO response = exameFisicoService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ExameFisicoResponseDTO>> getAll() {
        List<ExameFisicoResponseDTO> response = exameFisicoService.getAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExameFisicoResponseDTO> update(@PathVariable UUID id,
                                                         @RequestBody ExameFisicoRequestDTO dto) {
        ExameFisicoResponseDTO response = exameFisicoService.update(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        exameFisicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
