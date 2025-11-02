package com.pm.evolucaoenfermagem.service;

import com.pm.evolucaoenfermagem.dto.respiracao.RespiracaoRequestDTO;
import com.pm.evolucaoenfermagem.dto.respiracao.RespiracaoResponseDTO;
import com.pm.evolucaoenfermagem.mapper.RespiracaoMapper;
import com.pm.evolucaoenfermagem.model.EvolucaoEnfermagem;
import com.pm.evolucaoenfermagem.model.Paciente;
import com.pm.evolucaoenfermagem.model.Respiracao;
import com.pm.evolucaoenfermagem.repository.EvolucaoEnfermagemRepository;
import com.pm.evolucaoenfermagem.repository.RespiracaoRepository;
import com.pm.evolucaoenfermagem.service.exceptions.PacienteNaoEncontradoException;
import com.pm.evolucaoenfermagem.service.exceptions.RespiracaoNaoEncontradaException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RespiracaoService {
    private final RespiracaoRepository respiracaoRepository;
    private final EvolucaoEnfermagemRepository evolucaoEnfermagemRepository;

    public RespiracaoService(RespiracaoRepository respiracaoRepository, EvolucaoEnfermagemRepository evolucaoEnfermagemRepository) {
        this.respiracaoRepository = respiracaoRepository;
        this.evolucaoEnfermagemRepository = evolucaoEnfermagemRepository;
    }

    public List<RespiracaoResponseDTO> buscarTodas() {
        List<Respiracao> respiracoes = respiracaoRepository.findAll();
        return respiracoes.stream()
                .map(RespiracaoMapper::toDto)
                .toList();
    }

    public RespiracaoResponseDTO buscarPorId(UUID id) {
        Respiracao respiracao = respiracaoRepository.findById(id)
                .orElseThrow(() -> new RespiracaoNaoEncontradaException("Respiracao não encontrada com o ID: " + id));
        return RespiracaoMapper.toDto(respiracao);
    }

    public RespiracaoResponseDTO criar(RespiracaoRequestDTO dto) {
        EvolucaoEnfermagem evolucaoEnfermagem = evolucaoEnfermagemRepository.findById(dto.getEvolucaoEnfermagemId())
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado com o ID: " + dto.getEvolucaoEnfermagemId()));
        Respiracao respiracao = RespiracaoMapper.toEntity(dto, evolucaoEnfermagem);

        Respiracao salva = respiracaoRepository.save(respiracao);
        return RespiracaoMapper.toDto(salva);
    }

    public RespiracaoResponseDTO atualizar(UUID id, RespiracaoRequestDTO dto) {
        Respiracao respiracaoExistente = respiracaoRepository.findById(id)
                .orElseThrow(() -> new RespiracaoNaoEncontradaException("Respiracao não encontrada com o ID: " + id));

        RespiracaoMapper.updateEntityFromDto(dto, respiracaoExistente);

        Respiracao atualizado = respiracaoRepository.save(respiracaoExistente);
        return RespiracaoMapper.toDto(atualizado);
    }

    public void deletar(UUID id) {
        Respiracao respiracaoExistente = respiracaoRepository.findById(id)
                .orElseThrow(() -> new RespiracaoNaoEncontradaException("Respiracao não encontrada com o ID: " + id));
        respiracaoRepository.delete(respiracaoExistente);
    }
}
