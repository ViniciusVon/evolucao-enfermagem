import { Routes } from '@angular/router';
import { PacientesComponent } from './components/paciente/paciente.component';

export const routes: Routes = [
    { path: '', redirectTo: 'paciente', pathMatch: 'full' },
    { path: 'paciente', component: PacientesComponent },
];
