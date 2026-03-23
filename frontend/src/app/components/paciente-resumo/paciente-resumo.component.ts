import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { getInitials, getStatusLabel, getStatusSeverity } from '../../utils/paciente.utils';
import { CommonModule } from '@angular/common';
import { PacienteService } from '../../services/paciente';
import { Paciente } from '../../models/paciente.model';
import { FormsModule } from '@angular/forms';

// PrimeNG
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { AvatarModule } from 'primeng/avatar';
import { TagModule } from 'primeng/tag';
import { DividerModule } from 'primeng/divider';
import { RippleModule } from 'primeng/ripple';
import { ListboxModule } from 'primeng/listbox';
import { ButtonModule } from 'primeng/button';
import { FloatLabelModule } from 'primeng/floatlabel';

@Component({
    selector: 'app-paciente-resumo',
    standalone: true,
    imports: [
        CommonModule,
        FormsModule,
        CardModule,
        InputTextModule,
        AvatarModule,
        TagModule,
        DividerModule,
        RippleModule,
        ListboxModule,
        ButtonModule,
        FloatLabelModule
    ],
    templateUrl: './paciente-resumo.component.html',
    styleUrls: ['./paciente-resumo.component.scss']
})
export class PacienteResumoComponent implements OnChanges {
    @Input() pacienteId: string | null = null;
    paciente: Paciente | null = null;

    getInitials = getInitials;
    getStatusLabel = getStatusLabel;
    getSeverity = getStatusSeverity;

    constructor(private pacienteService: PacienteService) { }

    ngOnChanges(changes: SimpleChanges) {
        if (changes['pacienteId'] && this.pacienteId) {
            this.loadPaciente(this.pacienteId);
        }
    }

    loadPaciente(pacienteId: string): void {
        this.pacienteService.getPacienteById(pacienteId).subscribe({
            next: (data) => this.paciente = data,
            error: (err) => console.error('Erro ao buscar pacientes', err)
        });
    }
}
