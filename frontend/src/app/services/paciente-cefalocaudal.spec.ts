import { TestBed } from '@angular/core/testing';

import { PacienteCefalocaudal } from './paciente-cefalocaudal';

describe('PacienteCefalocaudal', () => {
  let service: PacienteCefalocaudal;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PacienteCefalocaudal);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
