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
import java.util.Optional;
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

        return pacientes.stream().map(PacienteMapper::toDto).toList();
    }

    public Optional<PacienteResponseDTO> buscarPorId(UUID id){
        Paciente pacienteEncontrado = pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + id)
        );

        return Optional.of(PacienteMapper.toDto(pacienteEncontrado));
    }

    public PacienteResponseDTO salvar(PacienteRequestDTO pacienteRequestDTO){

        Paciente novoPaciente = pacienteRepository.save(PacienteMapper.toEntity(pacienteRequestDTO));

        return PacienteMapper.toDto(novoPaciente);
    }

    public PacienteResponseDTO atualizar(UUID id, PacienteRequestDTO pacienteRequestDTO){

        Paciente paciente = pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + id)
        );

        paciente.setNome(pacienteRequestDTO.getNome());
        paciente.setSes(pacienteRequestDTO.getSes());
        paciente.setPeso(pacienteRequestDTO.getPeso());

        Paciente pacienteAtualizado = pacienteRepository.save(paciente);
        return PacienteMapper.toDto(pacienteAtualizado);
    }

    public void deletar(UUID id) {
        if (!pacienteRepository.existsById(id)) {
            throw new IllegalArgumentException("Paciente com id " + id + " não encontrado");
        }
        pacienteRepository.deleteById(id);
    }
}
