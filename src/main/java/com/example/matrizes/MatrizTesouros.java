package com.example.matrizes;

import java.util.Random;

public class MatrizTesouros {
    

    public char[][] tesouros = new char[9][9];

    public int quantidadeTesouros = 8;
    Random random = new Random();

    public char[][] preencherMatriz() {

        // Aqui estamos preenchendo o cabeçalho para o usuário se localizar na matriz
        for (int i = 1; i < 9; i++) {
            tesouros[0][i] = (char) ('1' + i - 1); 
            tesouros[i][0] = (char) ('1' + i - 1); 
        }
        tesouros[0][0] = ' ';

        // Preencher com '-'
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                tesouros[i][j] = 'O';
            }
        }

        //Chamando o método colocarSimbolos
        colocarSimbolos(tesouros, 'T', 8, random);
        colocarSimbolos(tesouros, 'A', 5, random);

        // Exibindo a matriz com os valores finais - não mostrar para o usuário
        // for (int i = 0; i < 9; i++) {
        //     for (int j = 0; j < 9; j++) {
        //         System.out.print(tesouros[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return tesouros;
    }
    //Método que coloca os caracteres aleátorios dentro da matriz
    public static void colocarSimbolos(char[][] mapa, char simbolo, int quantidade, Random random) {
        int colocados = 0;
        while (colocados < quantidade) {
            int linha = 1 + random.nextInt(8); 
            int coluna = 1 + random.nextInt(8); 

            if (mapa[linha][coluna] == 'O') {
                mapa[linha][coluna] = simbolo;
                colocados++;
            }
        }
    }

}
