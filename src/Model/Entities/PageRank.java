package Model.Entities;

import java.util.Arrays;

public class PageRank {

    // Calcula as pontuações de autoridade usando o algoritmo PageRank
    public static double[] calcularAutoridade(int[][] valores, double tolerancia, int numMax) {
        // Declaração das variáveis
        int n = valores.length;
        double[] autoridade = new double[n];
        Arrays.fill(autoridade, (1.0 / n)); // Inicializa o vetor de autoridade com distribuição uniforme

        double[] somaColunas = new double[n];
        for (int i = 0; i < n; i++) {
            for (int[] colunas : valores) {
                somaColunas[i] += colunas[i]; // Calcula a soma das colunas da matriz de adjacência
            }
        }

        double[] vetor;
        double[] vetorResultante;
        double[] tempUm;
        double[] tempDois;
        double[] erro;
        double[] solucao = new double[n];
        double primeiraRaiz;
        double segundaRaiz;

        // Iterações do algoritmo PageRank
        for (int iteracao = 0; iteracao < numMax; iteracao++) {
            vetor = new double[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    vetor[i] += valores[i][j] * somaColunas[j]; // Multiplica a matriz de adjacência pelo vetor de soma de colunas
                }
            }

            primeiraRaiz = 0;
            for (double val : vetor) {
                primeiraRaiz += val * val; // Calcula a primeira raiz quadrada
            }
            primeiraRaiz = Math.sqrt(primeiraRaiz);

            vetorResultante = new double[n];
            for (int i = 0; i < n; i++) {
                vetorResultante[i] = vetor[i] / primeiraRaiz; // Normaliza o vetor resultante pela primeira raiz
            }

            tempUm = new double[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    tempUm[i] += valores[j][i] * vetorResultante[j]; // Multiplica a matriz transposta pelo vetor normalizado
                }
            }

            segundaRaiz = 0;
            for (double val : tempUm) {
                segundaRaiz += val * val; // Calcula a segunda raiz quadrada
            }
            segundaRaiz = Math.sqrt(segundaRaiz);

            tempDois = new double[n];
            for (int i = 0; i < n; i++) {
                tempDois[i] = tempUm[i] / segundaRaiz; // Normaliza o vetor resultante pela segunda raiz
            }

            erro = new double[n];
            for (int i = 0; i < n; i++) {
                erro[i] = Math.abs(tempDois[i] - somaColunas[i]); // Calcula o vetor de erro
            }

            // Verifica a convergência
            if (Arrays.stream(erro).max().orElse(0) <= tolerancia) {
                solucao = Arrays.copyOf(tempDois, n);
                break;
            } else {
                somaColunas = Arrays.copyOf(tempDois, n);
            }
        }
        return solucao;
    }

    // Exibe as pontuações de autoridade em ordem decrescente
    public static void exibirAutoridade(double[] sitesAutoridade) {
        int n = sitesAutoridade.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i + 1;
        }

        // Ordena os índices com base nas pontuações de autoridade
        Arrays.sort(indices, (i, j) -> Double.compare(sitesAutoridade[j - 1], sitesAutoridade[i - 1]));

        System.out.println(ConsoleColors.CYAN_BOLD + "Sites em ordem de autoridade:");
        for (int i = 0; i < n; i++) {
            System.out.printf(ConsoleColors.BLUE_BRIGHT + "Site %d: %.5f\n", indices[i], sitesAutoridade[indices[i] - 1]);
        }
    }
}
