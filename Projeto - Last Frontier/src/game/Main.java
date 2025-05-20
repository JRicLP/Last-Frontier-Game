package game;

import ambientes.Ambientes;
import gerenciadores.GerenciadorDeAmbientes;
import mensagensDisplay.CondicaoDeVitoriaDerrota;
import mensagensDisplay.MensagensIniciais;
import gerenciadores.GerenciadorDePersonagens;
import personagens.Personagem;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MensagensIniciais display = new MensagensIniciais();
        CondicaoDeVitoriaDerrota display2= new CondicaoDeVitoriaDerrota();

        display.displayLoreIntro();
        display.sleep(3000);
        new java.util.Scanner(System.in).nextLine();

        display2.condicaoDisplay();
        new java.util.Scanner(System.in).nextLine();

        GerenciadorDePersonagens gerenciadorDePersonagens = new GerenciadorDePersonagens();

        gerenciadorDePersonagens.mostrarPersonagens();
        gerenciadorDePersonagens.escolherPersonagens();

        GerenciadorDeAmbientes gerenciadorDeAmbientes= new GerenciadorDeAmbientes(new ArrayList<>(), "Indefinido", new ArrayList<>());
        gerenciadorDeAmbientes.gerarAmbientes();
        System.out.println("Ambientes disponíveis:");
        for (Ambientes ambiente : gerenciadorDeAmbientes.getListaAmbientesDisponiveis()) {
            System.out.println("- " + ambiente.getNomeAmbiente() + ": " + ambiente.getDescricaoAmbiente());
        }


        while(true){



            //Verifica se o personagem morreu
            Personagem personagem= gerenciadorDePersonagens.getPersonagem();
            if(personagem.getVidaPersonagem()==0 || personagem.getFomePersonagem()==0 || personagem.getSedePersonagem()==0){
                if(personagem.getVidaPersonagem()==0) {
                    System.out.println("Sua vida chegou a 0!");
                    System.out.println(" Você MORREU e perdeu o jogo!");
                    break;
                }

                else if (personagem.getFomePersonagem()==0){
                    System.out.println(" Você está com desnutrição! Seus pontos de fome chegaram a 0");
                    System.out.println(" Você MORREU e perdeu o jogo!");
                    break;
                }
                else{
                    System.out.println(" Você está desidratado! Seus pontos de sede chegaram a 0");
                    System.out.println(" Você MORREU e perdeu o jogo!");
                    break;
                }
            }
        }
    }

}