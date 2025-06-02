package gerenciadores;

import interfaces.AcoesGerenciadorDePersonagens;
import inventario.Inventario;
import itens.Arma;
import itens.Remedio;
import personagens.*;

import java.util.Scanner;

public class GerenciadorDePersonagem implements AcoesGerenciadorDePersonagens {
    //Atributos da Classe:
    String escolha;
    private Personagem personagem;
    //Construtor da Classe - Deixei Vazio:
    public GerenciadorDePersonagem() {
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
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        // Instanciando temporariamente para obter informações:
        Nomade nomade = new Nomade("Adaptativo, possui grande resistência, conhecimento médico e adaptabilidade à mudanças climáticas");
        Pirata pirata = new Pirata("Navegador, conhecedor das águas e apto para pescaria");
        Infiltrador infiltrador = new Infiltrador("Camuflador, consegue passar despercebido conseguir comida e armas sem ser pego");
        Explorador explorador = new Explorador("Rastreador, consegue achar comida e água mais facilmente");
        Cientista cientista = new Cientista("Criativo, consegue consertar coisas e construir");
        Cacador cacador = new Cacador("Lutador, consegue atacar e se defender muito bem");

        Personagem[] listaPersonagensDisplay = {nomade, pirata, infiltrador, explorador, cientista, cacador}; // Renomeei para evitar confusão com outras listas

        for (Personagem personagem : listaPersonagensDisplay) {
            System.out.println("\nClasse: " + personagem.getClass().getSimpleName()); //Mostrando o nome da Classe - Facilita para a exibição (No meu ponto de vista)
            System.out.println("Nome: " + personagem.getNomePersonagem());

            switch (personagem) {
                case Nomade nomade1 -> System.out.println("Habilidade da Classe: " + nomade1.getHabilidadeNomade());
                case Pirata pirata1 -> System.out.println("Habilidade da Classe: " + pirata1.getHabilidadePirata());
                case Infiltrador infiltrador1 ->
                        System.out.println("Habilidade da Classe: " + infiltrador1.getHabilidadeInfiltrador());
                case Explorador explorador1 ->
                        System.out.println("Habilidade da Classe: " + explorador1.getHabilidadeExplorador());
                case Cientista cientista1 ->
                        System.out.println("Habilidade da Classe: " + cientista1.getHabilidadeCientista());
                case Cacador cacador1 -> System.out.println("Habilidade da Classe: " + cacador1.getHabilidadeCacador());
                default -> {
                }
            }

            // --- NOVO: Exibindo a Habilidade Especial de Uso Único ---
            System.out.println("Habilidade Especial (Uso Único): " + personagem.getNomeHabilidadeEspecial());
            System.out.println("  Descrição da Habilidade Especial: " + personagem.getDescricaoHabilidadeEspecial());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public void configurarInventarioInicial(Personagem personagem) {
        if (personagem == null) {
            System.out.println("ERRO: Personagem nulo ao configurar inventário inicial.");
            return;
        }
        Inventario inventario = personagem.getInventarioPersonagem();
        if (inventario == null) {
            System.out.println("ERRO: Inventário do personagem " + personagem.getNomePersonagem() + " não foi inicializado antes de adicionar itens iniciais.");
            return;
        }

        System.out.println(personagem.getNomePersonagem() + " recebe seus equipamentos iniciais para a jornada:");
        Arma cajadoInicial = new Arma("Vetrkvistr", 4, 20, "Arma à distância", 10, 10);
        Remedio bandagemInicial = new Remedio("Vefrbind", 2, 4, "Bandagem", "Tiras de linho consagrado...");

        if (inventario.adicionarItem(cajadoInicial)) {
            System.out.println("  + " + cajadoInicial.getNomeItem() + " (" + cajadoInicial.getTipoArma() + ")");
        } else {
            System.out.println("  - Falha ao adicionar " + cajadoInicial.getNomeItem() + " (Verifique capacidade/peso do inventário).");
        }

        if (inventario.adicionarItem(bandagemInicial)) {
            System.out.println("  + " + bandagemInicial.getNomeItem() + " (Tipo: " + bandagemInicial.getTipoRemedio() + ")");
            System.out.println("    Efeito: " + bandagemInicial.getEfeitoRemedio());
        } else {
            System.out.println("  - Falha ao adicionar " + bandagemInicial.getNomeItem() + " (Verifique capacidade/peso do inventário).");
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
    }
}


