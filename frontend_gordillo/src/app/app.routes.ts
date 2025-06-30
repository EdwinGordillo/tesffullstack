import { Routes } from '@angular/router';
import { ListadoPersonasComponent } from './components/listado-personas/listado-personas';
import { FormularioPersonaComponent } from './components/formulario-persona/formulario-persona';

export const routes: Routes = [
  { path: '', component: ListadoPersonasComponent },
  { path: 'nueva', component: FormularioPersonaComponent },
  { path: 'editar/:id', component: FormularioPersonaComponent },
];