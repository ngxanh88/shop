import {Component} from '@angular/core';

import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {AModalComponent, DefaultModalModel} from '../../../base';

@Component({
  selector: 'app-info-modal',
  templateUrl: './info-modal.component.html',
  styleUrls: ['./info-modal.component.css']
})
export class DefaultInfoModalComponent extends AModalComponent<DefaultModalModel, boolean> {

  modalData: DefaultModalModel;
  constructor(protected activeModal: NgbActiveModal) {
    super(activeModal);
  }

  setData(data: DefaultModalModel): void {
    this.modalData = data;
  }

}
