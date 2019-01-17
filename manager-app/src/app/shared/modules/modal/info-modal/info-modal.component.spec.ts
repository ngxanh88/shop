import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {DefaultInfoModalComponent} from './info-modal.component';
import {FormsModule} from '@angular/forms';
import {NgbActiveModal, NgbModalModule} from '@ng-bootstrap/ng-bootstrap';
import {SharedPipesModule} from '../../..';

describe('DefaultInfoModalComponent', () => {
  let component: DefaultInfoModalComponent;
  let fixture: ComponentFixture<DefaultInfoModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        FormsModule,
        SharedPipesModule,
        NgbModalModule
      ],
      declarations: [ DefaultInfoModalComponent ],
      providers: [
        NgbActiveModal
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DefaultInfoModalComponent);
    component = fixture.componentInstance;
    component.setData({title: '', message: ''});
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
