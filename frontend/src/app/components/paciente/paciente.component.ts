import { Component } from '@angular/core';
import { PacienteListComponent } from '../paciente-list/paciente-list.component';
import { PacienteDispositivosComponent } from '../paciente-dispositivos/paciente-dispositivos.component';
import { PacienteHppComponent } from "../paciente-hpp/paciente-hpp.component";
import { PacienteEvolucaoEnfermagemComponent } from "../paciente-evolucao-enfermagem/paciente-evolucao-enfermagem.component";
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-paciente',
    templateUrl: './paciente.component.html',
    styleUrls: ['./paciente.component.scss'],
    standalone: true,
    imports: [PacienteListComponent, PacienteDispositivosComponent, CommonModule, PacienteHppComponent, PacienteEvolucaoEnfermagemComponent],
})
export class PacientesComponent {
    pacienteSelecionadoId: string | null = null;

    constructor() { }

    onPacienteSelecionado(id: string) {
        this.pacienteSelecionadoId = id;
    }
}