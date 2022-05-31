import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router'

import { Pessoa } from '../../Objetos/pessoa';
import { CadastroService } from '../cadastro.service';
import { Equipe } from '../../Objetos/equipe';
import { EquipeSevice } from 'src/app/view/home/equipes/equipe-sevice.service';


@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  id: any;
  pessoa: Pessoa = new Pessoa();
  textoBotao = 'Salvar';
  voltar = 'Cancelar';
  corVoltar = 'btn btn-danger';
  origem = 'listar';

  formInvalido = false;
  cargos = [
    {
    "id": 1,
    "nome": "Analista de Sistemas Jr."
  },
  {
    "id": 2,
    "nome": "Analista de Sistemas Pl."
  },
  {
    "id": 3,
    "nome": "Analista de Sistemas Sr."
  }
];

listaEquipe:Array<Equipe> = [];

  constructor(
    private router: Router,
    private cadastroService: CadastroService,
    private equipeService: EquipeSevice
  ) { }

  ngOnInit(): void {
    
    this.equipeService.listar().subscribe(equipes => {
        this.listaEquipe = equipes; 
    });

  
  }




  navegar = (rota: any) => {
    this.router.navigate([rota]);
  }

  onSubmit(form: any) {
     console.log('Service: ', this.cadastroService);
     
    if(form.valid === false) {
      this.formInvalido = true;
    }else{
      if(this.textoBotao === 'Salvar') {
        
        this.cadastroService.adicionar(this.pessoa).subscribe(
          success => this.navegar('listar'),
          error => console.log('Deu ruim'),
          () => console.log('Requisição completa'));
      }
    }
  }

}
