package com.pm.evolucaoenfermagem.service;

import com.pm.evolucaoenfermagem.dto.hpp.HppRequestDTO;
import com.pm.evolucaoenfermagem.dto.hpp.HppResponseDTO;
import com.pm.evolucaoenfermagem.mapper.HppMapper;
import com.pm.evolucaoenfermagem.model.Hpp;
import com.pm.evolucaoenfermagem.model.Paciente;
import com.pm.evolucaoenfermagem.repository.HppRepository;
import com.pm.evolucaoenfermagem.repository.PacienteRepository;
import com.pm.evolucaoenfermagem.service.exceptions.HppNaoEncontradoException;
import com.pm.evolucaoenfermagem.service.exceptions.PacienteNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HppService {

    private final HppRepository hppRepository;
    private final PacienteRepository pacienteRepository;

    public HppService(HppRepository hppRepository, PacienteRepository pacienteRepository) {
        this.hppRepository = hppRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<HppResponseDTO> buscarTodos() {
        List<Hpp> hpps = hppRepository.findAll();
        return hpps.stream()
                .map(HppMapper::toDto)
                .toList();
    }

    public HppResponseDTO buscarPorId(UUID id) {
        Hpp hpp = hppRepository.findById(id)
                .orElseThrow(() -> new HppNaoEncontradoException("HPP não encontrado com o ID: " + id));
        return HppMapper.toDto(hpp);
    }

    public HppResponseDTO criar(HppRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Hpp hpp = HppMapper.toEntity(dto, paciente);
        hpp.setPaciente(paciente);
        Hpp salvo = hppRepository.save(hpp);
        return HppMapper.toDto(salvo);
    }

    public HppResponseDTO atualizar(UUID id, HppRequestDTO dto) {
        Hpp hppExistente = hppRepository.findById(id)
                .orElseThrow(() -> new HppNaoEncontradoException("HPP não encontrado com o ID: " + id));

        Paciente pacienteExistente = pacienteRepository.findById(hppExistente.getPaciente().getId())
                        .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + hppExistente.getPaciente().getId()));

        HppMapper.updateEntityFromDto(dto, hppExistente, pacienteExistente);
        Hpp atualizado = hppRepository.save(hppExistente);
        return HppMapper.toDto(atualizado);
    }

    public void deletar(UUID id) {
        Hpp hpp = hppRepository.findById(id)
                .orElseThrow(() -> new HppNaoEncontradoException("HPP não encontrado com o ID: " + id));
        hppRepository.delete(hpp);
    }
}
