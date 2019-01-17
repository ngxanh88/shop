import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {DefaultConfirmationModalComponent} from './confirmation-modal.component';
import {FormsModule} from '@angular/forms';
import {NgbActiveModal, NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import {SharedPipesModule} from '../../..';

describe('DefaultConfirmationModalComponent', () => {
  let component: DefaultConfirmationModalComponent;
  let fixture: ComponentFixture<DefaultConfirmationModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,
        SharedPipesModule,
        NgbModalModule
      ],
      declarations: [ DefaultConfirmationModalComponent ],
      providers: [
        NgbActiveModal
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DefaultConfirmationModalComponent);
    component = fixture.componentInstance;
    component.setData({title: '', message: '', yesNoOptions: ['Ja', 'Nein']});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
