package com.pm.evolucaoenfermagem.service;

import com.pm.evolucaoenfermagem.dto.cefalocaudal.CefalocaudalResponseDTO;
import com.pm.evolucaoenfermagem.dto.evolucaoEnfermagem.EvolucaoEnfermagemRequestDTO;
import com.pm.evolucaoenfermagem.dto.evolucaoEnfermagem.EvolucaoEnfermagemResponseDTO;
import com.pm.evolucaoenfermagem.mapper.CefalocaudalMapper;
import com.pm.evolucaoenfermagem.mapper.EvolucaoEnfermagemMapper;
import com.pm.evolucaoenfermagem.model.Cefalocaudal;
import com.pm.evolucaoenfermagem.model.EvolucaoEnfermagem;
import com.pm.evolucaoenfermagem.model.Paciente;
import com.pm.evolucaoenfermagem.repository.EvolucaoEnfermagemRepository;
import com.pm.evolucaoenfermagem.repository.PacienteRepository;
import com.pm.evolucaoenfermagem.service.exceptions.EvolucaoEnfermagemNaoEncontradaException;
import com.pm.evolucaoenfermagem.service.exceptions.PacienteNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EvolucaoEnfermagemService {

    private final EvolucaoEnfermagemRepository evolucaoEnfermagemRepository;
    private final PacienteRepository pacienteRepository;

    public EvolucaoEnfermagemService(EvolucaoEnfermagemRepository repository,  PacienteRepository pacienteRepository) {
        this.evolucaoEnfermagemRepository = repository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<EvolucaoEnfermagemResponseDTO> buscarTodos() {
        List<EvolucaoEnfermagem> evolucoes = evolucaoEnfermagemRepository.findAll();
        return evolucoes.stream()
                .map(EvolucaoEnfermagemMapper::toDto)
                .toList();
    }

    public EvolucaoEnfermagemResponseDTO buscarPorId(UUID id){
        EvolucaoEnfermagem evolucaoEnfermagem = evolucaoEnfermagemRepository.findById(id)
                .orElseThrow(() -> new EvolucaoEnfermagemNaoEncontradaException("Evolução enfermagem não encontrada com o ID: " + id));
        return EvolucaoEnfermagemMapper.toDto(evolucaoEnfermagem);
    }

    public List<EvolucaoEnfermagemResponseDTO> buscarPorPacienteId(UUID pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new PacienteNaoEncontradoException(
                        "Paciente não encontrado com o ID: " + pacienteId));

        List<EvolucaoEnfermagem> evolucoes = evolucaoEnfermagemRepository.findByPacienteId(pacienteId);

        return evolucoes.stream()
                .map(EvolucaoEnfermagemMapper::toDto)
                .collect(Collectors.toList());
    }

    public EvolucaoEnfermagemResponseDTO criar(EvolucaoEnfermagemRequestDTO dto){
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + dto.getPacienteId()));

        EvolucaoEnfermagem evolucaoEnfermagem = EvolucaoEnfermagemMapper.toEntity(dto, paciente);

        EvolucaoEnfermagem salvo = evolucaoEnfermagemRepository.save(evolucaoEnfermagem);
        return EvolucaoEnfermagemMapper.toDto(salvo);
    }

    public EvolucaoEnfermagemResponseDTO atualizar(UUID id, EvolucaoEnfermagemRequestDTO dto){
        EvolucaoEnfermagem evolucaoEnfermagemExistente = evolucaoEnfermagemRepository.findById(id)
                .orElseThrow(() -> new EvolucaoEnfermagemNaoEncontradaException("Evolução enfermagem não encontrada com o ID: " + id));
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + dto.getPacienteId()));

        EvolucaoEnfermagemMapper.updateEntityFromDto(dto, evolucaoEnfermagemExistente, paciente);

        EvolucaoEnfermagem atualizado = evolucaoEnfermagemRepository.save(evolucaoEnfermagemExistente);
        return EvolucaoEnfermagemMapper.toDto(atualizado);
    }

    public void deletar(UUID id){
        EvolucaoEnfermagem evolucaoEnfermagem = evolucaoEnfermagemRepository.findById(id)
                .orElseThrow(() -> new EvolucaoEnfermagemNaoEncontradaException("Evolução enfermagem não encontrada com o ID: " + id));
        evolucaoEnfermagemRepository.delete(evolucaoEnfermagem);
    }
}
