import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PacienteDispositivo } from '../models/paciente-dispositivo.model';

@Injectable({
  providedIn: 'root'
})
export class PacienteDispositivosService {
  private apiUrl = `${environment.apiUrl}/dispositivos`;

  constructor(private http: HttpClient) { }

  // GET - Buscar todos os dispositivos
  getDispositivos(): Observable<PacienteDispositivo[]> {
    return this.http.get<PacienteDispositivo[]>(this.apiUrl);
  }

  // GET - Buscar um dispositivo por ID
  getDispositivoById(id: string): Observable<PacienteDispositivo> {
    return this.http.get<PacienteDispositivo>(`${this.apiUrl}/${id}`);
  }

  // GET - Buscar dispositivos por PacienteId
  getDispositivoByPacienteId(pacienteId: string): Observable<PacienteDispositivo[]> {
    return this.http.get<PacienteDispositivo[]>(`${this.apiUrl}/paciente/${pacienteId}`)
  }

  // POST - Criar dispositivo
  createDispositivo(Dispositivo: PacienteDispositivo): Observable<PacienteDispositivo> {
    return this.http.post<PacienteDispositivo>(this.apiUrl, Dispositivo);
  }

  // PUT - Atualizar dispositivo
  updateDispositivo(id: number, Dispositivo: PacienteDispositivo): Observable<PacienteDispositivo> {
    return this.http.put<PacienteDispositivo>(`${this.apiUrl}/${id}`, Dispositivo);
  }

  // DELETE - Remover dispositivo
  deleteDispositivo(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
