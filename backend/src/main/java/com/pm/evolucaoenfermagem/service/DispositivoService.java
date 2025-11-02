package com.pm.evolucaoenfermagem.service;

import com.pm.evolucaoenfermagem.dto.dispositivo.DispositivoRequestDTO;
import com.pm.evolucaoenfermagem.dto.dispositivo.DispositivoResponseDTO;
import com.pm.evolucaoenfermagem.mapper.DispositivoMapper;
import com.pm.evolucaoenfermagem.model.*;
import com.pm.evolucaoenfermagem.repository.DispositivoRepository;
import com.pm.evolucaoenfermagem.repository.PacienteRepository;
import com.pm.evolucaoenfermagem.service.exceptions.DispositivoNaoEncontradoException;
import com.pm.evolucaoenfermagem.service.exceptions.PacienteNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DispositivoService {

    private final DispositivoRepository dispositivoRepository;
    private final PacienteRepository pacienteRepository;

    public DispositivoService(DispositivoRepository dispositivoRepository, PacienteRepository pacienteRepository) {
        this.dispositivoRepository = dispositivoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<DispositivoResponseDTO> buscarTodos() {
        return dispositivoRepository.findAll()
                .stream()
                .map(DispositivoMapper::toDto)
                .toList();
    }

    public DispositivoResponseDTO buscarPorId(UUID id) {
        Dispositivo dispositivo = dispositivoRepository.findById(id)
                .orElseThrow(() -> new DispositivoNaoEncontradoException("Dispositivo não encontrado com o ID: " + id));
        return DispositivoMapper.toDto(dispositivo);
    }

    public List<DispositivoResponseDTO> buscarPorPacienteId(UUID pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new PacienteNaoEncontradoException(
                        "Paciente não encontrado com o ID: " + pacienteId));

        List<Dispositivo> dispositivos = dispositivoRepository.findByPacienteId(pacienteId);

        return dispositivos.stream()
                .map(DispositivoMapper::toDto)
                .collect(Collectors.toList());
    }

    public DispositivoResponseDTO criar(DispositivoRequestDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new PacienteNaoEncontradoException(
                        "Paciente não encontrado com o ID: " + dto.getPacienteId()));

        Dispositivo dispositivo = DispositivoMapper.toEntity(dto, paciente);
        Dispositivo salvo = dispositivoRepository.save(dispositivo);
        return DispositivoMapper.toDto(salvo);
    }

    public DispositivoResponseDTO atualizar(UUID id, DispositivoRequestDTO dto) {
        Dispositivo dispositivoExistente = dispositivoRepository.findById(id)
                .orElseThrow(() -> new DispositivoNaoEncontradoException("Dispositivo não encontrado com o ID: " + id));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new PacienteNaoEncontradoException(
                        "Paciente não encontrado com o ID: " + dto.getPacienteId()));

        DispositivoMapper.updateEntityFromDto(dto, dispositivoExistente, paciente);

        Dispositivo atualizado = dispositivoRepository.save(dispositivoExistente);
        return DispositivoMapper.toDto(atualizado);
    }

    public void deletar(UUID id) {
        Dispositivo dispositivo = dispositivoRepository.findById(id)
                .orElseThrow(() -> new DispositivoNaoEncontradoException("Dispositivo não encontrado com o ID: " + id));
        dispositivoRepository.delete(dispositivo);
    }
}

