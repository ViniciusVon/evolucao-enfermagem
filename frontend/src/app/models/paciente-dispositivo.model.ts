export interface PacienteDispositivo {
    id: string;
    tipoDispositivoEnum: string;
    isUtilizado: boolean;
    dataInstalacao: string;
    pacienteId: string;
    pacienteNome: string;
    local: string;
    curativo: string;
    isAbertaDrenagem: boolean;
    isEmUso: boolean;
    calibre: string;
    modo: string;
    vc: string;
    peep: string;
    fr: string;
    fiO2: number;
}