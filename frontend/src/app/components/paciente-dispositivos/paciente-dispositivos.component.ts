import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { PacienteDispositivo } from '../../models/paciente-dispositivo.model';
import { PacienteDispositivosService } from '../../services/paciente-dispositivos';

import { CardModule } from 'primeng/card';
import { TagModule } from 'primeng/tag';
import { DividerModule } from 'primeng/divider';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-paciente-dispositivos',
    templateUrl: './paciente-dispositivos.component.html',
    styleUrls: ['./paciente-dispositivos.component.scss'],
    standalone: true,
    imports: [CommonModule, CardModule, TagModule, DividerModule],
    providers: [PacienteDispositivosService]
})
export class PacienteDispositivosComponent implements OnChanges {
    @Input() pacienteId: string | null = null;

    dispositivos: PacienteDispositivo[] = [];

    constructor(private dispositivoService: PacienteDispositivosService) { }

    ngOnChanges(changes: SimpleChanges): void {
        if (changes['pacienteId'] && this.pacienteId) {
            this.loadDispositivosPorPaciente(this.pacienteId);
        }
    }

    loadDispositivosPorPaciente(id: string) {
        this.dispositivoService.getDispositivoByPacienteId(id).subscribe({
            next: (data) => this.dispositivos = data,
            error: (err) => console.error('Erro ao carregar dispositivos:', err)
        });
    }

    getStatusLabel(value: boolean): string {
        return value ? 'Sim' : 'Não';
    }
}