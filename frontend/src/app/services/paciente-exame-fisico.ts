import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PacienteExameFisico } from '../models/paciente-exame-fisico.model';

@Injectable({
  providedIn: 'root'
})
export class PacienteExameFisicoService {
  private apiUrl = `${environment.apiUrl}/exame-fisico`;

  constructor(private http: HttpClient) { }

  // GET - Buscar todos os exames fisicos
  getExamesFisicos(): Observable<PacienteExameFisico[]> {
    return this.http.get<PacienteExameFisico[]>(this.apiUrl);
  }

  // GET - Buscar um exame fisico por ID
  getExameFisicoById(id: number): Observable<PacienteExameFisico> {
    return this.http.get<PacienteExameFisico>(`${this.apiUrl}/${id}`);
  }

  // GET - Buscar exames fisicos por PacienteId
  getExameFisicoByPacienteId(pacienteId: string): Observable<PacienteExameFisico[]> {
    return this.http.get<PacienteExameFisico[]>(`${this.apiUrl}/paciente/${pacienteId}`)
  }

  // POST - Criar exame fisico
  createExameFisico(ExameFisico: PacienteExameFisico): Observable<PacienteExameFisico> {
    return this.http.post<PacienteExameFisico>(this.apiUrl, ExameFisico);
  }

  // PUT - Atualizar exame fisico
  updateExameFisico(id: number, ExameFisico: PacienteExameFisico): Observable<PacienteExameFisico> {
    return this.http.put<PacienteExameFisico>(`${this.apiUrl}/${id}`, ExameFisico);
  }

  // DELETE - Remover exame fisico
  deleteExameFisico(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
