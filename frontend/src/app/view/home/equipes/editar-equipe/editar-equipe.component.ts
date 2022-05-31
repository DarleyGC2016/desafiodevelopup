import { Equipe } from 'src/app/view/home/Objetos/equipe';
import { EquipeSevice } from 'src/app/view/home/equipes/equipe-sevice.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-editar-equipe',
  templateUrl: './editar-equipe.component.html',
  styleUrls: ['./editar-equipe.component.css']
})
export class EditarEquipeComponent implements OnInit {
  id: any;

  equipe: Equipe = new Equipe();

  formInvalido = false;

  voltar  = 'Cancelar';
  corVoltar  = 'btn btn-danger';
  origem  = 'equipes';


  constructor(private service: EquipeSevice,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe(parametros =>  {
         const ident = 'id';
         if (parametros[ident]) {
           this.id = parametros[ident];
           this.service.findById(this.id).subscribe(equipe =>  {
             this.equipe = equipe;
           });
         }
    });
  }

  onSubmit(form: any): void {
    if (form.valid === false) {
      this.formInvalido = true;
    }else{
        this.service.update(this.equipe).subscribe(
          success => this.navegar('equipes'),
          error => console.log('Deu ruim'),
          () => console.log('Requisição completa'));
    }
  }

  navegar = (rota: any) =>  {
    this.router.navigate( [rota] );
  }

}
