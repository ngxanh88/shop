import {Component} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {AModalComponent, DefaultModalModel} from '../../../base';

@Component({
  selector: 'app-error-modal',
  templateUrl: './error-modal.component.html',
  styleUrls: ['./error-modal.component.css']
})
export class DefaultErrorModalComponent extends AModalComponent<DefaultModalModel, boolean> {

  modalData: DefaultModalModel;

  constructor(protected activeModal: NgbActiveModal) {
    super(activeModal);
  }

  setData(data: DefaultModalModel): void {
    this.modalData = data;
  }
}
