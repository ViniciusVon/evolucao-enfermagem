package com.pm.evolucaoenfermagem.service;

import com.pm.evolucaoenfermagem.dto.cefalocaudal.CefalocaudalRequestDTO;
import com.pm.evolucaoenfermagem.dto.cefalocaudal.CefalocaudalResponseDTO;
import com.pm.evolucaoenfermagem.dto.dispositivo.DispositivoResponseDTO;
import com.pm.evolucaoenfermagem.mapper.CefalocaudalMapper;
import com.pm.evolucaoenfermagem.mapper.DispositivoMapper;
import com.pm.evolucaoenfermagem.model.Cefalocaudal;
import com.pm.evolucaoenfermagem.model.Dispositivo;
import com.pm.evolucaoenfermagem.model.Paciente;
import com.pm.evolucaoenfermagem.repository.CefalocaudalRepository;
import com.pm.evolucaoenfermagem.repository.PacienteRepository;
import com.pm.evolucaoenfermagem.service.exceptions.CefalocaudalNaoEncontradoException;
import com.pm.evolucaoenfermagem.service.exceptions.PacienteNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CefalocaudalService {
    private CefalocaudalRepository cefalocaudalRepository;
    private PacienteRepository pacienteRepository;

    public CefalocaudalService(CefalocaudalRepository cefalocaudalRepository, PacienteRepository pacienteRepository) {
        this.cefalocaudalRepository = cefalocaudalRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<CefalocaudalResponseDTO> buscarTodos() {
        List<Cefalocaudal> cefalocaudais = cefalocaudalRepository.findAll();
        return cefalocaudais.stream()
                .map(CefalocaudalMapper::toDto)
                .toList();
    }

    public CefalocaudalResponseDTO buscarPorId(UUID id) {
        Cefalocaudal cefalocaudal = cefalocaudalRepository.findById(id)
                .orElseThrow(() -> new CefalocaudalNaoEncontradoException("Cefalocaudal não encontrando com o ID: " + id));
        return CefalocaudalMapper.toDto(cefalocaudal);
    }

    public List<CefalocaudalResponseDTO> buscarPorPacienteId(UUID pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new PacienteNaoEncontradoException(
                        "Paciente não encontrado com o ID: " + pacienteId));

        List<Cefalocaudal> cefalocaudais = cefalocaudalRepository.findByPacienteId(pacienteId);

        return cefalocaudais.stream()
                .map(CefalocaudalMapper::toDto)
                .collect(Collectors.toList());
    }

    public CefalocaudalResponseDTO criar(CefalocaudalRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + dto.getPacienteId()));

        Cefalocaudal cefalocaudal = CefalocaudalMapper.toEntity(dto, paciente);

        Cefalocaudal salvo = cefalocaudalRepository.save(cefalocaudal);
        return CefalocaudalMapper.toDto(salvo);
    }

    public CefalocaudalResponseDTO atualizar(UUID id, CefalocaudalRequestDTO dto) {
        Cefalocaudal cefalocaudalExistente = cefalocaudalRepository.findById(id)
                .orElseThrow(() -> new CefalocaudalNaoEncontradoException("Cefalocaudal não encontrado com o ID: " + id));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new PacienteNaoEncontradoException(
                        "Paciente não encontrado com o ID: " + dto.getPacienteId()));

        CefalocaudalMapper.updateEntityFromDto(dto, cefalocaudalExistente, paciente);

        Cefalocaudal atualizado = cefalocaudalRepository.save(cefalocaudalExistente);
        return CefalocaudalMapper.toDto(atualizado);
    }

    public void deletar(UUID id) {
        Cefalocaudal cefalocaudal = cefalocaudalRepository.findById(id)
                .orElseThrow(() -> new CefalocaudalNaoEncontradoException("Cefalocaudal não encontrado com o ID: " + id));
        cefalocaudalRepository.delete(cefalocaudal);
    }
}
