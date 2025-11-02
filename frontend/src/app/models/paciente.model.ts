export interface Paciente {
    id: string;
    nome: string;
    status: 'in_treatment' | 'recovery' | 'admitted' | 'discharged';
    ses: string;
    peso: number;
}
