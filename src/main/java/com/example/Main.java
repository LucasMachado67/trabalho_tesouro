package com.example;

import java.util.Scanner;

import com.example.matrizes.MatrizTesouros;
import com.example.matrizes.MatrizUsuario;
import com.example.pontuacao.Pontuacao;


public class Main {
    public static void main(String[] args) {
        

        MatrizTesouros matrizTesouros = new MatrizTesouros();
        MatrizUsuario matrizUsuario = new MatrizUsuario();
        Pontuacao total = new Pontuacao();
        matrizTesouros.preencherMatriz();
        matrizUsuario.preencherMatrizUsuario();


        Scanner scan = new Scanner(System.in);
        boolean sair = false;

        int totalEscavacoes = 0;
        int totalTesouros = 0 ;

        int linha = 0;
        int coluna = 0;
        do {


            //pede a coordenada da linha para o usuário
            while (true) {
                System.out.println("Digite a linha entre 1 e 8:");
                //Verifca se o que foi digitado é um número, para não parar o programa
                if (scan.hasNextInt()) {
                    //Pede ao usuário digitar a linha
                    linha = scan.nextInt();
                    if (linha >= 1 && linha <= 8) {//Validando a posição
                        break; // força a saída do while para seguir com o código
                    } else {
                        System.out.println("Erro, coordenada da linha fora do intervalo.");
                    }
                } else {
                    System.out.println("Erro, digite apenas números.");
                    scan.next();
                }
            }


            //pede a coordenada da coluna para o usuário
            while (true) {
                System.out.println("Digite a coluna entre 1 e 8:");
                //valida se é número
                if (scan.hasNextInt()) {
                    coluna = scan.nextInt();
                    if (coluna >= 1 && coluna <= 8) {//Validando a posição
                        break; // força a saída do while para seguir com o código
                    } else {
                        System.out.println("Erro, coordenada da coluna fora do intervalo.");
                    }
                } else {
                    System.out.println("Erro, digite apenas números.");
                    scan.next();
                }
            }


            if (matrizUsuario.matriz[linha][coluna] == 'T' || matrizUsuario.matriz[linha][coluna] == 'A' || matrizUsuario.matriz[linha][coluna] == 'O') {
                System.out.println("Coordenada já escavada!"); 
             } else{
                matrizUsuario.matriz[linha][coluna] = matrizTesouros.tesouros[linha][coluna];
                totalEscavacoes += 1;

                if (matrizUsuario.matriz[linha][coluna] == 'T') {
                    total.adicionaDez();
                    System.out.println("ACHOU UM TESOURO!");
                    totalTesouros += 1;

                }else if (matrizUsuario.matriz[linha][coluna] == 'A') {
                    total.subtrairCinco();
                    System.out.println("CAIU EM UMA ARMADILHA!");
                }else{
                    System.out.println("Nada encontrado");
                }

                System.out.println("PONTUAÇÃO ATUAL: " + total.pontuacao);
                matrizUsuario.mostrarMatriz();
             }

             if (totalTesouros == 8 ) {
                total.resultadoFinal(total.pontuacao);
                System.out.println();
                System.out.println();
                System.out.println(total.resultado);
                System.out.println();
                System.out.println();
                System.out.println("-------Mapa do Tesouro--------");
                matrizTesouros.mostrarTesouros();
                sair = true;
             }
            if (totalEscavacoes == 25) {
                total.resultadoFinal(total.pontuacao);
                System.out.println();
                System.out.println();
                System.out.println(total.resultado);
                System.out.println();
                System.out.println();
                System.out.println("-------Mapa do Tesouro--------");
                matrizTesouros.mostrarTesouros();
                sair = true;
             }
             
        } while (sair == false);

        scan.close();
    }
}