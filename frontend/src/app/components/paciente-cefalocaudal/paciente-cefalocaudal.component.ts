import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { PacienteCefalocaudal } from '../../models/paciente-cefalocaudal.model';
import { PacienteCefalocaudalService } from '../../services/paciente-cefalocaudal';

import { CardModule } from 'primeng/card';
import { TagModule } from 'primeng/tag';
import { DividerModule } from 'primeng/divider';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-paciente-cefalocaudal',
    templateUrl: './paciente-cefalocaudal.component.html',
    styleUrls: ['./paciente-cefalocaudal.component.scss'],
    standalone: true,
    imports: [CardModule, TagModule, DividerModule, CommonModule],
    providers: [PacienteCefalocaudalService]
})
export class PacienteCefalocaudalComponent implements OnChanges {
    @Input() pacienteId: string | null = null;
    cefalocaudal: PacienteCefalocaudal[] = [];

    constructor(private cefalocaudalService: PacienteCefalocaudalService) { }

    ngOnChanges(changes: SimpleChanges) {
        if (changes['pacienteId'] && this.pacienteId) {
            this.loadCefalocaudalData(this.pacienteId);
        }
    }

    loadCefalocaudalData(id: string) {
        this.cefalocaudalService.getCefalocaudalByPacienteId(id).subscribe({
            next: (data) => this.cefalocaudal = data,
            error: (err) => {
                console.error('Erro ao carregar HPP:', err);
                this.cefalocaudal = [];
            }
        });
    }
}
