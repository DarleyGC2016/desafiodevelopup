import { Router } from '@angular/router';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-button-id',
  templateUrl: './button-id.component.html',
  styleUrls: ['./button-id.component.css']
})
export class ButtonIdComponent implements OnInit {

  @Input() id = 0;
  @Input() nome = '';
  @Input() color = '';
  @Input() caminho = '';

  constructor(private rota: Router) { }

  ngOnInit(): void {
  }

  acao = () => {
     this.rota.navigate( [this.caminho,
                          this.id
                         ] );
  }
}
