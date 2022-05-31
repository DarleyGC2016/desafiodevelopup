import { EditarPessoa } from './../../Objetos/editar.pessoa';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CadastroService } from '../cadastro.service';

@Component({
  selector: 'app-editar-pessoa',
  templateUrl: './editar-pessoa.component.html',
  styleUrls: ['./editar-pessoa.component.css']
})
export class EditarPessoaComponent implements OnInit {

  id:any
  pessoa: EditarPessoa = new EditarPessoa();

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
]

  formInvalido = false;
  
  voltar:string = 'Cancelar'
  corVoltar:string = 'btn btn-danger'
  origem:string = 'listar'


  constructor(private cadastroService: CadastroService,
              private activatedRoute: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {

    
    this.activatedRoute.params.subscribe(parametros =>{

      if(parametros['id']){
        this.id = parametros['id']
               
        this.cadastroService.findById(this.id).subscribe(pessoa =>{
                   
          this.pessoa.id = pessoa.id
          this.pessoa.cargo = pessoa.cargo
          this.pessoa.email = pessoa.email
          this.pessoa.contato = pessoa.contato
        })
      }
    })
  }

  onSubmit(form:any){
    if(form.valid == false){
      this.formInvalido = true
    }else{
        
        this.cadastroService.editar(this.pessoa).subscribe(
          success => this.navegar('listar'),
          error => console.log("Deu ruim"),
          () => console.log('Requisição completa'))
      
    }
  }

  navegar = (rota: any) =>{
    this.router.navigate([rota])
  }
}
