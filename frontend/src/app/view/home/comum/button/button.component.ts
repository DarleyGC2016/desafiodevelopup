import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-comum-button',
  templateUrl: './button.component.html',
  styleUrls: ['./button.component.css']
})
export class ButtonComponent implements OnInit {

  @Input() nome = '';
  @Input() color = '';
  @Input() caminho = '';

  constructor(private rota: Router) { }

  ngOnInit(): void {
  }

  acao = () => {
    this.rota.navigate( [
                         this.caminho
                        ] );
  }

}
