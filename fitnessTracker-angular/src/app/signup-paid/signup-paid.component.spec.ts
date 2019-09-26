import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupPaidComponent } from './signup-paid.component';

describe('SignupPaidComponent', () => {
  let component: SignupPaidComponent;
  let fixture: ComponentFixture<SignupPaidComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SignupPaidComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupPaidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
