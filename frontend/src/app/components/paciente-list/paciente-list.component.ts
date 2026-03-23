import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { getInitials, getStatusLabel, getStatusSeverity } from '../../utils/paciente.utils';
import { CommonModule } from '@angular/common';
import { PacienteService } from '../../services/paciente';
import { Paciente } from '../../models/paciente.model';
import { FormsModule } from '@angular/forms';

// PrimeNG
import { CardModule } from 'primeng/card';
import { InputTextModule } from 'primeng/inputtext';
import { IconFieldModule } from 'primeng/iconfield';
import { InputIconModule } from 'primeng/inputicon';
import { AvatarModule } from 'primeng/avatar';
import { TagModule } from 'primeng/tag';
import { DividerModule } from 'primeng/divider';
import { RippleModule } from 'primeng/ripple';
import { ListboxModule } from 'primeng/listbox';
import { ButtonModule } from 'primeng/button';
import { FloatLabelModule } from 'primeng/floatlabel';

@Component({
    selector: 'app-paciente-list',
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
        FloatLabelModule,
        IconFieldModule,
        InputIconModule
    ],
    templateUrl: './paciente-list.component.html',
    styleUrls: ['./paciente-list.component.scss']
})
export class PacienteListComponent implements OnInit {
    pacientes: Paciente[] = [];
    searchText = '';

    pacienteAtivo: Paciente | null = null;
    getInitials = getInitials;
    getStatusLabel = getStatusLabel;
    getStatusSeverity = getStatusSeverity;

    @Output() pacienteSelecionado = new EventEmitter<string>();

    constructor(private pacienteService: PacienteService) { }

    ngOnInit(): void {
        this.loadPacientes();
    }

    loadPacientes(): void {
        this.pacienteService.getPacientes().subscribe({
            next: (data) => this.pacientes = data,
            error: (err) => console.error('Erro ao buscar pacientes', err)
        });
    }

    selecionar(paciente: Paciente): void {
        this.pacienteAtivo = paciente;
        this.pacienteSelecionado.emit(paciente.id);
    }

    filtrarPacientes(): Paciente[] {
        const texto = this.searchText.toLowerCase();
        return this.pacientes.filter(p =>
            (p.nome?.toLowerCase().includes(texto) ?? false) ||
            (p.status?.toLowerCase().includes(texto) ?? false)
        );
    }
}