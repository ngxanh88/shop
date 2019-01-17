import {NgModule} from '@angular/core';
import {DefaultInfoModalComponent} from './info-modal/info-modal.component';
import {DefaultWarningModalComponent} from './warning-modal/warning-modal.component';
import {DefaultConfirmationModalComponent} from './confirmation-modal/confirmation-modal.component';
import {FormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {DefaultErrorModalComponent} from './error-modal/error-modal.component';
import {NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import {ModalService, SharedPipesModule} from '../..';

@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    SharedPipesModule,
    NgbModalModule
  ],
  exports: [
    NgbModalModule,
    SharedPipesModule
  ],
  declarations: [DefaultInfoModalComponent, DefaultWarningModalComponent, DefaultConfirmationModalComponent, DefaultErrorModalComponent],
  entryComponents: [DefaultInfoModalComponent, DefaultWarningModalComponent, DefaultConfirmationModalComponent, DefaultErrorModalComponent],
  providers: [ModalService]
})
export class BaseModalModule {
}
