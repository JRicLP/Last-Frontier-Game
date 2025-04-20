package game;

import ambientes.AmbienteFloresta;
import ambientes.AmbienteMontanha;
import gerenciadores.GerenciadorDeAmbientes;
import itens.Agua;
import gerenciadores.GerenciadorDePersonagens;
import personagens.Personagem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(" -------------------------------------------------------------------------------------");
        System.out.println("                                  A Última Fronteira");
        System.out.println("--------------------------------------------------------------------------------------");

        AmbienteFloresta florestaRasa = new AmbienteFloresta("Floresta Rasa","Uma floresta espaçosa com " +
                "grande presença de arbustos e gramíneas, mas pouca árvores. A exposição ao sol aqui é maior e possui menor disponibilidade de água",
                0.2,"Madeira, Rocha, Agua, Frutas", 0.4, "Ensolarado brando", "A vegetação é mais rasa nesse local",
                "Há grande presença de roedores, aves e rastejantes", "As chuvas são um pouco escassas aqui");

        AmbienteMontanha monteCongelante = new AmbienteMontanha("Monte Congelante", "Uma montanha fria e esbranquiçada pelas fortes nevascas que acontecem",
                0.7, "Rochas, Minérios, Água congelada", 0.4, "Neve branda e contínua",
                "O terreno é íngrime e apresenta rochas soltas.", "O clima aqui é instável, pode nevar muito em pouco tempo", "Quase não há plantas aqui devido ao frio");

        Scanner usuario=new Scanner(System.in);
        System.out.println("Opções de Personagem: Nômade, Pirata, Caçador, Explorador, Cientista, Infiltrador");
        System.out.print("Escolha um personagem: ");
        String escolha= usuario.nextLine();
        if (escolha.equals("Nômade")){
            System.out.println("Destino final: Monte Congelante");
        } else if (escolha.equals("Pirata")) {
            System.out.println("Destino final:Monte Congelante");
        } else if (escolha.equals("Caçador")) {
            System.out.println("Destino final: Monte Congelante");
        }
        else if (escolha.equals("Explorador")){
            System.out.println("Destino final: Monte Congelante");
        }
        else if(escolha.equals("Cientista")){
            System.out.println("Destino Final: Monte Congelante");
        } else if (escolha.equals("Infiltrador")) {
            System.out.println("Destino Final: Monte Congelante");
        }

        GerenciadorDePersonagens gerenciador= new GerenciadorDePersonagens(escolha, "");
        gerenciador.escolherPersonagem();
        Personagem nomadePerdido=gerenciador.getPersonagem();
        Personagem pirataPerdido=gerenciador.getPersonagem();
        Personagem cacadorPerdido= gerenciador.getPersonagem();
        Personagem infiltradorPerdido= gerenciador.getPersonagem();
        Personagem exploradorPerdido= gerenciador.getPersonagem();
        Personagem cientistaPerdido= gerenciador.getPersonagem();



        Agua aguaPotavelRio=new Agua("Água Potável do Rio",6,6,10,9);
        Agua aguaPotavelCacto=new Agua("água do cacto", 4,5,8,5);
        Agua aguaContaminadaRio=new Agua("água de rio contaminada", 7,3,3,7);


        String[] listaAmbientes = {florestaRasa.getNomeAmbiente(), monteCongelante.getNomeAmbiente()};
        String[] ambientesPercorridos = {florestaRasa.getNomeAmbiente()};

        GerenciadorDeAmbientes lista = new GerenciadorDeAmbientes(listaAmbientes, "Nevasca", ambientesPercorridos);

        System.out.println("......................................................................................");
        if (escolha.equals("Nômade")){
            nomadePerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            nomadePerdido.statusPersonagem();
            lista.mudarAmbiente(nomadePerdido, monteCongelante);
            nomadePerdido.statusPersonagem();
        } else if (escolha.equals("Pirata")) {
            pirataPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            pirataPerdido.statusPersonagem();
            lista.mudarAmbiente(pirataPerdido, monteCongelante);
            pirataPerdido.statusPersonagem();

        } else if (escolha.equals("Caçador")) {
            cacadorPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            cacadorPerdido.statusPersonagem();
            lista.mudarAmbiente(cacadorPerdido, monteCongelante);
            cacadorPerdido.statusPersonagem();

        } else if (escolha.equals("Infiltrador")) {
            infiltradorPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            infiltradorPerdido.statusPersonagem();
            lista.mudarAmbiente(infiltradorPerdido, monteCongelante);
            cacadorPerdido.statusPersonagem();

        } else if (escolha.equals("Explorador")) {
            exploradorPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            exploradorPerdido.statusPersonagem();
            lista.mudarAmbiente(exploradorPerdido, monteCongelante);
            exploradorPerdido.statusPersonagem();

        } else if (escolha.equals("Cientista")) {
            cientistaPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            cientistaPerdido.statusPersonagem();
            lista.mudarAmbiente(cientistaPerdido, monteCongelante);
            cientistaPerdido.statusPersonagem();

        } else{
            System.out.println("Erro");
        }
    }
}
