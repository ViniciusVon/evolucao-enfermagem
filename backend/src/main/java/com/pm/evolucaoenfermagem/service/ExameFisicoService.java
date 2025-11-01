package com.pm.evolucaoenfermagem.service;

import com.pm.evolucaoenfermagem.dto.exameFisico.ExameFisicoRequestDTO;
import com.pm.evolucaoenfermagem.dto.exameFisico.ExameFisicoResponseDTO;
import com.pm.evolucaoenfermagem.mapper.ExameFisicoMapper;
import com.pm.evolucaoenfermagem.model.*;
import com.pm.evolucaoenfermagem.repository.*;
import com.pm.evolucaoenfermagem.service.exceptions.PacienteNaoEncontradoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ExameFisicoService {

    private final ExameFisicoRepository exameFisicoRepository;
    private final PacienteRepository pacienteRepository;
    private final EdemaRepository edemaRepository;

    public ExameFisicoService(ExameFisicoRepository exameFisicoRepository,
                              PacienteRepository pacienteRepository,
                              EdemaRepository edemaRepository) {
        this.exameFisicoRepository = exameFisicoRepository;
        this.pacienteRepository = pacienteRepository;
        this.edemaRepository = edemaRepository;
    }

    @Transactional
    public ExameFisicoResponseDTO create(ExameFisicoRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado"));

        ExameFisico exame = new ExameFisico();

        exameFisicoRepository.save(exame);

        return ExameFisicoMapper.toDto(exame);
    }

    @Transactional(readOnly = true)
    public ExameFisicoResponseDTO buscarPorId(UUID id) {
        ExameFisico exame = exameFisicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame físico não encontrado"));
        return ExameFisicoMapper.toDto(exame);
    }

    @Transactional(readOnly = true)
    public List<ExameFisicoResponseDTO> BuscarTodos() {
        return exameFisicoRepository.findAll()
                .stream()
                .map(ExameFisicoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ExameFisicoResponseDTO update(UUID id, ExameFisicoRequestDTO dto) {
        ExameFisico exame = exameFisicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame físico não encontrado"));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Edema edema = null;
        if (dto.getEdemaId() != null) {
            edema = edemaRepository.findById(dto.getEdemaId())
                    .orElseThrow(() -> new RuntimeException("Edema não encontrado"));
        }

        ExameFisicoMapper.updateEntityFromDto(dto, exame, paciente, edema);

        exameFisicoRepository.save(exame);

        return ExameFisicoMapper.toDto(exame);
    }
    @Transactional
    public void delete(UUID id) {
        ExameFisico exame = exameFisicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exame físico não encontrado"));
        exameFisicoRepository.delete(exame);
    }
}
