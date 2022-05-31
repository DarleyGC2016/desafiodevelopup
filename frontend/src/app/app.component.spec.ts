import { TestBed } from '@angular/core/testing';
import { BrowserModule } from '@angular/platform-browser';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { ComunsModule } from './view/home/comum/comuns.module';
import { EquipesModule } from './view/home/equipes/equipes.module';
import { HomeComponent } from './view/home/home.component';
import { PessoasModule } from './view/home/pessoas/pessoas.module';

describe('AppComponent', () => {
  beforeEach(async () => {
    return await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        BrowserModule,
        EquipesModule,
        PessoasModule,               
        ComunsModule 
      ],
      declarations: [
        AppComponent,
        HomeComponent,
      ]
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'curso-ts'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('curso-ts');
  });

  /**it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('.content span').textContent).toContain('curso-ts app is running!');
  });*/
});
