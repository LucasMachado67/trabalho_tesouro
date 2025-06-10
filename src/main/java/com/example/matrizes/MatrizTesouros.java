package com.example.matrizes;

import java.util.Random;

public class MatrizTesouros {
    

    public char[][] tesouros = new char[9][9];

    Random random = new Random();

    //Método para prencher a matriz em ordem aleatória
    public char[][] preencherMatriz() {

        // Aqui estamos preenchendo o cabeçalho para o usuário se localizar na matriz
        //a partir das linhas e colunas
        for (int i = 1; i < 9; i++) {
            tesouros[0][i] = (char) ('1' + i - 1); 
            tesouros[i][0] = (char) ('1' + i - 1); 
        }
        //Setando a posição 0,0 como vazio
        tesouros[0][0] = ' ';

        // Preencher espaços em branco com 'O'
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                tesouros[i][j] = 'O';
            }
        }

        //Chamando o método colocarSimbolos para Tesouros e Armadilhas
        colocarSimbolos(tesouros, 'T', 8, random);
        colocarSimbolos(tesouros, 'A', 5, random);

        //Retorno da Matriz
        return tesouros;
    }
    //Método que coloca os caracteres aleátorios dentro da matriz
    //e é chamado no método preencherMatriz()
    public static void colocarSimbolos(char[][] mapa, char simbolo, int quantidade, Random random) {
        //Verifica quantos simbolos já foram colocados
        int colocados = 0;
        //Enquanto colocados for menor que a quantidade definida no parâmetro ele continuará executando
        while (colocados < quantidade) {
            //Gerando a posição aleatória da matriz
            //respeitando os limites da matriz
            int linha = 1 + random.nextInt(8); 
            int coluna = 1 + random.nextInt(8); 
            //Validando para não sobrepor em tesouros ou armadilhas já colocados
            if (mapa[linha][coluna] == 'O') {
                mapa[linha][coluna] = simbolo;
                colocados++;
            }
        }
    }
    //Mostra a matriz ao usuário quando o jogo acaba
    public void mostrarTesouros(){
        //Imprime as informações de cada posição
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tesouros[i][j] + " ");
            }
            System.out.println();
        }
    }

}
