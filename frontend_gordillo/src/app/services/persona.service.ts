import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Persona {
  id?: number;
  nombre: string;
  apellido: string;
  fechaNacimiento: string;
  puesto: string;
  sueldo: number;
}

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  private apiUrl = 'http://localhost:8080/api/personas';

  constructor(private http: HttpClient) {}

  getPersonas(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

  getPersonaById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  crearPersona(persona: Persona): Observable<any> {
    return this.http.post<any>(this.apiUrl, persona);
  }

  actualizarPersona(id: number, persona: Persona): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, persona);
  }

  eliminarPersona(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}
