import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { ComunsModule } from '../../comum/comuns.module';
import { EquipeSevice } from '../equipe-sevice.service';

import { ListarEquipeComponent } from './listar-equipe.component';

describe('ListarEquipeComponent', () => {
  let component: ListarEquipeComponent;
  let fixture: ComponentFixture<ListarEquipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarEquipeComponent ],
      providers: [
        {provider: EquipeSevice,useValue: {}}
      ],
      imports:[RouterTestingModule,
               HttpClientModule,
               FormsModule,               
               ComunsModule  
              ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarEquipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
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