export function getInitials(nome: string): string {
    if (!nome) return '?';
    const partes = nome.trim().split(' ').filter(p => p.length > 0);
    if (partes.length === 1) return partes[0][0].toUpperCase();
    return (partes[0][0] + partes[partes.length - 1][0]).toUpperCase();
}

export function getStatusLabel(status: string): string {
    switch (status) {
        case 'in_treatment': return 'Em tratamento';
        case 'recovery':     return 'Em recuperação';
        case 'admitted':     return 'Internado';
        case 'discharged':   return 'Alta';
        default:             return 'Desconhecido';
    }
}

export function getStatusSeverity(status: string): 'success' | 'secondary' | 'info' | 'warn' | 'danger' | 'contrast' {
    switch (status) {
        case 'in_treatment': return 'warn';
        case 'recovery':     return 'success';
        case 'admitted':     return 'info';
        case 'discharged':   return 'secondary';
        default:             return 'contrast';
    }
}