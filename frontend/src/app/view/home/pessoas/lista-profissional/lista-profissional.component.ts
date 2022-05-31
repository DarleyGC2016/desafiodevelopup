import { Router } from '@angular/router';

import { Pessoa } from '../../Objetos/pessoa';
import { Component, OnInit } from '@angular/core';
import { CadastroService } from '../cadastro.service';


@Component({
  selector: 'app-lista-profissional',
  templateUrl: './lista-profissional.component.html',
  styleUrls: ['./lista-profissional.component.css']
})
export class ListaProfissionalComponent implements OnInit {

  prod: any;
  pessoas: Array<Pessoa> = [];
  carregarLoading = false;
  textEditar = 'Editar';
  textExcluir = 'Excluir';
  textNovo = 'Novo Profissional';
  origem = 'cadastro';
  origemExcluir = 'excluir';
  corEditar = 'btn btn-warning';
  corExcluir = 'btn btn-danger';
  corNovo = 'btn btn-success';
  pessoa: Pessoa = new Pessoa();


  constructor(private cadastroService: CadastroService, private router: Router) { }

  ngOnInit(): void {

    this.cadastroService.listar().subscribe(p => {
      setTimeout(() => {
        this.carregarLoading  = true;
        this.pessoas = p;
      }, 2000);
    });

  }

   excluirItem = (id: any) => {
     this.cadastroService.excluirItem(id).subscribe(
        success => this.ngOnInit(),
        error => alert('Algo deu errado na transação'),
        () => console.log('Requisição completa')
      );
      // this.ngOnInit();
  }

  navegar = () => {
    this.router.navigate(['cadastro']);
  }

}
