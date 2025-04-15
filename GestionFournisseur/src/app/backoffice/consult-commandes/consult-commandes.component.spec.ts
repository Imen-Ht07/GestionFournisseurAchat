import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultCommandesComponent } from './consult-commandes.component';

describe('ConsultCommandesComponent', () => {
  let component: ConsultCommandesComponent;
  let fixture: ComponentFixture<ConsultCommandesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ConsultCommandesComponent]
    });
    fixture = TestBed.createComponent(ConsultCommandesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
