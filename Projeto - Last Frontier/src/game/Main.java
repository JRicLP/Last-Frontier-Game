package game;

import ambientes.*;
import gerenciadores.GerenciadorDeAmbientes;
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

        AmbienteLagoRio praia=new AmbienteLagoRio("Praia dos Piratas", " Essa praia é o refúgio dos piratas depois deles viajarem meses pelo mar, praia tropical",
                0.2, "Frutas tropicais, água e madeira", 0.4, "Tropical", "Potável", "Grande possibilidade de pesca",
                " Não, o terreno é arenoso");

        AmbienteFloresta florestaHabitada=new AmbienteFloresta(" Floresta Habitada", " Floresta com uma cidade pequena dentro, com casas e pessoas amigáveis", 0.4," Lugar seguro, comida e água",
                0.4, "Verão mas com leves chuvas", "Árvores altas e frutíferas, dando sombra e alimento, e vegetação gramínea","Presença de animais para a caça, e sem animais selvagens",
                " As chuvas podem ocorrer ao longo do dia");

        AmbienteMontanha montanhaHabitada=new AmbienteMontanha(" Montanha Habitada", " Montanha composta por cidades ao redor, sem perigo e bem civilizada", 0.3, "Segurança e comida", 0.4,
                "Chuvoso", " O terreno é plano e com gramíneas", "O clima é instável e pode nevar em determinados dias", "Há pinheiros e algumas árvores que sobrevivem ao frio");

        AmbienteRuinas desertoHabitado=new AmbienteRuinas("Deserto Habitado", "Localizado em meio ao deserto, a cidade está rodeada de tesouros e turistas", 0.5, "Armas e comida", 0.4, "Verão",
                " Algumas casas podem estar mal estruturas", "Sobreviventes Aliados", "Não há risco de chuvas ou neve extrema, mas precisa de muita água devido ao calor");

        AmbienteCaverna cavernaCientifica=new AmbienteCaverna("Caverna Científica", "A caverna é um refúgio para cientista, um laboratório secreto com todos os materiais necessários para pesquisas", 0.4, "Segurança e comida", 0.4,
                " Chuvas escassas", "Pouca luz mas o laboratório ilumina ", " Não há, apenas para pesquisas", "Não");

        Scanner usuario=new Scanner(System.in);
        System.out.println("Opções de Personagem: Nômade, Pirata, Caçador, Explorador, Cientista, Infiltrador");
        System.out.print("Escolha um personagem: ");
        String escolha= usuario.nextLine();
        if (escolha.equals("Nômade")){
            System.out.println("Destino final: Monte congelante");
        } else if (escolha.equals("Pirata")) {
            System.out.println("Destino final:Praia dos Piratas");
        } else if (escolha.equals("Caçador")) {
            System.out.println("Destino final: Floresta Habitada");
        } else if (escolha.equals("Explorador")){
            System.out.println("Destino final: Deserto Habitado");
        }
        else if(escolha.equals("Cientista")){
            System.out.println("Destino Final: Caverna Científica");
        } else if (escolha.equals("Infiltrador")) {
            System.out.println("Destino Final: Montanha Habitada");
        }

        GerenciadorDePersonagens gerenciador= new GerenciadorDePersonagens(escolha, "");
        gerenciador.escolherPersonagem();
        Personagem russoPerdido=gerenciador.getPersonagem();
        Personagem pirataPerdido=gerenciador.getPersonagem();
        Personagem cacadorPerdido= gerenciador.getPersonagem();
        Personagem infiltradorPerdido= gerenciador.getPersonagem();
        Personagem exploradorPerdido= gerenciador.getPersonagem();
        Personagem cientistaPerdido= gerenciador.getPersonagem();


        String[] listaAmbientes = {florestaRasa.getNomeAmbiente(), monteCongelante.getNomeAmbiente(), praia.getNomeAmbiente(), florestaHabitada.getNomeAmbiente(), montanhaHabitada.getNomeAmbiente(),
        desertoHabitado.getNomeAmbiente(), cavernaCientifica.getNomeAmbiente()};
        String[] ambientesPercorridos = {florestaRasa.getNomeAmbiente()};

        GerenciadorDeAmbientes lista = new GerenciadorDeAmbientes(listaAmbientes, "Nevasca", ambientesPercorridos);
        System.out.println(".................................................................................");
        if (escolha.equals("Nômade")){
            russoPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            russoPerdido.statusPersonagem();
            lista.mudarAmbiente(russoPerdido, monteCongelante);
            russoPerdido.statusPersonagem();
        } else if (escolha.equals("Pirata")) {
            pirataPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            pirataPerdido.statusPersonagem();
            lista.mudarAmbiente(pirataPerdido, praia);
            pirataPerdido.statusPersonagem();

        } else if (escolha.equals("Caçador")) {
            cacadorPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            cacadorPerdido.statusPersonagem();
            lista.mudarAmbiente(cacadorPerdido,florestaHabitada);
            cacadorPerdido.statusPersonagem();

        } else if (escolha.equals("Infiltrador")) {
            infiltradorPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            infiltradorPerdido.statusPersonagem();
            lista.mudarAmbiente(infiltradorPerdido, montanhaHabitada);
            cacadorPerdido.statusPersonagem();

        } else if (escolha.equals("Explorador")) {
            exploradorPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            exploradorPerdido.statusPersonagem();
            lista.mudarAmbiente(exploradorPerdido, desertoHabitado);
            exploradorPerdido.statusPersonagem();

        } else if (escolha.equals("Cientista")) {
            cientistaPerdido.setLocalizacaoPersonagem(florestaRasa.getNomeAmbiente());
            cientistaPerdido.statusPersonagem();
            lista.mudarAmbiente(cientistaPerdido, cavernaCientifica);
            cientistaPerdido.statusPersonagem();

        } else{
            System.out.println("Erro");
        }
    }
}
