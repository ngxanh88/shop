import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {DefaultWarningModalComponent} from './warning-modal.component';
import {FormsModule} from '@angular/forms';
import {NgbActiveModal, NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import {SharedPipesModule} from '../../..';

describe('DefaultWarningModalComponent', () => {
  let component: DefaultWarningModalComponent;
  let fixture: ComponentFixture<DefaultWarningModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,
        SharedPipesModule,
        NgbModalModule
      ],
      declarations: [ DefaultWarningModalComponent ],
      providers: [
        NgbActiveModal
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DefaultWarningModalComponent);
    component = fixture.componentInstance;
    component.setData({title: '', message: ''});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
