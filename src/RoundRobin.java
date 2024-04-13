import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class RoundRobin {
    public static void main(String[] args) {

        List<Processo> processos = new ArrayList<>();

        processos.add(new Processo(1, 0, 10));
        processos.add(new Processo(2, 0, 5));
        processos.add(new Processo(3, 0, 8));

        int quantum = 2;

        // Executando o algoritmo de Round Robin
        roundRobin(processos, quantum);

        // Calculando as métricas
        calcularMetricas(processos);
    }

    public static void roundRobin(List<Processo> processos, int quantum) {
        int tempo = 0;

        Queue<Processo> fila = new LinkedList<>(processos);

        while (!fila.isEmpty()) {
            Processo processoAtual = fila.poll(); // pega o 1º processo da fila e joga dentro da 'processoAtual' e em seguida remove ele de 'fila'
            if (processoAtual.tempoRestante > quantum) {
                tempo += quantum;
                processoAtual.tempoRestante -= quantum;
                fila.add(processoAtual); // 'processoAtual' entra na fila novamente, mas no fim da fila
            } else {
                tempo += processoAtual.tempoRestante;
                processoAtual.turnaround = tempo - processoAtual.tempoDeChegada;
                processoAtual.tempoRestante = 0;
            }
        }
    }

    public static void calcularMetricas(List<Processo> processos) {
        double tempoDeEsperaTotal = 0;
        double turnarountTotal = 0;
        double tempoDeProcessamentoTotal = 0;
        
        System.out.println("Processo\tTempo de Espera\tTurnaround Time");
        
        for (Processo process : processos) {
            process.tempoDeEspera = process.turnaround - process.tempoDeProcessador;
            tempoDeEsperaTotal += process.tempoDeEspera;
            turnarountTotal += process.turnaround;
            tempoDeProcessamentoTotal += process.tempoDeProcessador;

            System.out.println(process.id + "\t\t" + process.tempoDeEspera + "\t\t\t" + process.turnaround);
        }
        
        double tempoDeEsperaMedio = tempoDeEsperaTotal / processos.size();
        double turnaroundMedio = turnarountTotal / processos.size();
        double usoDoProcessador = tempoDeProcessamentoTotal / turnarountTotal * 100;
        
        System.out.println("\nTempo médio de espera: " + tempoDeEsperaMedio);
        System.out.println("Tempo médio de turnaround: " + turnaroundMedio);
        System.out.println("Tempo total de processador: " + tempoDeProcessamentoTotal);
        System.out.println("Utilização do processador: " + usoDoProcessador + "%");
    }
}
