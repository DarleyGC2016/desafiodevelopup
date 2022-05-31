import { Equipe } from './equipe';

export class Pessoa {

    // constructor(public id: number, public nome: string, public email: string, public cargo: number ){

    // }
    public id = 0;
    public nome = '';
    public sobrenome  = '';
    public contato = '';
    public email = '';
    public cargo = '';
    // public equipe: number = 0;
    public equipe: Equipe = new Equipe();

}
