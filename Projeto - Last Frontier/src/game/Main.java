package game;

import mensagensDisplay.MensagensIniciais;
import gerenciadores.GerenciadorDePersonagens;

public class Main {
    public static void main(String[] args) {

        MensagensIniciais display = new MensagensIniciais();

        display.mensagensLoreIntroducao();
        display.sleep(3000);
        new java.util.Scanner(System.in).nextLine();

        GerenciadorDePersonagens gerenciadorDePersonagens = new GerenciadorDePersonagens();

        gerenciadorDePersonagens.mostrarPersonagens();
        gerenciadorDePersonagens.escolherPersonagens();

    }
}
