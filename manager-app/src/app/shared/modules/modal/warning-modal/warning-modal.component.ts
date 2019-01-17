import {Component, ViewEncapsulation} from '@angular/core';

import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {AModalComponent, DefaultModalModel} from '../../../base';

@Component({
  selector: 'app-warning-modal',
  templateUrl: './warning-modal.component.html',
  styleUrls: ['./warning-modal.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class DefaultWarningModalComponent extends AModalComponent<DefaultModalModel, boolean> {

  modalData: DefaultModalModel;

  constructor(protected activeModal: NgbActiveModal) {
    super(activeModal);
  }

  setData(data: DefaultModalModel): void {
    this.modalData = data;
  }

}
