import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { PacienteExameFisico } from '../../models/paciente-exame-fisico.model';
import { PacienteExameFisicoService } from '../../services/paciente-exame-fisico';

import { CardModule } from 'primeng/card';
import { TagModule } from 'primeng/tag';
import { DividerModule } from 'primeng/divider';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-paciente-exame-fisico',
    templateUrl: './paciente-exame-fisico.component.html',
    styleUrls: ['./paciente-exame-fisico.component.scss'],
    standalone: true,
    imports: [CardModule, TagModule, DividerModule, CommonModule],
    providers: [PacienteExameFisicoService]
})
export class PacienteExameFisicoComponent implements OnChanges {
    @Input() pacienteId: string | null = null;
    exameFisico: PacienteExameFisico[] = [];

    constructor(private exameFisicoServico: PacienteExameFisicoService) { }

    ngOnChanges(changes: SimpleChanges) {
        if (changes['pacienteId'] && this.pacienteId) {
            this.loadExameFisicoData(this.pacienteId);
        }
    }

    loadExameFisicoData(id: string) {
        this.exameFisicoServico.getExameFisicoByPacienteId(id).subscribe({
            next: (data) => this.exameFisico = data,
            error: (err) => {
                console.error('Erro ao carregar HPP:', err);
                this.exameFisico = [];
            }
        });
    }
}
