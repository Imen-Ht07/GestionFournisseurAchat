import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLigneAchatComponent } from './add-ligne-achat.component';

describe('AddLigneAchatComponent', () => {
  let component: AddLigneAchatComponent;
  let fixture: ComponentFixture<AddLigneAchatComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddLigneAchatComponent]
    });
    fixture = TestBed.createComponent(AddLigneAchatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
