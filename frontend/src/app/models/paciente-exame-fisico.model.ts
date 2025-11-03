import {
    AbdomeTipo,
    PercussaoTipo,
    PulsosTipo,
    MvfTipo,
    CorTipo
} from '../enums/exame-fisico.enum'

export interface PacienteExameFisico {
    id: string;
    dataExame: string;
    rha: boolean;
    ritmoRegular: boolean;
    taquicardico: boolean;
    tecMaiorQue2Segundos: boolean;
    semRa: boolean;
    toraxSimetrico: boolean;
    vm: boolean;
    consciente: boolean;
    semTosseVa: boolean;
    afebril: boolean;
    abdome: AbdomeTipo;
    percussao: PercussaoTipo;
    pulsos: PulsosTipo;
    mvf: MvfTipo;
    cor: CorTipo;
    parametros: string;
    edemaId: string;
    pacienteId: string;
    pacienteNome: string;
    rass: number;
    paSistolica: number;
    paDiastolica: number;
    fc: number;
    pulso: number;
    spO2: number;
    tax: number;

}