import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';

import { PersonaService, Persona } from '../../services/persona.service';

@Component({
  selector: 'app-formulario-persona',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatIconModule,
    MatCardModule,
    MatToolbarModule
  ],
  templateUrl: './formulario-persona.html',
  styleUrls: ['./formulario-persona.scss']
})
export class FormularioPersonaComponent implements OnInit {
  persona: Persona = {
    nombre: '',
    apellido: '',
    fechaNacimiento: '',
    puesto: '',
    sueldo: 0
  };
  esEdicion: boolean = false;
  idPersona?: number;

  constructor(
    private personaService: PersonaService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.esEdicion = true;
        this.idPersona = +id;
        this.personaService.getPersonaById(this.idPersona).subscribe(resp => {
          if (resp.status) {
            this.persona = resp.data;
          }
        });
      }
    });
  }

  guardar() {
    if (this.esEdicion && this.idPersona !== undefined) {
      this.personaService.actualizarPersona(this.idPersona, this.persona).subscribe(() => {
        this.router.navigate(['/']);
      });
    } else {
      this.personaService.crearPersona(this.persona).subscribe(() => {
        this.router.navigate(['/']);
      });
    }
  }

  cancelar() {
    this.router.navigate(['/']);
  }
}