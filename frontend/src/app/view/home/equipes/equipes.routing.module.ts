import { NgModule } from '@angular/core';
import {  RouterModule, Routes } from '@angular/router';
import { EditarEquipeComponent } from './editar-equipe/editar-equipe.component';
import { CadastarEquipeComponent } from './cadastar-equipe/cadastar-equipe.component';
import { ListarEquipeComponent } from './listar-equipe/listar-equipe.component';


const equipesRotas: Routes =  [
    {path: 'equipes', component: ListarEquipeComponent},
    {path: 'cadastrar_equipe', component: CadastarEquipeComponent},
    {path: 'editar_equipe/:id', component: EditarEquipeComponent}
];

@NgModule({
    imports: [RouterModule.forChild(equipesRotas)],
    exports: [RouterModule]
})

export class EquipeRoutingModule{}
