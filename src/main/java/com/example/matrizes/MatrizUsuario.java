package com.example.matrizes;

public class MatrizUsuario {

    public char[][] matriz = new char[9][9];

    //Constroi a matriz padrão para o usuário
    public char[][] preencherMatrizUsuario(){
        //Colando as coordenadas nas bordas da matriz
        for (int i = 1; i < 9; i++) {
            matriz[0][i] = (char) ('1' + i - 1); 
            matriz[i][0] = (char) ('1' + i - 1); 
        }
        matriz[0][0] = ' ';

        // Preencher com '~'
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                matriz[i][j] = '~';
            }
        }
        //Exibe a matriz na tela a matriz pela primeira vez
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        return matriz;
    }

    //Exibe a matriz para o usuário
    public void mostrarMatriz(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
