import {Injectable, Type} from '@angular/core';
import {NgbModal, NgbModalOptions, NgbModalRef} from '@ng-bootstrap/ng-bootstrap';
import {ActiveToast, ToastrService} from 'ngx-toastr';
import {IndividualConfig} from 'ngx-toastr/toastr/toastr-config';
import {AModalComponent, DefaultModalModel, IModalModel} from '../base';
import {DefaultErrorModalComponent} from '../modules/modal/error-modal/error-modal.component';
import {DefaultWarningModalComponent} from '../modules/modal/warning-modal/warning-modal.component';
import {DefaultInfoModalComponent} from '../modules/modal/info-modal/info-modal.component';
import {DefaultConfirmationModalComponent, DefaultConfirmModel} from '../modules/modal/confirmation-modal/confirmation-modal.component';

@Injectable()
export class ModalService {
  private toastrDefaultConfig: Partial<IndividualConfig> = {
    closeButton: false,
    timeOut: 5000,
    extendedTimeOut: 1000,
    disableTimeOut: false,
    enableHtml: true,
    tapToDismiss: true
  };

  constructor(private toastService: ToastrService, private modalService: NgbModal) { }

  public openModal<T extends IModalModel, R>(modalComponent: Type<AModalComponent<T, R>>, modalModel?: T, options?: NgbModalOptions): NgbModalRef {
    if (!options) {
      options = this.defaultOption();
    }
    const modalRef = this.modalService.open(modalComponent, options);
    modalRef.componentInstance.setData(modalModel);

    return modalRef;
  }

  public open<T extends IModalModel, R>(modalComponent: Type<AModalComponent<T, R>>, modalModel?: T, options?: NgbModalOptions): Promise<any> {
    const modalResult = this.openModal(modalComponent, modalModel, options).result;
    return new Promise((resolve) => modalResult.then(
      (data) => resolve(data),
      () => { /** ignore reject because that return nothing */}
    ));
    // return this.openModal(modalComponent, modalModel, options).result;
  }

  public openConfirmModal(modalModel: DefaultConfirmModel, options?: NgbModalOptions): Promise<any> {
    return this.open(DefaultConfirmationModalComponent, modalModel, options);
  }

  public openInfoModal(modalModel: DefaultModalModel, options?: NgbModalOptions): Promise<any> {
    return this.open(DefaultInfoModalComponent, modalModel, options);
  }

  public openWarningModal(modalModel: DefaultModalModel, options?: NgbModalOptions): Promise<any> {
    return this.open(DefaultWarningModalComponent, modalModel, options);
  }

  public openErrorModal(modalModel: DefaultModalModel, options?: NgbModalOptions): Promise<any> {
    return this.open(DefaultErrorModalComponent, modalModel, options);
  }

  public toastSuccess(message: string, title?: string): ActiveToast<any> {
    return this.toastService.success(message, title, this.toastrDefaultConfig);
  }

  public toastInfo(message: string, title?: string): ActiveToast<any> {
    return this.toastService.info(message, title, this.toastrDefaultConfig);
  }

  public toastWarning(message: string, title?: string): ActiveToast<any> {
    return this.toastService.warning(message, title, this.toastrDefaultConfig);
  }

  public toastError(message: string, title?: string): ActiveToast<any> {
    const toastrErrorConfig = Object.assign({}, this.toastrDefaultConfig);
    toastrErrorConfig.tapToDismiss = false;
    toastrErrorConfig.disableTimeOut = true;
    toastrErrorConfig.closeButton = true;

    return this.toastService.error(message, title, toastrErrorConfig);
  }

  private defaultOption(): NgbModalOptions {
    const  defaultOptions = {};
    defaultOptions['backdrop'] = 'static';
    defaultOptions['keyboard'] = 'false';
    return defaultOptions;
  }
}
