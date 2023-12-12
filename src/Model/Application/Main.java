package Model.Application;

import Model.Entities.ConsoleColors;

import java.util.Scanner;

import static Model.Entities.PageRank.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println(ConsoleColors.CYAN_BOLD + "-----------------------------------------------");
            System.out.println(ConsoleColors.CYAN_BOLD + "Digite " + ConsoleColors.BLUE_BRIGHT + "[1]" + ConsoleColors.CYAN_BOLD + " para visualizar a questão --> " + ConsoleColors.PURPLE_BOLD_BRIGHT + " {1} " + ConsoleColors.CYAN_BOLD + "|");
            System.out.println(ConsoleColors.CYAN_BOLD + "Digite " + ConsoleColors.BLUE_BRIGHT + "[2]" + ConsoleColors.CYAN_BOLD + " para visualizar a questão --> " + ConsoleColors.PURPLE_BOLD_BRIGHT + " {2} " + ConsoleColors.CYAN_BOLD + "|");
            System.out.println(ConsoleColors.CYAN_BOLD + "Digite " + ConsoleColors.BLUE_BRIGHT + "[3]" + ConsoleColors.CYAN_BOLD + " para visualizar a questão --> " + ConsoleColors.PURPLE_BOLD_BRIGHT + " {3} " + ConsoleColors.CYAN_BOLD + "|");
            System.out.println(ConsoleColors.CYAN_BOLD + "Digite " + ConsoleColors.BLUE_BRIGHT + "[4]" + ConsoleColors.CYAN_BOLD + " para visualizar a questão --> " + ConsoleColors.PURPLE_BOLD_BRIGHT + " {8} " + ConsoleColors.CYAN_BOLD + "|");
            System.out.println(ConsoleColors.CYAN_BOLD + "Digite " + ConsoleColors.BLUE_BRIGHT + "[5]" + ConsoleColors.CYAN_BOLD + " para --> " + ConsoleColors.PURPLE_BOLD_BRIGHT + " { Finalizar o progama } "+ ConsoleColors.CYAN_BOLD + " |");
            System.out.println(ConsoleColors.CYAN_BOLD + "-----------------------------------------------");
            System.out.print(ConsoleColors.YELLOW_BOLD_BRIGHT + "Resposta: ");

            int ops = sc.nextInt();
            switch (ops) {
                case 1:
                    System.out.println(ConsoleColors.CYAN_BOLD + "Questão 1: ");
                    int[][] A1 = {{0, 0, 1}, {1, 0, 1}, {1, 0, 1}};
                    double[] sitesAutoridade1 = calcularAutoridade(A1, 0.00001, 1000);
                    exibirAutoridade(sitesAutoridade1);
                    break;
                case 2:
                    System.out.println(ConsoleColors.CYAN_BOLD + "Questão 2: ");
                    int[][] A2 = {{0, 1, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 0}};
                    double[] sitesAutoridade2 = calcularAutoridade(A2, 0.00001, 1000);
                    exibirAutoridade(sitesAutoridade2);
                    break;
                case 3:
                    System.out.println(ConsoleColors.CYAN_BOLD + "Questão 3: ");
                    //int[][] A3 = {{0, 0, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 0}};
                    int[][] A3 = {{0, 0, 1}, {1, 0, 1}, {1, 0, 1}};
                    double[] sitesAutoridade3 = calcularAutoridade(A3, 0.00001, 1000);
                    exibirAutoridade(sitesAutoridade3);
                    break;
                case 4:
                    System.out.println(ConsoleColors.CYAN_BOLD + "Questão 8: ");
                    int[][] A4 = {
                            {0, 1, 1, 0, 1, 1, 0, 0, 0, 1}, // 1
                            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0}, // 2
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, // 3
                            {0, 1, 1, 0, 0, 1, 1, 0, 0, 1}, // 4
                            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, // 5
                            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, // 6
                            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, // 7
                            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0}, // 8
                            {0, 1, 1, 0, 0, 1, 0, 1, 0, 1}, // 9
                            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0} // 10
                    };
                    double[] sitesAutoridade4 = calcularAutoridade(A4, 0.00001, 1000);
                    exibirAutoridade(sitesAutoridade4);
                    break;
                case 5:
                    System.out.println(ConsoleColors.CYAN_BOLD + "Encerrando a aplicação.");
                    continuar = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "Opção inválida, tente novamente");
                    break;
            }
        }
    }
}
