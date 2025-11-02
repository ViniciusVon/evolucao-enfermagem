import { TestBed } from '@angular/core/testing';

import { PacienteHpp } from './paciente-hpp';

describe('PacienteHpp', () => {
  let service: PacienteHpp;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PacienteHpp);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
