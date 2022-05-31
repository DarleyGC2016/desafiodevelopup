import { Equipe } from './../../Objetos/equipe';
import { EquipeSevice } from 'src/app/view/home/equipes/equipe-sevice.service';
import { HttpClientTestingModule } from '@angular/common/http/testing';

import { RouterTestingModule } from '@angular/router/testing';

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroService } from './../cadastro.service';
import { CadastroComponent } from './cadastro.component';
import { FormsModule } from '@angular/forms';
import { ComunsModule } from '../../comum/comuns.module';
import { Pessoa } from '../../Objetos/pessoa';
import { Observable, of } from 'rxjs';
import { analyzeAndValidateNgModules } from '@angular/compiler';


describe('CadastroComponent', () => {
  let component: CadastroComponent;
  let fixture: ComponentFixture<CadastroComponent>;
  let cadastroServiceStub: Partial<CadastroService>;


  cadastroServiceStub = {
   adicionar: (p:Pessoa):Observable<Pessoa> =>{
      return new Observable<Pessoa>();
    }
  }

  beforeEach(async () => {
    const cadastroServiceSpy = jasmine.createSpyObj<CadastroService>(['adicionar']);
    cadastroServiceSpy.adicionar.and.returnValue(of([{"success":"success","error":"error"}]))
    await TestBed.configureTestingModule({
      declarations: [ CadastroComponent ],
      providers: [
        {provide: CadastroService,useValue: cadastroServiceSpy}
      ],
      imports:[RouterTestingModule.withRoutes([
                    { path: 'listar', component: EquipeSevice}
                ]),
                HttpClientTestingModule,
                FormsModule,               
                ComunsModule 
              ]
    })
    .compileComponents();

    
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('navegar()',()=>{
    let rota = 'listar';
    const app = fixture.componentInstance;
    spyOn(app,'navegar').and.callThrough();

    app.navegar(rota);
    expect(app.navegar).toHaveBeenCalled();
  });

  it('ngOnInit()',()=>{
    const equipes: Equipe[] = [{
      id:1,
      nome: "A"
    }]
      const app = fixture.componentInstance;
      app.listaEquipe = equipes;
      spyOn(app,'ngOnInit').and.callThrough();
      app.ngOnInit();
      expect(app.ngOnInit).toHaveBeenCalled();
      


  });


    
   /* const expectedEquipe: Equipe[] = [{
      id:1,
      nome: "A"
    }];
    httpClientSpy.get.and.returnValue(asyncData(expectedEquipe));
    equipeService.listar().subscribe({
      next: equipes =>{
        expect(equipes)
        .withContext("expected pessoas")
        .toEqual(expectedEquipe);
        done();
      }, error: done.fail
    });
    expect(httpClientSpy.get.calls.count())
    .withContext('one call')
    .toBe(1);*/


  it('onSubmit()',()=>{
    
    var form = {
     
    };
    //form.valid =  false;
     let pessoa:Pessoa = new Pessoa();
     pessoa.nome = "Darley";
     pessoa.cargo = "dev";
     pessoa.email = "darley@gmail.com";
     pessoa.contato = "619999-5555";
     pessoa.sobrenome = "Garcia Cardoso";
     pessoa.equipe.id = 1;
     pessoa.equipe.nome = "A";
    const app = fixture.componentInstance;
    app.formInvalido = true;
    app.textoBotao = "Salvar";
    spyOn(app,'onSubmit').and.callThrough();

    app.onSubmit(form);
    expect(app.pessoa).toBeTruthy(true);
    expect(app.onSubmit).toHaveBeenCalled();

  });
 
});


