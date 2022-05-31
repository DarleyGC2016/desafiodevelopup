import { EquipeSevice } from '../equipe-sevice.service';
import { Router } from '@angular/router';
import { Equipe } from '../../Objetos/equipe';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastar-equipe',
  templateUrl: './cadastar-equipe.component.html',
  styleUrls: ['./cadastar-equipe.component.css']
})
export class CadastarEquipeComponent implements OnInit {

  equipe: Equipe = new Equipe();
  textoBotao = 'Salvar';
  formInvalido = false;

  voltar = 'Cancelar';
  corVoltar = 'btn btn-danger';
  origem = 'equipes';

  constructor(private rota: Router, private service: EquipeSevice) { }

  ngOnInit(): void {
  }

  navegar = (nomeRota: any) => {
    this.rota.navigate( [nomeRota] );
  }

  onSubmit(form: any): void {
    if (form.valid === false) {
      this.formInvalido = true;
    }else{
      if (this.textoBotao === 'Salvar') {
          this.service.adicionar(this.equipe).subscribe(
            success => this.navegar('equipes'),
            error => console.log('Deu ruim'),
            () => console.log('Requisição completa')
          );
      }else{
        console.log('colocar editar');
        // this.editar()
      }
    }
  }

}
