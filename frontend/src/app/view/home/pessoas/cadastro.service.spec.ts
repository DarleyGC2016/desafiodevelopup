import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { CadastroService } from './cadastro.service';

describe('CadastroService', () => {
  let service: CadastroService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[
                HttpClientModule
              ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CadastroService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
