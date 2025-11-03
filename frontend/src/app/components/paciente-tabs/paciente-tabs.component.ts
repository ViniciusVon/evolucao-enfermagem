import { Component, Input } from '@angular/core';
import { TabsModule } from 'primeng/tabs';

import { PacienteHppComponent } from '../paciente-hpp/paciente-hpp.component';
import { PacienteDispositivosComponent } from '../paciente-dispositivos/paciente-dispositivos.component';
import { PacienteEvolucaoEnfermagemComponent } from '../paciente-evolucao-enfermagem/paciente-evolucao-enfermagem.component';
import { PacienteCefalocaudalComponent } from '../paciente-cefalocaudal/paciente-cefalocaudal.component';
import { PacienteExameFisicoComponent } from '../paciente-exame-fisico/paciente-exame-fisico.component';
import { PacienteExameComplementarComponent } from '../paciente-exame-complementar/paciente-exame-complementar.component';

@Component({
    selector: 'app-paciente-tabs',
    standalone: true,
    imports: [
        TabsModule,
        PacienteHppComponent,
        PacienteDispositivosComponent,
        PacienteEvolucaoEnfermagemComponent,
        PacienteCefalocaudalComponent,
        PacienteExameFisicoComponent,
        PacienteExameComplementarComponent
    ],
    templateUrl: './paciente-tabs.component.html',
    styleUrls: ['./paciente-tabs.component.scss']
})
export class PacienteTabsComponent {
    @Input() pacienteId: string | null = null;
}
