package game;

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
        System.out.println(" -------------------------------------------------------------------------------------");
        System.out.println("                                  A Última Fronteira");
        System.out.println("--------------------------------------------------------------------------------------");

        Scanner usuario=new Scanner(System.in);
        System.out.println("Opções de Personagem: Nômade, Pirata, Caçador, Explorador, Cientista, Infiltrador");
        System.out.print("Escolha um personagem: ");
        String escolha= usuario.nextLine();
        if (escolha.equals("Nômade")){
            System.out.println("Destino final: Ruinas de Eldthórr");
        } else if (escolha.equals("Pirata")) {
            System.out.println("Destino final:Ruinas de Eldthórr");
        } else if (escolha.equals("Caçador")) {
            System.out.println("Destino final: Ruinas de Eldthórr");
        }
        else if (escolha.equals("Explorador")){
            System.out.println("Destino final: Ruinas de Eldthórr");
        }
        else if(escolha.equals("Cientista")){
            System.out.println("Destino Final: Ruinas de Eldthórr");
        } else if (escolha.equals("Infiltrador")) {
            System.out.println("Destino Final: Ruinas de Eldthórr");
        }

        GerenciadorDePersonagens gerenciadorPersonagem= new GerenciadorDePersonagens(escolha, "");
        gerenciadorPersonagem.escolherPersonagem();
        // Recuperar o personagem criado
        Personagem personagemEscolhido = gerenciadorPersonagem.getPersonagem();

        personagemEscolhido.statusPersonagem();

        //Gerenciador de ambientes:
        ArrayList<Ambientes> listaAmbientesDisponiveis = new ArrayList<>();
        GerenciadorDeAmbientes gerenciadorDeAmbientes = new GerenciadorDeAmbientes(listaAmbientesDisponiveis, "Indefinido", new ArrayList<>());

        // Gerar os ambientes no GerenciadorDeAmbientes
        gerenciadorDeAmbientes.gerarAmbientes();
        // Verificando se os ambientes foram corretamente adicionados
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                         Ambientes disponíveis: ");
        for (Ambientes ambiente : listaAmbientesDisponiveis) {
            System.out.println(ambiente.getNomeAmbiente());
        }
        System.out.println("-----------------------------------------------------------------------");

        // Lógica de movimentação e exibição de status
        //Primeiro ambiente
        Ambientes floresta=listaAmbientesDisponiveis.get(0);
        personagemEscolhido.setLocalizacaoPersonagem(floresta.getNomeAmbiente());
        personagemEscolhido.statusPersonagem();

        //Segundo Ambiente
        Ambientes montanha= listaAmbientesDisponiveis.get(1);
        gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, montanha);
        personagemEscolhido.statusPersonagem();

        //Terceiro Ambiente
        Ambientes caverna = listaAmbientesDisponiveis.get(2);
        gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, caverna);
        personagemEscolhido.statusPersonagem();

        //Quarto Ambiente
        Ambientes ruinas= listaAmbientesDisponiveis.get(3);
        gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido,ruinas);
        personagemEscolhido.statusPersonagem();

        //Quinto Ambiente
        Ambientes lagoRio= listaAmbientesDisponiveis.get(4);
        gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido,lagoRio);
        personagemEscolhido.statusPersonagem();

        System.out.println("......................................................................................");

        //Inventário:

        //Instanciando o inventário: A Capacidade inicial do ArrayList é a mesma da Capacidade do Inventário
        Inventario inventarioPrincipal = new Inventario(new ArrayList<Item>(25), 30,25);


    }
}
