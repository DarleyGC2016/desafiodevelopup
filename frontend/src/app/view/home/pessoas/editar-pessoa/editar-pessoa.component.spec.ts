import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { ComunsModule } from '../../comum/comuns.module';
import { CadastroService } from '../cadastro.service';

import { EditarPessoaComponent } from './editar-pessoa.component';

describe('EditarPessoaComponent', () => {
  let component: EditarPessoaComponent;
  let fixture: ComponentFixture<EditarPessoaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarPessoaComponent ],
      providers: [
        {provider: CadastroService,useValue: {}}
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
    fixture = TestBed.createComponent(EditarPessoaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
