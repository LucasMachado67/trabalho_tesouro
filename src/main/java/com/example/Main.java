package com.example;

import java.util.Scanner;

import com.example.matrizes.MatrizTesouros;
import com.example.matrizes.MatrizUsuario;
import com.example.pontuacao.Pontuacao;


public class Main {
    public static void main(String[] args) {
        
        // Instanciação das classes criadas
        MatrizTesouros matrizTesouros = new MatrizTesouros();
        MatrizUsuario matrizUsuario = new MatrizUsuario();
        Pontuacao total = new Pontuacao();
        Scanner scan = new Scanner(System.in);

        // Chamada de metodos para inicializar as matrizes
        matrizTesouros.preencherMatriz();
        matrizUsuario.preencherMatrizUsuario();

        // Variaveis auxiliares globais 
        boolean sair = false;
        int totalEscavacoes = 0;
        int totalTesouros = 0 ;
        int linha = 0;
        int coluna = 0;

        // Entrada no do while 
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

            //Verifica se a possição já foi escavada 
            if (matrizUsuario.matriz[linha][coluna] == 'T' || 
            matrizUsuario.matriz[linha][coluna] == 'A' || 
            matrizUsuario.matriz[linha][coluna] == 'O') {
                System.out.println("Coordenada já escavada!"); 
             } else{ // Se não foi escavada segue o código

                // Pegando o conteudo da posição da matriz tesouro e colocando na matriz usuario
                matrizUsuario.matriz[linha][coluna] = matrizTesouros.tesouros[linha][coluna];
                totalEscavacoes += 1;

                // Verificando se for um tesouro
                if (matrizUsuario.matriz[linha][coluna] == 'T') {
                    // Chama o metodo adicionarDez
                    total.adicionaDez();
                    System.out.println("ACHOU UM TESOURO!");
                    totalTesouros += 1;

                    // Verefica se caiu em uma armadilha
                }else if (matrizUsuario.matriz[linha][coluna] == 'A') {
                    // Chama o metedo subtraiCinco
                    total.subtrairCinco();
                    System.out.println("CAIU EM UMA ARMADILHA!");
                }else{

                    // Caso não seja nem T e nem A nada encontrado
                    System.out.println("Nada encontrado");
                }
                // Exibindo a pontuação atual do usuario
                System.out.println("PONTUAÇÃO ATUAL: " + total.pontuacao);
                // Exindo a matrizUsuario atualizada
                matrizUsuario.mostrarMatriz();
             }

             // Se todos os tesouros foram encontrados
             if (totalTesouros == 8 ) {
                // Calculando o resultado final 
                total.resultadoFinal(total.pontuacao);
                System.out.println();
                System.out.println();
                // Exibindo o resultado final 
                System.out.println(total.resultado);
                System.out.println();
                System.out.println();
                System.out.println("-------Mapa do Tesouro--------");
                // Mostrando a matrizTesouro
                matrizTesouros.mostrarTesouros();
                // Colocando a variavel sair = true para forçar a saida do while
                sair = true;
             }

             // Verificando o total de escavações feitas
            if (totalEscavacoes == 25) {
                // Calculando o resultado final
                total.resultadoFinal(total.pontuacao);
                System.out.println();
                System.out.println();
                // Exibindo o resultado final
                System.out.println(total.resultado);
                System.out.println();
                System.out.println();
                System.out.println("-------Mapa do Tesouro--------");
                // Monstrando a matrizTesouro
                matrizTesouros.mostrarTesouros();
                // Colocando a variavel sair = true para forçar a saida do while
                sair = true;
             }
             
        } while (sair == false); // Enquanto for falso repete o do while inteiro 

        scan.close();// Fecha scanner
    }
}