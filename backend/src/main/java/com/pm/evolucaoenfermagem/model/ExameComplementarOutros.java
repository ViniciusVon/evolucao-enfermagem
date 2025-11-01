package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.UUID;

@Entity
@Table(name = "exame_complementar_outros")
public class ExameComplementarOutros extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Size(min = 1, max = 100)
    private String nome_exame;

    @Size(min = 1, max = 50)
    private String valor;

    @Size(min = 1, max = 20)
    private String unidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exame_complementar_outros_id", nullable = false)
    private ExameComplementar exameComplementar;
}
