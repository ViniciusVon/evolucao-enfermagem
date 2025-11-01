package com.pm.evolucaoenfermagem.service.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(PacienteNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handlePacienteNaoEncontradoException(PacienteNaoEncontradoException ex) {

        log.warn("Paciente não encontrado {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Paciente não encontrado");

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(HppNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleHppNaoEncontradoException(HppNaoEncontradoException ex) {

        log.warn("Hpp não encontrado {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DispositivoNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleDispositivoNaoEncontradoException(DispositivoNaoEncontradoException ex) {

        log.warn("Dispositivo não encontrado {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EdemaNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleEdemaNaoEncontradoException(EdemaNaoEncontradoException ex) {

        log.warn("Edema não encontrado {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(CefalocaudalNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleCefalocaudalNaoEncontrado(CefalocaudalNaoEncontradoException ex) {

        log.warn("Cefalocaudal não encontrado {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage());

        return ResponseEntity.badRequest().body(errors);
    }
}
