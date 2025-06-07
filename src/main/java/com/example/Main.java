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

        do {
            
            System.out.println("Digite a linha entre 1 e 8");
            int linha = scan.nextInt();
            while (linha < 1 || linha > 8) {
                System.out.println("Erro, coordenada da linha errada");
                System.out.println("Digite a linha entre 1 e 8");
                linha = scan.nextInt();
            }

            System.out.println("Digite a coluna entre 1 e 8");
            int coluna = scan.nextInt();
            while (coluna < 1 || coluna > 8 ) {
                System.out.println("Erro, coordenada da coluna errada");
                System.out.println("Digite a coluna entre 1 e 8");
                coluna = scan.nextInt();
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
             }else if (totalEscavacoes == 25) {
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