import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PacienteEvolucaoEnfermagem } from '../models/paciente-evolucao-enfermagem.model';

@Injectable({
  providedIn: 'root'
})
export class PacienteEvolucaoEnfermagemService {
  private apiUrl = `${environment.apiUrl}/evolucao-enfermagem`;

  constructor(private http: HttpClient) { }

  // GET - Buscar todos os evolucao enfermagem
  getEvolucaoEnfermagem(): Observable<PacienteEvolucaoEnfermagem[]> {
    return this.http.get<PacienteEvolucaoEnfermagem[]>(this.apiUrl);
  }

  // GET - Buscar uma evolução enfermagem por ID
  getEvolucaoEnfermagemById(id: string): Observable<PacienteEvolucaoEnfermagem> {
    return this.http.get<PacienteEvolucaoEnfermagem>(`${this.apiUrl}/${id}`);
  }

  // GET - Buscar evolucao enfermagem por PacienteId
  getEvolucaoEnfermagemByPacienteId(pacienteId: string): Observable<PacienteEvolucaoEnfermagem[]> {
    return this.http.get<PacienteEvolucaoEnfermagem[]>(`${this.apiUrl}/paciente/${pacienteId}`)
  }

  // POST - Criar evolução enfermagem
  createEvolucaoEnfermagem(EvolucaoEnfermagem: PacienteEvolucaoEnfermagem): Observable<PacienteEvolucaoEnfermagem> {
    return this.http.post<PacienteEvolucaoEnfermagem>(this.apiUrl, EvolucaoEnfermagem);
  }

  // PUT - Atualizar evolução enfermagem
  updateEvolucaoEnfermagem(id: number, EvolucaoEnfermagem: PacienteEvolucaoEnfermagem): Observable<PacienteEvolucaoEnfermagem> {
    return this.http.put<PacienteEvolucaoEnfermagem>(`${this.apiUrl}/${id}`, EvolucaoEnfermagem);
  }

  // DELETE - Remover evolução enfermagem
  deleteEvolucaoEnfermagem(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
