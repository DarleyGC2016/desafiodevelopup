import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroComponent } from './cadastro/cadastro.component';
import { PessoasRoutingModule } from './pessoas.routing.module';

import { ListaProfissionalComponent } from './lista-profissional/lista-profissional.component';
import { CadastroService } from './cadastro.service';

import { EditarPessoaComponent } from './editar-pessoa/editar-pessoa.component';
import { ComunsModule } from '../comum/comuns.module';
import { DetalharPessoaComponent } from './detalhar-pessoa/detalhar-pessoa.component';

@NgModule({
    imports: [
             FormsModule,
             CommonModule,
             PessoasRoutingModule,
             ComunsModule
             ],
    exports: [],
    declarations: [
                    CadastroComponent,
                    ListaProfissionalComponent,
                    EditarPessoaComponent,
                    DetalharPessoaComponent
                  ],
    providers: [
                 CadastroService
               ]
})

export class PessoasModule{}
