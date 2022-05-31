import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { EditarPessoaComponent } from './editar-pessoa/editar-pessoa.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { ListaProfissionalComponent } from './lista-profissional/lista-profissional.component';

const pessoasRotas: Routes = [
    {path: 'cadastro', component: CadastroComponent},
    {path: 'cadastro/:id', component: EditarPessoaComponent},
    {path: 'listar', component: ListaProfissionalComponent},
    {path: 'excluir/:id', component: ListaProfissionalComponent}
];

@NgModule({
    imports: [RouterModule.forChild(pessoasRotas)],
    exports: [RouterModule]
})

export class PessoasRoutingModule{}


