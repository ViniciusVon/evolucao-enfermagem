package com.pm.evolucaoenfermagem.service;

import com.pm.evolucaoenfermagem.dto.paciente.PacienteRequestDTO;
import com.pm.evolucaoenfermagem.dto.paciente.PacienteResponseDTO;
import com.pm.evolucaoenfermagem.service.exceptions.PacienteNaoEncontradoException;
import com.pm.evolucaoenfermagem.mapper.PacienteMapper;
import com.pm.evolucaoenfermagem.model.Paciente;
import com.pm.evolucaoenfermagem.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<PacienteResponseDTO> buscarTodos(){
        List<Paciente> pacientes = pacienteRepository.findAll();

        return pacientes.stream()
                .map(PacienteMapper::toDto)
                .toList();
    }

    public PacienteResponseDTO buscarPorId(UUID id){
        Paciente pacienteEncontrado = pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + id)
        );

        return PacienteMapper.toDto(pacienteEncontrado);
    }

    public PacienteResponseDTO criar(PacienteRequestDTO dto){
        Paciente paciente = PacienteMapper.toEntity(dto);
        Paciente salvo = pacienteRepository.save(paciente);

        return PacienteMapper.toDto(salvo);
    }

    public PacienteResponseDTO atualizar(UUID id, PacienteRequestDTO dto){
        Paciente pacienteExistente = pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteNaoEncontradoException(
                        "Paciente não encontrado com o ID: " + id)
        );

        PacienteMapper.updateEntityFromDto(dto, pacienteExistente);

        Paciente pacienteAtualizado = pacienteRepository.save(pacienteExistente);
        return PacienteMapper.toDto(pacienteAtualizado);
    }

    public void deletar(UUID id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + id));

        pacienteRepository.delete(paciente);
    }
}
