import { TestBed } from '@angular/core/testing';

import { PacienteEvolucaoEnfermagem } from './paciente-evolucao-enfermagem';

describe('PacienteEvolucaoEnfermagem', () => {
  let service: PacienteEvolucaoEnfermagem;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PacienteEvolucaoEnfermagem);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
