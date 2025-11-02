package com.pm.evolucaoenfermagem.service;

import com.pm.evolucaoenfermagem.dto.exameComplementar.ExameComplementarRequestDTO;
import com.pm.evolucaoenfermagem.dto.exameComplementar.ExameComplementarResponseDTO;
import com.pm.evolucaoenfermagem.mapper.ExameComplementarMapper;
import com.pm.evolucaoenfermagem.model.ExameComplementar;
import com.pm.evolucaoenfermagem.model.Paciente;
import com.pm.evolucaoenfermagem.repository.ExameComplementarRepository;
import com.pm.evolucaoenfermagem.repository.PacienteRepository;
import com.pm.evolucaoenfermagem.service.exceptions.ExameComplementarNaoEncontradoException;
import com.pm.evolucaoenfermagem.service.exceptions.PacienteNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ExameComplementarService {

    public final ExameComplementarRepository exameComplementarRepository;
    private PacienteRepository pacienteRepository;

    public ExameComplementarService(ExameComplementarRepository exameComplementarRepository,  PacienteRepository pacienteRepository) {
        this.exameComplementarRepository = exameComplementarRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<ExameComplementarResponseDTO> buscarTodos() {
        List<ExameComplementar> exames = exameComplementarRepository.findAll();
        return exames.stream()
                .map(ExameComplementarMapper::toDto)
                .toList();
    }

    public ExameComplementarResponseDTO buscarPorId(UUID id) {
        ExameComplementar exameComplementar = exameComplementarRepository.findById(id)
                .orElseThrow(() -> new ExameComplementarNaoEncontradoException("Exame complementar não encontrado com o ID: " + id));
        return ExameComplementarMapper.toDto(exameComplementar);
    }

    public ExameComplementarResponseDTO criar(ExameComplementarRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + dto.getPacienteId()));

        ExameComplementar exameComplementar = ExameComplementarMapper.toEntity(dto, paciente);

        ExameComplementar salvo = exameComplementarRepository.save(exameComplementar);
        return ExameComplementarMapper.toDto(salvo);
    }

    public ExameComplementarResponseDTO atualizar(UUID id, ExameComplementarRequestDTO dto) {
        ExameComplementar exameComplementarExistente = exameComplementarRepository.findById(id)
                .orElseThrow(() -> new ExameComplementarNaoEncontradoException("Exame complementar não encontrado com o ID: " + id));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + dto.getPacienteId()));

        ExameComplementarMapper.updateEntityFromDto(dto, exameComplementarExistente, paciente);

        ExameComplementar atualizado =  exameComplementarRepository.save(exameComplementarExistente);
        return ExameComplementarMapper.toDto(atualizado);
    }

    public void deletar(UUID id) {
        ExameComplementar exameComplementarExistente = exameComplementarRepository.findById(id)
                .orElseThrow(() -> new ExameComplementarNaoEncontradoException("Exame complementar não encontrado com o ID: " + id));
        exameComplementarRepository.delete(exameComplementarExistente);
    }
}
