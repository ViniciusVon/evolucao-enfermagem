import { TestBed } from '@angular/core/testing';

import { PacienteDispositivo } from '../models/paciente-dispositivo.model';

describe('PacienteDispositivos', () => {
  let service: PacienteDispositivo;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PacienteDispositivo);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
