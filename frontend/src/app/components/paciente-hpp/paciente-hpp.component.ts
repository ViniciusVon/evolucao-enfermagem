import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { PacienteHpp } from '../../models/paciente-hpp.model';
import { PacienteHppsService } from '../../services/paciente-hpp';

import { CardModule } from 'primeng/card';
import { TagModule } from 'primeng/tag';
import { DividerModule } from 'primeng/divider';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-paciente-hpp',
    templateUrl: './paciente-hpp.component.html',
    styleUrls: ['./paciente-hpp.component.scss'],
    standalone: true,
    imports: [CardModule, TagModule, DividerModule, CommonModule],
    providers: [PacienteHppsService]
})
export class PacienteHppComponent implements OnChanges {
    @Input() pacienteId: string | null = null;
    hpp: PacienteHpp[] = [];

    constructor(private hppService: PacienteHppsService) { }

    ngOnChanges(changes: SimpleChanges) {
        if (changes['pacienteId'] && this.pacienteId) {
            this.loadHppData(this.pacienteId);
        }
    }

    loadHppData(id: string) {
        this.hppService.getHppByPacienteId(id).subscribe({
            next: (data) => this.hpp = data,
            error: (err) => {
                console.error('Erro ao carregar HPP:', err);
                this.hpp = [];
            }
        });
    }
}
