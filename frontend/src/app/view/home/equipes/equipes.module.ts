import { ComunsModule } from './../comum/comuns.module';
import { CadastarEquipeComponent } from './cadastar-equipe/cadastar-equipe.component';
import { ListarEquipeComponent } from './listar-equipe/listar-equipe.component';
import { EquipeRoutingModule } from './equipes.routing.module';
import { NgModule } from '@angular/core';
import { EquipeSevice } from './equipe-sevice.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { EditarEquipeComponent } from './editar-equipe/editar-equipe.component';

@NgModule({
    imports: [
                FormsModule,
                CommonModule,
                EquipeRoutingModule,
                ComunsModule
            ],
    exports: [],
    declarations: [
                    CadastarEquipeComponent,
                    ListarEquipeComponent,
                    EditarEquipeComponent
                  ],
    providers: [EquipeSevice]
})

export class EquipesModule{}
