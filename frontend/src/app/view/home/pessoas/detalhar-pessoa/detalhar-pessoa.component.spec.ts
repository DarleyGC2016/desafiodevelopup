import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { ComunsModule } from '../../comum/comuns.module';
import { CadastroService } from '../cadastro.service';

import { DetalharPessoaComponent } from './detalhar-pessoa.component';

describe('DetalharPessoaComponent', () => {
  let component: DetalharPessoaComponent;
  let fixture: ComponentFixture<DetalharPessoaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetalharPessoaComponent ],
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
    fixture = TestBed.createComponent(DetalharPessoaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
