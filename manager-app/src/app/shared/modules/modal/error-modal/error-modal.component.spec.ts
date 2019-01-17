import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {DefaultErrorModalComponent} from './error-modal.component';
import {NgbActiveModal, NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule} from '@angular/forms';
import {SharedPipesModule} from '../../..';

describe('DefaultErrorModalComponent', () => {
  let component: DefaultErrorModalComponent;
  let fixture: ComponentFixture<DefaultErrorModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,
        SharedPipesModule,
        NgbModalModule
      ],
      declarations: [ DefaultErrorModalComponent ],
      providers: [
        NgbActiveModal
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DefaultErrorModalComponent);
    component = fixture.componentInstance;
    component.setData({title: '', message: ''});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
