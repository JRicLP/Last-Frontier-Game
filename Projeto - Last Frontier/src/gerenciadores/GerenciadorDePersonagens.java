package gerenciadores;

import interfaces.AcoesGerenciadorDePersonagens;
import personagens.*;

import java.util.Scanner;

public class GerenciadorDePersonagens implements AcoesGerenciadorDePersonagens {
    String escolha;
    private Personagem personagem;

    public GerenciadorDePersonagens() {

    }

    //Métodos acessores:
    public void setEscolha(String escolha) {
        this.escolha = escolha;
    }

    public String getEscolha() {
        return escolha;
    }

    public void setPersonagem(Personagem personagemSelecionado) {
        this.personagem = personagemSelecionado;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    @Override
    public void escolherPersonagens() {

        Scanner entradaUsuario = new Scanner(System.in);

        while (true) {
            System.out.println("Digite a classe de Personagem escolhida:");
            String escolha = entradaUsuario.nextLine().trim();
            this.setEscolha(escolha);

            switch (escolha) {
                case "Nômade":
                    this.setPersonagem(new Nomade("Adaptativo, possui grande resistência, conhecimento médico e adaptabilidade à mudanças climáticas"));
                    break;
                case "Pirata":
                    this.setPersonagem(new Pirata("Navegador, conhecedor das águas e apto para pescaria"));
                    break;
                case "Infiltrador":
                    this.setPersonagem(new Infiltrador("Camuflador, consegue passar despercebido conseguir comida e armas sem ser pego"));
                    break;
                case "Explorador":
                    this.setPersonagem(new Explorador("Rastreador, consegue achar comida e água mais facilmente"));
                    break;
                case "Cientista":
                    this.setPersonagem(new Cientista("Criativo, consegue consertar coisas e construir"));
                    break;
                case "Caçador":
                    this.setPersonagem(new Cacador("Lutador, consegue atacar e se defender muito bem"));
                    break;
                default:
                    System.out.println("Classe de personagem não reconhecida. Tente novamente.\n");
                    continue;
            }

            System.out.println("Você escolheu " + this.getEscolha());
            System.out.println("Boa sorte em sua jornada!");
            //Personagem personagemEscolhido = this.getPersonagem();
            break;
        }
    }

    @Override
    public void mostrarPersonagens() {
        System.out.println("Escolha uma classe de Personagem:");

        Nomade nomade = new Nomade("Adaptativo, possui grande resistência, conhecimento médico e adaptabilidade à mudanças climáticas");
        Pirata pirata = new Pirata("Navegador, conhecedor das águas e apto para pescaria");
        Infiltrador infiltrador = new Infiltrador("Camuflador, consegue passar despercebido conseguir comida e armas sem ser pego");
        Explorador explorador = new Explorador("Rastreador, consegue achar comida e água mais facilmente");
        Cientista cientista = new Cientista("Criativo, consegue consertar coisas e construir");
        Cacador cacador = new Cacador("Lutador, consegue atacar e se defender muito bem");

        Personagem[] listaPersonagens = {nomade, pirata, infiltrador,explorador, cientista, cacador};

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        for (Personagem listaPersonagen : listaPersonagens) {
            System.out.println(listaPersonagen.getNomePersonagem());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Habilidades:");
        System.out.println("Nômade: " + nomade.getHabilidadeNomade());
        System.out.println("Pirata: " + pirata.getHabilidadePirata());
        System.out.println("Infiltrador: " + infiltrador.getHabilidadeInfiltrador());
        System.out.println("Explorador: " + explorador.getHabilidadeExplorador());
        System.out.println("Cientista: " + cientista.getHabilidadeCientista());
        System.out.println("Caçador: " + cacador.getHabilidadeCacador());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    }
}

