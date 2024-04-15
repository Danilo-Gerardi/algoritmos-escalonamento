import java.util.*;

public class ShortestJobFirst {

    static int tempoTotalDeProcessador;
    public static void main(String[] args) {

        List<Processo> processos = new ArrayList<>();

        processos.add(new Processo(1, 0, 6));
        processos.add(new Processo(2, 0, 1));
        processos.add(new Processo(3, 0, 3));
        processos.add(new Processo(4, 0, 8));
        processos.add(new Processo(5, 0, 4));
        processos.add(new Processo(6, 0, 8));


        // Executando o algoritmo ShortestJobFirst
        shortestJobFirst(processos);

        // Calculando as métricas
        calcularMetricas(processos);
    }

    public static void shortestJobFirst(List<Processo> processos) {
        processos.sort(Comparator.comparingInt(p -> p.tempoDeProcessador));

        int time = 0;

        for (Processo p : processos) {
            p.tempoDeEspera = time - p.tempoDeChegada;
            p.turnaround = p.tempoDeEspera + p.tempoDeProcessador;
            time += p.tempoDeProcessador;
        }

        tempoTotalDeProcessador = time;
    }

    public static void calcularMetricas(List<Processo> processos) {

        double totaltempoDeEspera = 0;
        double turnaroundTotal = 0;

        System.out.println("Processo\tTempo de Espera\tTempo de Turnaround");

        for (Processo p : processos) {
            totaltempoDeEspera += p.tempoDeEspera;
            turnaroundTotal += p.turnaround;
            System.out.println(p.id + "\t\t" + p.tempoDeEspera + "\t\t\t" + p.turnaround);
        }

        double tempoDeEsperaMedio = totaltempoDeEspera / processos.size();
        double turnaroundMedio = turnaroundTotal / processos.size();

        System.out.println("\nTempo médio de espera: " + tempoDeEsperaMedio);
        System.out.println("Tempo médio de retorno: " + turnaroundMedio);
        System.out.println("Tempo total de processador : " + tempoTotalDeProcessador);

    }
}