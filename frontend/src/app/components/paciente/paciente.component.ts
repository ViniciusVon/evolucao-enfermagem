import { Component } from '@angular/core';
import { PacienteListComponent } from '../paciente-list/paciente-list.component';
import { CommonModule } from '@angular/common';
import { PacienteTabsComponent } from '../paciente-tabs/paciente-tabs.component';
import { PacienteResumoComponent } from '../paciente-resumo/paciente-resumo.component';

@Component({
    selector: 'app-paciente',
    templateUrl: './paciente.component.html',
    styleUrls: ['./paciente.component.scss'],
    standalone: true,
    imports: [
        PacienteListComponent,
        PacienteTabsComponent,
        PacienteResumoComponent,
        CommonModule,
    ],
})
export class PacientesComponent {
    pacienteSelecionadoId: string | null = null;

    constructor() { }

    onPacienteSelecionado(id: string) {
        this.pacienteSelecionadoId = id;
    }
}