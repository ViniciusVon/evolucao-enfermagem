import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PacienteHpp } from '../models/paciente-hpp.model';

@Injectable({
  providedIn: 'root'
})
export class PacienteHppsService {
  private apiUrl = `${environment.apiUrl}/hpp`;

  constructor(private http: HttpClient) { }

  // GET - Buscar todos os hpp
  getHpps(): Observable<PacienteHpp[]> {
    return this.http.get<PacienteHpp[]>(this.apiUrl);
  }

  // GET - Buscar um hpp por ID
  getHppById(id: number): Observable<PacienteHpp> {
    return this.http.get<PacienteHpp>(`${this.apiUrl}/${id}`);
  }

  // GET - Buscar dispositivos por PacienteId
  getHppByPacienteId(pacienteId: string): Observable<PacienteHpp[]> {
    return this.http.get<PacienteHpp[]>(`${this.apiUrl}/paciente/${pacienteId}`)
  }

  // POST - Criar hpp
  createHpp(Hpp: PacienteHpp): Observable<PacienteHpp> {
    return this.http.post<PacienteHpp>(this.apiUrl, Hpp);
  }

  // PUT - Atualizar hpp
  updateHpp(id: number, Hpp: PacienteHpp): Observable<PacienteHpp> {
    return this.http.put<PacienteHpp>(`${this.apiUrl}/${id}`, Hpp);
  }

  // DELETE - Remover hpp
  deleteHpp(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
