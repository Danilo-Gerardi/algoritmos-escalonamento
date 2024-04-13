class Processo {
    int id;
    int tempoDeChegada;
    int tempoDeProcessador;
    int tempoDeEspera;
    int turnaround;
    int tempoRestante;

    Processo(int id, int arrivalTime, int burstTime) {
        this.id = id;
        this.tempoDeChegada = arrivalTime;
        this.tempoDeProcessador = burstTime;
        this.tempoDeEspera = 0;
        this.turnaround = 0;
        this.tempoRestante = burstTime;
    }
}

