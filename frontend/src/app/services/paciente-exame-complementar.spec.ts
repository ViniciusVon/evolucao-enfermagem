import { TestBed } from '@angular/core/testing';

import { PacienteExameComplementar } from './paciente-exame-complementar';

describe('PacienteExameComplementar', () => {
  let service: PacienteExameComplementar;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PacienteExameComplementar);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
