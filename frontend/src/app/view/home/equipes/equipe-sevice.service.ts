import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Equipe } from '../Objetos/equipe';

@Injectable({
  providedIn: 'root'
})
export class EquipeSevice {

  private readonly API = `${environment.API}equipe`;

  constructor(private $http: HttpClient) { }

  listar = () => {
    return this.$http.get<Equipe[]>(`${this.API}/listar`);
  }

  adicionar = (equipe: Equipe) => {
    return this.$http.post(this.API, equipe);
  }

  update = (equipe: Equipe) => {
    return this.$http.put(`${this.API}/editar/${equipe.id}`,  equipe);
  }

  findById = (id: any) => {
    return this.$http.get<Equipe>(`${this.API}/${id}`);
  }

}
