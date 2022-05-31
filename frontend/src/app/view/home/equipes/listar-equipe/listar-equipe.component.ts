import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EquipeSevice } from '../equipe-sevice.service';
import { Equipe } from 'src/app/view/home/Objetos/equipe';

@Component({
  selector: 'app-listar-equipe',
  templateUrl: './listar-equipe.component.html',
  styleUrls: ['./listar-equipe.component.css']
})
export class ListarEquipeComponent implements OnInit {
  listaEquipe: Array<Equipe> = [];
  carregarLoading = false;

  textNovo = 'Nova Equipe';
  origem  = 'cadastrar_equipe';
  corNovo  = 'btn btn-success';
  textEditar  = 'Editar';
  textExcluir  = 'Excluir';
  rotaEditar = 'editar_equipe';
  corEditar  = 'btn btn-warning';
  corExcluir = 'btn btn-danger';

  constructor(private service: EquipeSevice, private rota: Router) { }

  ngOnInit(): void {
    this.service.listar().subscribe(equipes => {
      setTimeout(() => {
        this.carregarLoading = true;
        this.listaEquipe = equipes;
      }, 2000);
    });

  }

  cadastrar = () => {
    this.rota.navigate( ['cadastrar_equipe'] );
  }
}
