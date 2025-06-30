import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule, DatePipe, CurrencyPipe } from '@angular/common';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatCardModule } from '@angular/material/card';

import { PersonaService, Persona } from '../../services/persona.service';

@Component({
  selector: 'app-listado-personas',
  standalone: true,
  imports: [
    CommonModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule,
    MatCardModule,
    DatePipe,
    CurrencyPipe
  ],
  templateUrl: './listado-personas.html',
  styleUrls: ['./listado-personas.scss']
})
export class ListadoPersonasComponent implements OnInit {
  personas: Persona[] = [];
  columnas: string[] = ['nombre', 'apellido', 'fechaNacimiento', 'puesto', 'sueldo', 'acciones'];

  constructor(
    private personaService: PersonaService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.cargarPersonas();
  }

  cargarPersonas() {
    this.personaService.getPersonas().subscribe(resp => {
      if (resp.status && Array.isArray(resp.data)) {
        this.personas = resp.data;
      }
    });
  }

  crear() {
    this.router.navigate(['/nueva']);
  }

  editar(id: number) {
    this.router.navigate(['/editar', id]);
  }

  eliminar(id: number) {
    if (confirm('¿Estás seguro de eliminar esta persona?')) {
      this.personaService.eliminarPersona(id).subscribe(() => this.cargarPersonas());
    }
  }
}