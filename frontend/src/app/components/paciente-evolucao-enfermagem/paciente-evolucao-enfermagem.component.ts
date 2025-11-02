import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { PacienteEvolucaoEnfermagem } from '../../models/paciente-evolucao-enfermagem.model';
import { PacienteEvolucaoEnfermagemService } from '../../services/paciente-evolucao-enfermagem';

import { CardModule } from 'primeng/card';
import { TagModule } from 'primeng/tag';
import { DividerModule } from 'primeng/divider';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-paciente-evolucao-enfermagem',
    templateUrl: './paciente-evolucao-enfermagem.component.html',
    styleUrls: ['./paciente-evolucao-enfermagem.component.scss'],
    standalone: true,
    imports: [CardModule, TagModule, DividerModule, CommonModule],
    providers: [PacienteEvolucaoEnfermagemService]
})
export class PacienteEvolucaoEnfermagemComponent implements OnChanges {
    @Input() pacienteId: string | null = null;
    evolucaoEnfermagem: PacienteEvolucaoEnfermagem[] = [];

    constructor(private evolucaoEnfermagemService: PacienteEvolucaoEnfermagemService) { }

    ngOnChanges(changes: SimpleChanges) {
        if (changes['pacienteId'] && this.pacienteId) {
            this.loadHppData(this.pacienteId);
        }
    }

    loadHppData(id: string) {
        this.evolucaoEnfermagemService.getEvolucaoEnfermagemByPacienteId(id).subscribe({
            next: (data) => this.evolucaoEnfermagem = data,
            error: (err) => {
                console.error('Erro ao carregar HPP:', err);
                this.evolucaoEnfermagem = [];
            }
        });
    }
}
