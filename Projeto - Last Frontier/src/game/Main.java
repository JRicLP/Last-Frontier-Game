package game;

import ambientes.Ambientes;
import eventos.EventoClimatico;
import eventos.EventoCriatura;
import eventos.EventoDescoberta;
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

        // Aqui é que irá funcionar a entrada do usuário para cada ação que for tomada:
        Scanner usuario = new Scanner(System.in);

        //Mensagens - Lore do Jogo:
        MensagensIniciais display = new MensagensIniciais();
        display.mensagensLoreIntroducao();
        display.sleep(3000);
        usuario.nextLine();

        //Mensagens - Regras do Jogo:
        CondicaoDeVitoriaDerrota display2 = new CondicaoDeVitoriaDerrota();
        display2.condicaoDisplay();
        usuario.nextLine();

        //Escolhendo o Personagem:

        //Instanciando o Gerenciador:
        GerenciadorDePersonagens gerenciadorDePersonagens = new GerenciadorDePersonagens();
        //Exibindo as Classes de Personagens - A escolha será feita a partir da classe!!
        gerenciadorDePersonagens.mostrarPersonagens();
        //Aqui, o usuário irá escolher o Personagem:
        gerenciadorDePersonagens.escolherPersonagens();
        //Setando o Personagem Escolhido pelo usuário:
        Personagem personagemEscolhido = gerenciadorDePersonagens.getPersonagem();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        //Definição do Ambiente:

        //Criando os Atributos que serão manipulados pelo Gerenciador:
        ArrayList<Ambientes> listaAmbientesDisponiveis = new ArrayList<Ambientes>(5);
        ArrayList<Ambientes> historicoDeMovimentacao = new ArrayList<Ambientes>(20);
        //Instanciando o Gerenciador:
        GerenciadorDeAmbientes gerenciadorDeAmbientes = new GerenciadorDeAmbientes(listaAmbientesDisponiveis, historicoDeMovimentacao);
        //Gerando os Ambientes Iniciais:
        gerenciadorDeAmbientes.gerarAmbientes();
        //Setando a Localização Inicial do Personagem - Tem uma diferença sutil, mas basicamente, aqui modificamos o Status do Personagem para o ambiente escolhido
        gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, listaAmbientesDisponiveis.getFirst());
        //Definindo o Ambiente Atual:
        Ambientes ambienteAtual = listaAmbientesDisponiveis.getFirst();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        //Criando o Inventário e Adicionando os Itens Iniciais:

        //Instanciando a Arma Inicial:
        Armas faca = new Armas("Kviðskera", 4, 9, "Arma corpo a corpo", 9, 2);
        //Instanciando um Remédio Inicial - É o ‘item’ mais justo, dado que o usuário pode enfrentar problemas no início do jogo!
        Remedios bandagem = new Remedios("Vefrbind", 2, 4, "Bandagem", "Tiras de linho consagrado embebidas em seiva de árvore antiga. A bandagem acelera a cicatrização e gruda levemente na pele ao toque," +
                "\ncomo se estivesse viva. Quando removida, queima as impurezas da ferida suavemente.");
        //Aqui temos a Lista de Itens do inventário, que possui a capacidade para 20 Itens
        ArrayList<Item> listaItens = new ArrayList<>(20);
        //Definimos e Instanciamos o iventário aqui, o detalhe da Capacidade é para validar a partir da condição no metodo adicionarItem();
        Inventario inventarioPersonagem = new Inventario(listaItens, 45, 22);
        //Aqui setamos o inventário do personagem:
        personagemEscolhido.setInventarioPersonagem(inventarioPersonagem);

        //Exibição dos Itens iniciais e Inventário:
        System.out.println("Você começa sua jornada com os seguintes Itens:");
        //Aqui, estamos a adicionar os itens iniciais instanciados:
        inventarioPersonagem.getListaItens().add(faca);
        inventarioPersonagem.getListaItens().add(bandagem);
        //Aqui, estamos a mostrar a descrição dos itens:
        inventarioPersonagem.mostrarItem(faca);
        System.out.println(faca.getTipoArma());
        inventarioPersonagem.mostrarItem(bandagem);
        System.out.println(bandagem.getTipoRemedio() + " - " + bandagem.getEfeitoRemedio());

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        //Aqui, mostramos o inventário do Personagem junto com as características desse inventário:
        inventarioPersonagem.mostrarInventario();
        System.out.println("Peso Suportado: " + inventarioPersonagem.getPesoSuportado());
        System.out.println("Capacidade: " + (inventarioPersonagem.getCapacidadeInventario() - 2) + " itens");

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        // Sistema de Turnos:
        int turnosMaximos = 24;
        int contadorTurnos = 0; // Este será o contador principal de ações/turnos
        boolean personagemVivo = true;// Coloquei essa flag para validar melhor a sobrevivência do personagem

        //Elementos Dinâmicos do Jogo:

        //Clima:
        EventoClimatico eventoClimaticoAtual = null;
        //Criatura:
        EventoCriatura eventoCriaturaAtual = null;
        int turnosDesdeEncontroCriatura = -1;
        //Descoberta
        EventoDescoberta eventoDescobertaAtual = null;

        // Sistema de Eventos: Aqui estamos a definir os atributos do Gerenciador de Eventos
        ArrayList<Eventos> listaEventosPossiveis = new ArrayList<Eventos>(20);
        ArrayList<Eventos> historicoEventos = new ArrayList<Eventos>(25);
        // Instanciando o Gerenciador de Eventos:
        GerenciadorDeEventos gerenciadorDeEventos = new GerenciadorDeEventos(listaEventosPossiveis, historicoEventos);
        // ‘Loop’ principal do jogo:
        while (contadorTurnos < turnosMaximos && personagemVivo) {

            // Aqui, estamos a verificar, inicialmente, se a condição de vida do personagem está a ser validada, para aí, sim, continuarmos o ‘loop’:
            if (personagemEscolhido.getVidaPersonagem() <= 0 || personagemEscolhido.getFomePersonagem() <= 0 || personagemEscolhido.getSedePersonagem() <= 0 || personagemEscolhido.getSanidadePersonagem() <= 0) {
                // Significa que o nosso personagem morreu :(
                personagemVivo = false;
                //Aqui, mostramos qual foi a causa da morte do nosso personagem:
                if (personagemEscolhido.getVidaPersonagem() <= 0) {
                    System.out.println("Sua vida chegou a 0!");
                } else if (personagemEscolhido.getFomePersonagem() <= 0) {
                    System.out.println("Seus pontos de Fome chegaram a 0, você teve desnutrição e não resistiu!.");
                } else if (personagemEscolhido.getSanidadePersonagem() <= 0) {
                    System.out.println("Seus pontos de Sanidade chegaram a 0, você ficou Louco e atentou contra a própia vida!");
                } else { // Sede <= 0
                    System.out.println("Seus pontos de Sede chegaram a 0, você ficou desidratado e não resistiu!");
                }
                System.out.println("Você MORREU e perdeu o jogo!");
                break;
            }

            //Nessa parte, estamos a fazer aquela mudança linear que combinamos, conforme a trajetória do personagem:
            if (contadorTurnos == 5) {
                gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, listaAmbientesDisponiveis.get(1));
                ambienteAtual = listaAmbientesDisponiveis.get(1);
            } else if (contadorTurnos == 10) {
                gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, listaAmbientesDisponiveis.get(2));
                ambienteAtual = listaAmbientesDisponiveis.get(2);
            } else if (contadorTurnos == 15) {
                gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, listaAmbientesDisponiveis.get(3));
                ambienteAtual = listaAmbientesDisponiveis.get(3);
            } else if (contadorTurnos == 20) {
                gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, listaAmbientesDisponiveis.get(4));
                ambienteAtual = listaAmbientesDisponiveis.get(4);
            }

            //Coloquei o contador de Turnos:
            System.out.println("\n--- Turno " + (contadorTurnos + 1) + "/" + turnosMaximos + " ---");
            //Aqui eu estou exibindo os Status do personagem, antes de cada turno:
            personagemEscolhido.statusPersonagem();

            System.out.println("\nEscolha sua ação:");
            System.out.println("1 - Explorar o Ambiente");
            System.out.println("2 - Atacar Criatura");
            System.out.println("3 - Abrir o Inventário");
            System.out.println("4 - Ver status do personagem");
            System.out.println("5 - Descansar");

            String comando = usuario.nextLine().trim();

            switch (comando) {
                case "1": // Explorar
                    System.out.println("Você explora os arredores...");

                    //Mudanças nos Status do Personagem turno a turno:
                    personagemEscolhido.setEnergiaPersonagem(personagemEscolhido.getEnergiaPersonagem() - 8);
                    personagemEscolhido.setFomePersonagem(personagemEscolhido.getFomePersonagem() - 8);
                    personagemEscolhido.setSedePersonagem(personagemEscolhido.getSedePersonagem() - 8);
                    personagemEscolhido.setSanidadePersonagem(personagemEscolhido.getSanidadePersonagem() - 5);

                    //Eventos gerados turno a turno:
                    System.out.println("Eventos ocorrem durante a exploração:");

                    //Clima do Turno:
                    eventoClimaticoAtual = gerenciadorDeEventos.gerarEventosClimaticos(ambienteAtual);

                    //Criatura do Turno:
                    if (eventoCriaturaAtual == null || eventoCriaturaAtual.getVidaCriatura() <= 0) {
                        EventoCriatura criaturaRecemGerada = gerenciadorDeEventos.gerarEventosCriatura();
                        if (criaturaRecemGerada != null) {
                            //Verificando se é Hostil:
                            if (criaturaRecemGerada.getTipoCriatura().contains("Hostil")) {
                                eventoCriaturaAtual = criaturaRecemGerada; // ATRIBUI À VARIÁVEL PERSISTENTE
                                turnosDesdeEncontroCriatura = 0; //Atualizando a variável para iniciar a contagem de Turnos
                                System.out.println(">> ALERTA! Um(a) " + eventoCriaturaAtual.getNomeEvento() + " (" + eventoCriaturaAtual.getTipoCriatura() + ") apareceu e parece hostil! <<");
                            } else {
                                System.out.println("Um(a) " + criaturaRecemGerada.getNomeEvento() + " (" + criaturaRecemGerada.getTipoCriatura() + ") foi visto(a) por perto, mas não parece agressivo(a).");
                                eventoCriaturaAtual = criaturaRecemGerada; //Quero que seja possível atacar criaturas, independente da sua hostilidade.
                                turnosDesdeEncontroCriatura = 0; //Atualizando a variável para iniciar a contagem de Turnos
                              }
                        }
                    } else {
                        // Já existe uma criatura ativa e viva
                        System.out.println(">> " + eventoCriaturaAtual.getNomeEvento() + " (" + eventoCriaturaAtual.getTipoCriatura() + ") ainda está por perto e te encara... <<");
                    }

                    //Descoberta do Turno:
                    eventoDescobertaAtual =  gerenciadorDeEventos.gerarEventosDescoberta(); //Vou aprimorar para se relacionar com a geração de Itens

                    System.out.println("----------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem(); //Mostrando o Status pós ação

                    //Verificando a morte após ações que afetam os Status do Personagem:
                    if (personagemEscolhido.getVidaPersonagem() <= 0 || personagemEscolhido.getSedePersonagem() <=0 || personagemEscolhido.getFomePersonagem() <= 0
                    || personagemEscolhido.getSanidadePersonagem() <= 0) {
                        personagemVivo = false;
                    }

                    break;

                case "2": // Atacar Criatura

                    //Verificando se há uma criatura:
                    if (eventoCriaturaAtual == null || eventoCriaturaAtual.getVidaCriatura() <= 0) {
                        System.out.println("Não há nenhuma criatura para atacar no momento.");
                        continue;
                    }

                    //Criatura existindo:
                    System.out.println("Você se prepara para enfrentar: " + eventoCriaturaAtual.getNomeEvento() + " (Vida: " + eventoCriaturaAtual.getVidaCriatura() + ")");
                    System.out.println("Antes de atacar, selecione uma Arma do seu inventário!");
                    inventarioPersonagem.mostrarInventario();
                    System.out.print("Digite o índice da Arma (começando em 0) ou -1 para reconsiderar: ");

                    int indiceArmaSelecionada;
                    if (usuario.hasNextInt()) {
                        indiceArmaSelecionada = usuario.nextInt();
                        usuario.nextLine();
                    } else {
                        System.out.println("Entrada de índice inválida. Ação cancelada.");
                        usuario.nextLine();
                        continue;
                    }

                    if (indiceArmaSelecionada == -1) {
                        System.out.println("Você decide não atacar desta vez.");
                        continue;
                    }

                    Item itemEscolhido = null;
                    // Validação do índice e obtenção do Item:
                    if (indiceArmaSelecionada >= 0 && indiceArmaSelecionada < inventarioPersonagem.getListaItens().size()) {
                        // Acesso direto à lista. Ideal: inventarioPersonagem.getItemPeloIndice(indiceArmaSelecionada);
                        itemEscolhido = listaItens.get(indiceArmaSelecionada);
                    }

                    if (itemEscolhido instanceof Armas) {
                        Armas armaRealSelecionada = (Armas) itemEscolhido;
                        System.out.println("Você empunha sua " + armaRealSelecionada.getNomeItem() + ".");
                        System.out.println("----------------------------------------------------------------------------");

                        //Iniciando a dinâmica de combatE:
                        armaRealSelecionada.atacar(personagemEscolhido, eventoCriaturaAtual, usuario);

                        //Pós-combate:
                        if (eventoCriaturaAtual.getVidaCriatura() <= 0) {
                            // Aqui podemos adicionar consequências ou informações extras no contexto do 'main'.
                            System.out.println("\n>> O corpo de " + eventoCriaturaAtual.getNomeEvento() + " jaz imóvel. O perigo passou, por ora. <<");
                            // TODO: Adicionar lógica para recompensas (XP, itens dropados).
                            eventoCriaturaAtual = null;
                            turnosDesdeEncontroCriatura = -1;
                        }
                        //Verificando a morte do Personagem:
                        if (personagemEscolhido.getVidaPersonagem() <= 0) {
                            personagemVivo = false;
                        }
                        //Verificando a Durabilidade:
                        if (armaRealSelecionada.getDurabilidadeItem() <= 0) {
                            System.out.println("Sua arma " + armaRealSelecionada.getNomeItem() + " quebrou com o esforço da batalha!");
                            //Arma Quebrou:
                            inventarioPersonagem.descartarItem(armaRealSelecionada);
                        }

                    } else {
                        System.out.println("O item no índice " + indiceArmaSelecionada + " não é uma Arma ou o índice é inválido!");
                        // Turno é consumido porque o jogador tentou uma ação.
                    }
                    System.out.println("----------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem();
                    break;

                case "3": // Abrir Inventário
                    inventarioPersonagem.mostrarInventario();
                    //Opções para o usuário escolher no Inventário:
                    System.out.println("\nOpções do Inventário:");
                    System.out.println("1 - Ver inventário novamente");
                    System.out.println("2 - Usar/Selecionar Item");
                    System.out.println("3 - Descartar Item");
                    System.out.println("4 - Ver detalhes de um Item");
                    System.out.println("0 - Fechar Inventário");

                    System.out.print("Escolha uma opção do Inventário: ");
                    String opcaoInventario = usuario.nextLine().trim();

                    switch (opcaoInventario) {
                            case "1": //Mostrar Inventário
                                inventarioPersonagem.mostrarInventario();
                                break;

                            case "2": // Usar-Selecionar Item do Inventário
                                System.out.println("Digite a posição do Item que você deseja usar/selecionar:");
                                int indiceDoItemUsado = usuario.nextInt();
                                usuario.nextLine();
                                //A depender da classe do Item, uma ação já é tomada
                                inventarioPersonagem.selecionarItem(indiceDoItemUsado, personagemEscolhido);
                                break;

                            case "3": // Descartar
                                System.out.println("Digite a posição do Item que você deseja descartar:");
                                int indiceDoItemDescartado = usuario.nextInt();
                                usuario.nextLine();
                                inventarioPersonagem.descartarItem(listaItens.get(indiceDoItemDescartado));
                                break;

                            case "4": // Ver detalhes dos Itens
                                System.out.println("Digite a posição do Item que você quer ver:");
                                int indiceDoItemMostrado = usuario.nextInt();
                                usuario.nextLine();
                                System.out.println("Mostrando características do Item Selecionado:");
                                inventarioPersonagem.mostrarItem(listaItens.get(indiceDoItemMostrado));
                                break;

                            case "0":
                                System.out.println("Fechando inventário.");
                                break;

                            default:
                                System.out.println("Opção inválida para o inventário.");
                                continue;
                    }
                    // Após uma ação de inventário, é bom mostrar o status atualizado.
                    System.out.println("----------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem();
                    break; // Fim do case "3" (Inventário) do switch principal

                case "4": // Ver status
                    personagemEscolhido.statusPersonagem();
                    continue;

                case "5": // Descansar
                    System.out.println("Você escolheu descansar, repor energias e acalmar a mente...");
                    System.out.println("Seu corpo não parou de funcionar, você consumiu pontos de Fome e Sede");
                    personagemEscolhido.setEnergiaPersonagem(personagemEscolhido.getEnergiaPersonagem() + 20);
                    personagemEscolhido.setSanidadePersonagem(personagemEscolhido.getSanidadePersonagem() + 10);
                    personagemEscolhido.setSedePersonagem(personagemEscolhido.getSedePersonagem() - 8);
                    personagemEscolhido.setFomePersonagem(personagemEscolhido.getFomePersonagem() - 8);
                    System.out.println("----------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem();
                    break;

                default:
                    System.out.println("Comando inválido. Tente novamente.");
                    continue; //Usamos continue não modificar o turno
            }
            // --- LÓGICA DE FIM DE TURNO PARA CRIATURA ENCONTRADA ---
            if (eventoCriaturaAtual != null && eventoCriaturaAtual.getVidaCriatura() > 0 && personagemVivo) {
                // Apenas incrementa se a criatura não foi derrotada neste turno e o jogador está vivo
                turnosDesdeEncontroCriatura++;
                // A criatura desaparece APÓS 2 turnos DEPOIS do turno do encontro.
                if (turnosDesdeEncontroCriatura >= 3) {
                    System.out.println(">> " + eventoCriaturaAtual.getNomeEvento() + " se cansa de esperar e desaparece nas sombras... <<");
                    eventoCriaturaAtual = null;
                    turnosDesdeEncontroCriatura = -1; //Resetando o contador
                }
            }
            if (personagemVivo) { //Só incrementa turno se o personagem ainda estiver vivo após a ação
                contadorTurnos++;
            }
            //Aqui, marcamos o final do turno
        }
        //Aqui marcamos o final do Jogo para 2 casos: Morte ou Sobrevivência Máxima
        if (!personagemVivo) {
            System.out.println("\nFim de jogo. O personagem não sobreviveu.");
        } else {
            System.out.println("\nParabéns! Você sobreviveu por " + turnosMaximos + " turnos!");
        }
        usuario.close();
    }
}