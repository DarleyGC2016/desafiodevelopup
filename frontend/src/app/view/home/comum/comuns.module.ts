import { NgModule } from '@angular/core';
import { ButtonIdComponent } from './button-id/button-id.component';
import { ButtonComponent } from './button/button.component';

@NgModule({
    imports: [],
    declarations: [
                  ButtonIdComponent,
                  ButtonComponent],
    providers: [],
    exports: [
              ButtonIdComponent,
              ButtonComponent
            ]
})

export class ComunsModule{}
