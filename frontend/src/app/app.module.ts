import { PessoasModule } from './view/home/pessoas/pessoas.module';
import { EquipesModule } from './view/home/equipes/equipes.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { HomeComponent } from './view/home/home.component';
import { ComunsModule } from './view/home/comum/comuns.module';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
  ],
  imports: [
            BrowserModule,
            AppRoutingModule,
            EquipesModule,
            PessoasModule,               
            ComunsModule 
           ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
