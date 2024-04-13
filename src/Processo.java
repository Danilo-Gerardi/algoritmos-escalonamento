class Processo {
    int id;
    int tempoDeChegada;
    int tempoDeProcessador;
    int tempoDeEspera;
    int turnaround;
    int tempoRestante;

    Processo(int id, int tempoDeEspera, int tempoDeProcessador) {
        this.id = id;
        this.tempoDeChegada = tempoDeEspera;
        this.tempoDeProcessador = tempoDeProcessador;
        this.tempoDeEspera = 0;
        this.turnaround = 0;
        this.tempoRestante = tempoDeProcessador;
    }
}

