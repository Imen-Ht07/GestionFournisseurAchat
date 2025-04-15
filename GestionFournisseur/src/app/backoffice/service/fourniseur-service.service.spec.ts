import { TestBed } from '@angular/core/testing';

import { FourniseurServiceService } from './fourniseur-service.service';

describe('FourniseurServiceService', () => {
  let service: FourniseurServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FourniseurServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
