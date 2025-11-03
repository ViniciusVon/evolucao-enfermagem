import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PacienteExameComplementar } from '../models/paciente-exame-complementar.model';

@Injectable({
  providedIn: 'root'
})
export class PacienteExameComplementarService {
  private apiUrl = `${environment.apiUrl}/exame-complementar`;

  constructor(private http: HttpClient) { }

  // GET - Buscar todos os exames complementares
  getExamesComplementares(): Observable<PacienteExameComplementar[]> {
    return this.http.get<PacienteExameComplementar[]>(this.apiUrl);
  }

  // GET - Buscar um exame complementar por ID
  getExameComplementarById(id: number): Observable<PacienteExameComplementar> {
    return this.http.get<PacienteExameComplementar>(`${this.apiUrl}/${id}`);
  }

  // GET - Buscar exames complementares por PacienteId
  getExameComplementarByPacienteId(pacienteId: string): Observable<PacienteExameComplementar[]> {
    return this.http.get<PacienteExameComplementar[]>(`${this.apiUrl}/paciente/${pacienteId}`)
  }

  // POST - Criar exame complementar
  createExameComplementar(ExameComplementar: PacienteExameComplementar): Observable<PacienteExameComplementar> {
    return this.http.post<PacienteExameComplementar>(this.apiUrl, ExameComplementar);
  }

  // PUT - Atualizar exame complementar
  updateExameComplementar(id: number, ExameComplementar: PacienteExameComplementar): Observable<PacienteExameComplementar> {
    return this.http.put<PacienteExameComplementar>(`${this.apiUrl}/${id}`, ExameComplementar);
  }

  // DELETE - Remover exame complementar
  deleteExameComplementar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
