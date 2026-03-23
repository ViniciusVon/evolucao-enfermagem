export interface Paciente {
    id: string;
    nome: string;
    altura: number;
    idade: number;
    status: 'in_treatment' | 'recovery' | 'admitted' | 'discharged';
    ses: string;
    peso: number;
}
