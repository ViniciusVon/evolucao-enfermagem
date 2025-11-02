package com.pm.evolucaoenfermagem.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "exame_fisico")
public class ExameFisico extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Date data_exame;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @OneToOne(mappedBy = "exameFisico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameFisicoAbd exameFisicoAbd;

    @OneToOne(mappedBy = "exameFisico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameFisicoAcv exameFisicoAcv;

    @OneToOne(mappedBy = "exameFisico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameFisicoAr exameFisicoAr;

    @OneToOne(mappedBy = "exameFisico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameFisicoExt exameFisicoExt;

    @OneToOne(mappedBy = "exameFisico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameFisicoNeuro exameFisicoNeuro;

    @OneToOne(mappedBy = "exameFisico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameFisicoSsvv exameFisicoSsvv;

    @OneToOne(mappedBy = "exameFisico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ExameFisicoTergumentar exameFisicoTergumentar;

    // 🔹 Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getData_exame() {
        return data_exame;
    }

    public void setData_exame(Date data_exame) {
        this.data_exame = data_exame;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ExameFisicoAbd getExameFisicoAbd() {
        return exameFisicoAbd;
    }

    public void setExameFisicoAbd(ExameFisicoAbd exameFisicoAbd) {
        this.exameFisicoAbd = exameFisicoAbd;
    }

    public ExameFisicoAcv getExameFisicoAcv() {
        return exameFisicoAcv;
    }

    public void setExameFisicoAcv(ExameFisicoAcv exameFisicoAcv) {
        this.exameFisicoAcv = exameFisicoAcv;
    }

    public ExameFisicoAr getExameFisicoAr() {
        return exameFisicoAr;
    }

    public void setExameFisicoAr(ExameFisicoAr exameFisicoAr) {
        this.exameFisicoAr = exameFisicoAr;
    }

    public ExameFisicoExt getExameFisicoExt() {
        return exameFisicoExt;
    }

    public void setExameFisicoExt(ExameFisicoExt exameFisicoExt) {
        this.exameFisicoExt = exameFisicoExt;
    }

    public ExameFisicoNeuro getExameFisicoNeuro() {
        return exameFisicoNeuro;
    }

    public void setExameFisicoNeuro(ExameFisicoNeuro exameFisicoNeuro) {
        this.exameFisicoNeuro = exameFisicoNeuro;
    }

    public ExameFisicoSsvv getExameFisicoSsvv() {
        return exameFisicoSsvv;
    }

    public void setExameFisicoSsvv(ExameFisicoSsvv exameFisicoSsvv) {
        this.exameFisicoSsvv = exameFisicoSsvv;
    }

    public ExameFisicoTergumentar getExameFisicoTergumentar() {
        return exameFisicoTergumentar;
    }

    public void setExameFisicoTergumentar(ExameFisicoTergumentar exameFisicoTergumentar) {
        this.exameFisicoTergumentar = exameFisicoTergumentar;
    }
}
