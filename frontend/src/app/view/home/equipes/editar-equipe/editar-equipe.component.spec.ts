import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { ComunsModule } from '../../comum/comuns.module';
import { EquipeSevice } from '../equipe-sevice.service';

import { EditarEquipeComponent } from './editar-equipe.component';

describe('EditarEquipeComponent', () => {
  let component: EditarEquipeComponent;
  let fixture: ComponentFixture<EditarEquipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditarEquipeComponent ],
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
    fixture = TestBed.createComponent(EditarEquipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
