import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { PacienteExameComplementar } from '../../models/paciente-exame-complementar.model';
import { PacienteExameComplementarService } from '../../services/paciente-exame-complementar';

import { CardModule } from 'primeng/card';
import { TagModule } from 'primeng/tag';
import { DividerModule } from 'primeng/divider';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-paciente-exame-complementar',
    templateUrl: './paciente-exame-complementar.component.html',
    styleUrls: ['./paciente-exame-complementar.component.scss'],
    standalone: true,
    imports: [CardModule, TagModule, DividerModule, CommonModule],
    providers: [PacienteExameComplementarService]
})
export class PacienteExameComplementarComponent implements OnChanges {
    @Input() pacienteId: string | null = null;
    exameComplementar: PacienteExameComplementar[] = [];

    constructor(private exameComplementarService: PacienteExameComplementarService) { }

    ngOnChanges(changes: SimpleChanges) {
        if (changes['pacienteId'] && this.pacienteId) {
            this.loadExameComplementarData(this.pacienteId);
        }
    }

    loadExameComplementarData(id: string) {
        this.exameComplementarService.getExameComplementarByPacienteId(id).subscribe({
            next: (data) => this.exameComplementar = data,
            error: (err) => {
                console.error('Erro ao carregar HPP:', err);
                this.exameComplementar = [];
            }
        });
    }
}
