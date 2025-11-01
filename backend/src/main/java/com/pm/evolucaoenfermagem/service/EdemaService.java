package com.pm.evolucaoenfermagem.service;

import com.pm.evolucaoenfermagem.dto.edema.EdemaRequestDTO;
import com.pm.evolucaoenfermagem.dto.edema.EdemaResponseDTO;
import com.pm.evolucaoenfermagem.mapper.EdemaMapper;
import com.pm.evolucaoenfermagem.model.Cefalocaudal;
import com.pm.evolucaoenfermagem.model.Edema;
import com.pm.evolucaoenfermagem.repository.CefalocaudalRepository;
import com.pm.evolucaoenfermagem.repository.EdemaRepository;
import com.pm.evolucaoenfermagem.service.exceptions.CefalocaudalNaoEncontradoException;
import com.pm.evolucaoenfermagem.service.exceptions.EdemaNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EdemaService {

    private final EdemaRepository edemaRepository;
    private final CefalocaudalRepository cefalocaudalRepository;

    public EdemaService(EdemaRepository edemaRepository, CefalocaudalRepository cefalocaudalRepository) {
        this.edemaRepository = edemaRepository;
        this.cefalocaudalRepository = cefalocaudalRepository;
    }

    public List<EdemaResponseDTO> buscarTodos() {
        return edemaRepository.findAll()
                .stream()
                .map(EdemaMapper::toDto)
                .toList();
    }

    public EdemaResponseDTO buscarPorId(UUID id) {
        Edema edema = edemaRepository.findById(id)
                .orElseThrow(() -> new EdemaNaoEncontradoException("Edema não encontrado com o ID: " + id));
        return EdemaMapper.toDto(edema);
    }

    public EdemaResponseDTO criar(EdemaRequestDTO dto) {
        Cefalocaudal cefalocaudal = null;
        if (dto.getCefalocaudalId() != null) {
            cefalocaudal = cefalocaudalRepository.findById(dto.getCefalocaudalId())
                    .orElseThrow(() -> new CefalocaudalNaoEncontradoException(
                            "Cefalocaudal não encontrado com o ID: " + dto.getCefalocaudalId()));
        }

        Edema edema = EdemaMapper.toEntity(dto, cefalocaudal);
        Edema salvo = edemaRepository.save(edema);
        return EdemaMapper.toDto(salvo);
    }

    public EdemaResponseDTO atualizar(UUID id, EdemaRequestDTO dto) {
        Edema edemaExistente = edemaRepository.findById(id)
                .orElseThrow(() -> new EdemaNaoEncontradoException("Edema não encontrado com o ID: " + id));

        Cefalocaudal cefalocaudal = null;
        if (dto.getCefalocaudalId() != null) {
            cefalocaudal = cefalocaudalRepository.findById(dto.getCefalocaudalId())
                    .orElseThrow(() -> new CefalocaudalNaoEncontradoException(
                            "Cefalocaudal não encontrado com o ID: " + dto.getCefalocaudalId()));
        }

        EdemaMapper.updateEntityFromDto(dto, edemaExistente, cefalocaudal);
        Edema atualizado = edemaRepository.save(edemaExistente);
        return EdemaMapper.toDto(atualizado);
    }

    public void deletar(UUID id) {
        Edema edema = edemaRepository.findById(id)
                .orElseThrow(() -> new EdemaNaoEncontradoException("Edema não encontrado com o ID: " + id));
        edemaRepository.delete(edema);
    }
}
