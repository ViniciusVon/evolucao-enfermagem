import { TestBed } from '@angular/core/testing';

import { PacienteExameFisico } from './paciente-exame-fisico';

describe('PacienteExameFisico', () => {
  let service: PacienteExameFisico;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PacienteExameFisico);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
