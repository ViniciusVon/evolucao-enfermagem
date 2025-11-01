package com.pm.evolucaoenfermagem.mapper;

import com.pm.evolucaoenfermagem.dto.dispositivo.DispositivoRequestDTO;
import com.pm.evolucaoenfermagem.dto.dispositivo.DispositivoResponseDTO;
import com.pm.evolucaoenfermagem.enums.TipoDispositivoEnum;
import com.pm.evolucaoenfermagem.model.*;
import java.time.LocalDateTime;

public class DispositivoMapper {

    public static DispositivoResponseDTO toDto(Dispositivo dispositivo) {
        DispositivoResponseDTO dto = new DispositivoResponseDTO();

        dto.setId(dispositivo.getId());
        dto.setTipoDispositivoEnum(dispositivo.getDispositivoTipo());
        dto.setIsUtilizado(dispositivo.getUtilizado());
        dto.setDataInstalacao(dispositivo.getDataInstalacao());

        if (dispositivo.getPaciente() != null) {
            dto.setPacienteId(dispositivo.getPaciente().getId());
            dto.setPacienteNome(dispositivo.getPaciente().getNome());
        }

        return dto;
    }

    public static Dispositivo toEntity(DispositivoRequestDTO dto, Paciente paciente) {
        Dispositivo dispositivo;

        // cria o subtipo certo de acordo com o enum
        switch (dto.getTipoDispositivoEnum()) {
            case TOT -> {
                DispositivoTot tot = new DispositivoTot();
                tot.setCalibre(dto.getCalibre());
                dispositivo = tot;
            }
            case VM -> {
                DispositivoVm vm = new DispositivoVm();
                vm.setModo(dto.getModo());
                vm.setVc(dto.getVc());
                vm.setPeep(dto.getPeep());
                vm.setFr(dto.getFr());
                vm.setFiO2(dto.getFiO2());
                dispositivo = vm;
            }
            case SNE -> {
                DispositivoSne sne = new DispositivoSne();
                sne.setAbertaDrenagem(dto.getIsAbertaDrenagem());
                sne.setEmUso(dto.getIsEmUso());
                dispositivo = sne;
            }
            case CVC -> {
                DispositivoCvc cvc = new DispositivoCvc();
                cvc.setLocal(dto.getLocal());
                dispositivo = cvc;
            }
            case PAI -> {
                DispositivoPai pai = new DispositivoPai();
                pai.setLocal(dto.getLocal());
                dispositivo = pai;
            }
            case ACESSO_VENOSO -> {
                DispositivoAcessoVenoso av = new DispositivoAcessoVenoso();
                av.setLocal(dto.getLocal());
                av.setCurativo(dto.getCurativo());
                dispositivo = av;
            }
            default -> throw new IllegalArgumentException("Tipo de dispositivo inválido");
        }

        // campos comuns
        dispositivo.setDispositivoTipo(dto.getTipoDispositivoEnum());
        dispositivo.setUtilizado(dto.getIsUtilizado());
        dispositivo.setDataInstalacao(dto.getDataInstalacao());
        dispositivo.setPaciente(paciente);
        dispositivo.setCreatedAt(LocalDateTime.now());
        dispositivo.setUpdatedAt(null);
        dispositivo.setDeletedAt(null);

        return dispositivo;
    }

    public static void updateEntityFromDto(DispositivoRequestDTO dto, Dispositivo dispositivo, Paciente paciente) {
        dispositivo.setDispositivoTipo(dto.getTipoDispositivoEnum());
        dispositivo.setUtilizado(dto.getIsUtilizado());
        dispositivo.setDataInstalacao(dto.getDataInstalacao());
        dispositivo.setPaciente(paciente);

        // campos específicos
        if (dispositivo instanceof DispositivoTot tot) {
            tot.setCalibre(dto.getCalibre());
        } else if (dispositivo instanceof DispositivoVm vm) {
            vm.setModo(dto.getModo());
            vm.setVc(dto.getVc());
            vm.setPeep(dto.getPeep());
            vm.setFr(dto.getFr());
            vm.setFiO2(dto.getFiO2());
        } else if (dispositivo instanceof DispositivoSne sne) {
            sne.setAbertaDrenagem(dto.getIsAbertaDrenagem());
            sne.setEmUso(dto.getIsEmUso());
        } else if (dispositivo instanceof DispositivoCvc cvc) {
            cvc.setLocal(dto.getLocal());
        } else if (dispositivo instanceof DispositivoPai pai) {
            pai.setLocal(dto.getLocal());
        } else if (dispositivo instanceof DispositivoAcessoVenoso av) {
            av.setLocal(dto.getLocal());
            av.setCurativo(dto.getCurativo());
        }
    }
}
