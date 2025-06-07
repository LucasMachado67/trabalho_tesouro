package com.example.pontuacao;

public class Pontuacao {

    public int pontuacao;
    public String resultado;

    public int adicionaDez(){
        this.pontuacao += 10;
        return pontuacao;
    }

    public int subtrairCinco(){
        this.pontuacao -= 5;
        return pontuacao;
    }

    public void resultadoFinal(int pontos){
        
        if (pontos >= 70) {
            System.out.println("Explorador Lendário!");
            this.resultado = "Você Venceu!";
        }else if (pontos >= 50 && pontos <= 69 ) {
            System.out.println("Caçador de Tesouros Experiente!");
            this.resultado = "VOCÊ VENCEU!!!!!!!!!!!";
        }else if (pontos >= 30 && pontos <= 49) {
            System.out.println("Aventureiro Iniciante");
            this.resultado = "Você Venceu!";
        }else {
            System.out.println("Precisa de mais prática na exploração");
            this.resultado = "Você foi derrotado!";
        }
    }

    

}
