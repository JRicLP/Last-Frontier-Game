package game;

import MensagensDisplay.Mensagens;
import ambientes.*;
import gerenciadores.GerenciadorDeAmbientes;
import inventario.Inventario;
import itens.*;
import gerenciadores.GerenciadorDePersonagens;
import personagens.Personagem;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Mensagens display = new Mensagens();

        display.displayLoreIntro();
        display.sleep(3000);
        new java.util.Scanner(System.in).nextLine();

        GerenciadorDePersonagens gerenciadorDePersonagens = new GerenciadorDePersonagens();

        gerenciadorDePersonagens.mostrarPersonagem();
    }
}
