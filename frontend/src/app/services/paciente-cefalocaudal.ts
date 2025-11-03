import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PacienteCefalocaudal } from '../models/paciente-cefalocaudal.model';

@Injectable({
  providedIn: 'root'
})
export class PacienteCefalocaudalService {
  private apiUrl = `${environment.apiUrl}/cefalocaudal`;

  constructor(private http: HttpClient) { }

  // GET - Buscar todos os cefalocaudais
  getCefalocaudais(): Observable<PacienteCefalocaudal[]> {
    return this.http.get<PacienteCefalocaudal[]>(this.apiUrl);
  }

  // GET - Buscar um cefalocaudal por ID
  getCefalocaudalById(id: number): Observable<PacienteCefalocaudal> {
    return this.http.get<PacienteCefalocaudal>(`${this.apiUrl}/${id}`);
  }

  // GET - Buscar cefalocaudais por PacienteId
  getCefalocaudalByPacienteId(pacienteId: string): Observable<PacienteCefalocaudal[]> {
    return this.http.get<PacienteCefalocaudal[]>(`${this.apiUrl}/paciente/${pacienteId}`)
  }

  // POST - Criar cefalocaudal
  createCefalocaudal(Cefalocaudal: PacienteCefalocaudal): Observable<PacienteCefalocaudal> {
    return this.http.post<PacienteCefalocaudal>(this.apiUrl, Cefalocaudal);
  }

  // PUT - Atualizar cefalocaudal
  updateCefalocaudal(id: number, Cefalocaudal: PacienteCefalocaudal): Observable<PacienteCefalocaudal> {
    return this.http.put<PacienteCefalocaudal>(`${this.apiUrl}/${id}`, Cefalocaudal);
  }

  // DELETE - Remover cefalocaudal
  deleteCefalocaudal(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
