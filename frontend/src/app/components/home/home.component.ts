import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { PacienteService } from '../../services/paciente';
import { Paciente } from '../../models/paciente.model';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  nomeEstudante = 'Estudante';
  saudacao = '';

  totalPacientes = 0;
  totalCriticos = 0;
  totalEstavel = 0;

  carregando = true;

  constructor(private pacienteService: PacienteService) {}

  ngOnInit(): void {
    this.definirSaudacao();
    this.loadEstatisticas();
  }

  definirSaudacao(): void {
    const hora = new Date().getHours();
    if (hora < 12) this.saudacao = 'Bom dia';
    else if (hora < 18) this.saudacao = 'Boa tarde';
    else this.saudacao = 'Boa noite';
  }

  loadEstatisticas(): void {
    this.carregando = true;
    this.pacienteService.getPacientes().subscribe({
      next: (pacientes: Paciente[]) => {
        this.totalPacientes = pacientes.length;
        this.totalCriticos  = pacientes.filter(p => p.status === 'in_treatment').length;
        this.totalEstavel   = pacientes.filter(p => p.status === 'recovery').length;
        this.carregando = false;
      },
      error: () => this.carregando = false
    });
  }
}