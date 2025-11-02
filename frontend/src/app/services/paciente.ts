import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Paciente } from '../models/paciente.model';

@Injectable({
  providedIn: 'root'
})
export class PacienteService {
  private apiUrl = `${environment.apiUrl}/pacientes`;

  constructor(private http: HttpClient) { }

  // GET - Buscar todos os pacientes
  getPacientes(): Observable<Paciente[]> {
    return this.http.get<Paciente[]>(this.apiUrl);
  }

  // GET - Buscar um paciente por ID
  getPacienteById(id: number): Observable<Paciente> {
    return this.http.get<Paciente>(`${this.apiUrl}/${id}`);
  }

  // POST - Criar paciente
  createPaciente(Paciente: Paciente): Observable<Paciente> {
    return this.http.post<Paciente>(this.apiUrl, Paciente);
  }

  // PUT - Atualizar paciente
  updatePaciente(id: number, Paciente: Paciente): Observable<Paciente> {
    return this.http.put<Paciente>(`${this.apiUrl}/${id}`, Paciente);
  }

  // DELETE - Remover paciente
  deletePaciente(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
