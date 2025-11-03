import { Component } from '@angular/core';
import { PacienteListComponent } from '../paciente-list/paciente-list.component';
import { CommonModule } from '@angular/common';
import { PacienteTabsComponent } from '../paciente-tabs/paciente-tabs.component';

@Component({
    selector: 'app-paciente',
    templateUrl: './paciente.component.html',
    styleUrls: ['./paciente.component.scss'],
    standalone: true,
    imports: [PacienteListComponent,
        PacienteTabsComponent,
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