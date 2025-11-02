export interface PacienteHpp {
    id: string;
    has: boolean;
    dm: boolean;
    dopc: boolean;
    icc: boolean;
    dac: boolean;
    ave: boolean;
    alergico: boolean;
    outrasComorbidades: string;
    medicamentosUsoContinuo: string;
    pacienteId: string;
    pacienteNome: string;
}