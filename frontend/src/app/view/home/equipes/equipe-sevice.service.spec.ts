import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { EquipeSevice } from './equipe-sevice.service';

describe('EquipeSeviceService', () => {
  let service: EquipeSevice;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      
      imports:[
                HttpClientModule
              ]
    })
    .compileComponents();
  })

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EquipeSevice);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
