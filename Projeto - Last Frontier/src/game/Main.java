package game;

import ambientes.Ambientes;
import eventos.Eventos;
import gerenciadores.GerenciadorDeAmbientes;
import gerenciadores.GerenciadorDeEventos;
import inventario.Inventario;
import itens.Armas;
import itens.Item;
import itens.Remedios;
import mensagensTela.CondicaoDeVitoriaDerrota;
import mensagensTela.MensagensIniciais;
import gerenciadores.GerenciadorDePersonagens;
import personagens.Personagem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Mensagens - Lore do Jogo:
        MensagensIniciais display = new MensagensIniciais();
        display.mensagensLoreIntroducao();
        display.sleep(3000);
        new java.util.Scanner(System.in).nextLine();
        //Mensagens - Regras do Jogo:
        CondicaoDeVitoriaDerrota display2 = new CondicaoDeVitoriaDerrota();
        display2.condicaoDisplay();
        new java.util.Scanner(System.in).nextLine();
        //Escolhendo o Personagem:
        GerenciadorDePersonagens gerenciadorDePersonagens = new GerenciadorDePersonagens();
        gerenciadorDePersonagens.mostrarPersonagens();
        gerenciadorDePersonagens.escolherPersonagens();
        Personagem personagemEscolhido = gerenciadorDePersonagens.getPersonagem();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        //Definindo o Ambiente Inicial:
        ArrayList<Ambientes> listaAmbientesDisponiveis = new ArrayList<Ambientes>(5);
        ArrayList<Ambientes> historicoDeMovimentacao = new ArrayList<Ambientes>(20);
        GerenciadorDeAmbientes gerenciadorDeAmbientes = new GerenciadorDeAmbientes(listaAmbientesDisponiveis, historicoDeMovimentacao);
        gerenciadorDeAmbientes.gerarAmbientes();
        gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, listaAmbientesDisponiveis.get(3));
        Ambientes ambienteAtual = listaAmbientesDisponiveis.get(3);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        //Criando o Inventário e Adicionando os Itens Iniciais:
        Armas faca = new Armas("Kviðskera", 4, 9, "Arma corpo a corpo", 9, 2);
        Remedios bandagem = new Remedios("Vefrbind", 2, 4, "Bandagem", "Tiras de linho consagrado embebidas em seiva de árvore antiga. A bandagem acelera a cicatrização e gruda levemente na pele ao toque," +
                "\ncomo se estivesse viva. Quando removida, queima as impurezas da ferida suavemente.");
        ArrayList<Item> listaItens = new ArrayList<>(20);
        Inventario inventarioPersonagem = new Inventario(listaItens, 45, 22);
        personagemEscolhido.setInventarioPersonagem(inventarioPersonagem);
        //Exibição dos Itens iniciais e Inventário:
        System.out.println("Você começa sua jornada com os seguintes Itens:");
        inventarioPersonagem.getListaItens().add(faca);
        inventarioPersonagem.getListaItens().add(bandagem);
        inventarioPersonagem.mostraItem(faca);
        System.out.println(faca.getTipoArma());
        inventarioPersonagem.mostraItem(bandagem);
        System.out.println(bandagem.getTipoRemedio() + " - " + bandagem.getEfeitoRemedio());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Seu Inventário:");
        inventarioPersonagem.mostrarInventario();
        System.out.println("Peso Suportado: " + inventarioPersonagem.getPesoSuportado());
        System.out.println("Capacidade: " + listaItens.size() + " itens");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        //Sistema de Turnos:
        int turnosMaximos = 24;
        int contadorTurnos = 0;
        //Sistema de Eventos:
        ArrayList<Eventos> listaEventosPossiveis = new ArrayList<Eventos>(10);
        ArrayList<Eventos> historicoEventos = new ArrayList<Eventos>(20);
        GerenciadorDeEventos gerenciadorDeEventos = new GerenciadorDeEventos(listaEventosPossiveis, historicoEventos);
        //Verifica se o personagem morreu
        while (true) {
            //Condição de morte: - Percebi que precisamos realocar essa condição para dentro do Loop!!
            if (personagemEscolhido.getVidaPersonagem() <= 0 || personagemEscolhido.getFomePersonagem() <= 0 || personagemEscolhido.getSedePersonagem() <= 0) {
                if (personagemEscolhido.getVidaPersonagem() <= 0) {
                    System.out.println("Sua vida chegou a 0!");
                    System.out.println(" Você MORREU e perdeu o jogo!");
                    break;
                } else if (personagemEscolhido.getFomePersonagem() <= 0) {
                    System.out.println(" Você está com desnutrição! Seus pontos de fome chegaram a 0");
                    System.out.println(" Você MORREU e perdeu o jogo!");
                    break;
                } else if (personagemEscolhido.getSanidadePersonagem() <= 0) {
                    System.out.println("Você está Louco e atirou a prórpia vida em um ato de loucura!");
                    break;
                } else {
                    System.out.println(" Você está desidratado! Seus pontos de sede chegaram a 0");
                    System.out.println(" Você MORREU e perdeu o jogo!");
                    break;
                }
            } else {
                Scanner usuario = new Scanner(System.in);
                while (contadorTurnos <= turnosMaximos) {
                    for (int contador = 0; contador <= 3; contador++) {

                        //Iremos aprimorar a contagem de turno e a sua relação com as ações escolhidas pelo usuário!!

                        //Ações Possíveis:
                        System.out.println("\nEscolha sua ação:");
                        System.out.println("1 - Explorar");
                        System.out.println("2 - Atacar Criatura"); //Essa ação será aprimorada conforme a disponibilidade de criaturas
                        System.out.println("3 - Usar item do inventário"); //Essa ação será aprimorada a partir do acesso ao inventário
                        System.out.println("4 - Ver status do personagem");
                        System.out.println("5 - Descansar");
                        System.out.println("6 - Utilizar Ferramenta"); //Essa ação será aprimorada a partir do acesso ao inventário
                        System.out.println("7 - Utilizar Remedio"); //Essa ação será aprimorada a partir do acesso ao inventário

                        String comando = usuario.nextLine();
                        switch (comando) {
                            case "1":
                                //Mudanças Realizadas Turno a Turno:
                                personagemEscolhido.setEnergiaPersonagem(personagemEscolhido.getEnergiaPersonagem() - 4);
                                personagemEscolhido.setFomePersonagem(personagemEscolhido.getFomePersonagem() - 4);
                                personagemEscolhido.setSedePersonagem(personagemEscolhido.getSedePersonagem() - 4);
                                personagemEscolhido.setSanidadePersonagem(personagemEscolhido.getSanidadePersonagem() - 2);
                                // Executa eventos do ambiente
                                gerenciadorDeEventos.gerarEventosClimaticos(ambienteAtual);
                                gerenciadorDeEventos.gerarEventosCriatura();
                                gerenciadorDeEventos.gerarEventosDescoberta();
                                System.out.println("----------------------------------------------------------------------------");
                                personagemEscolhido.statusPersonagem();
                                break;

                            case "2": //Ainda iremos aprimorar essa ação!!
                                //colocar os metodos para atacar a criatura
                                System.out.println("Você atacou a criatura!");
                                System.out.println("----------------------------------------------------------------------------");
                                personagemEscolhido.statusPersonagem();
                                break;

                            case "3": //Ainda iremos aprimorar essa ação!!
                                //colocar os métodos para usar os itens, selecionar e retirar
                                //personagemEscolhido.this.getSelecionarItem();
                                System.out.println("Você selecionou o item! Cuidado ao usá-lo");
                                System.out.println("----------------------------------------------------------------------------");
                                personagemEscolhido.statusPersonagem();
                                break;

                            case "4":
                                personagemEscolhido.statusPersonagem();
                                break;

                            case "5": //Ainda iremos aprimorar essa ação!!
                                System.out.println("Você escolheu descansar e repor energias");
                                System.out.println("----------------------------------------------------------------------------");
                                personagemEscolhido.statusPersonagem();
                                //Iremos fazer o tratamento com as exceções para não ultrapassar o limite de energia!!
                                personagemEscolhido.setEnergiaPersonagem(personagemEscolhido.getEnergiaPersonagem() + 20);
                                personagemEscolhido.setSanidadePersonagem(personagemEscolhido.getSanidadePersonagem() + 10);
                                break;

                            case "6":
                                //colocar o metodo de utilizar ferramenta
                                System.out.println(" Você utilizou a ferramenta para construir coisas");
                                System.out.println("----------------------------------------------------------------------------");
                                personagemEscolhido.statusPersonagem();
                                break;

                            case "7": //Ainda iremos aprimorar essa ação!!
                                //colocar o metodo de usar remedio
                                System.out.println(" Você escolheu utilizar o remédio");
                                System.out.println(" Está curado");
                                System.out.println("----------------------------------------------------------------------------");
                                personagemEscolhido.statusPersonagem();
                                break;

                            default:
                                System.out.println("Comando inválido");
                                break;
                        }
                        //Atualizando o contador de turnos: Isso irá se relacionar com uma das condições de vitória!!
                        contadorTurnos++;
                    }//colocar para sortear os ambientes
                }
            }
        }
    }
}
