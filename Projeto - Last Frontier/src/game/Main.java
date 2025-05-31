package game;

import ambientes.Ambiente;
import eventos.EventoClimatico;
import eventos.EventoCriatura;
import eventos.EventoDescoberta;
import eventos.Evento;
import gerenciadores.GerenciadorDeAmbientes;
import gerenciadores.GerenciadorDeEventos;
import gerenciadores.GerenciadorDeItens; // Certifique-se que esta importação existe
import inventario.Inventario;
import itens.Arma;
import itens.Item;
import itens.Remedio;
import mensagensTela.CondicaoDeVitoriaDerrota;
import mensagensTela.MensagensIniciais;
import gerenciadores.GerenciadorDePersonagens;
import personagens.Personagem;

import java.util.ArrayList;
import java.util.Random;
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
        GerenciadorDePersonagens gerenciadorDePersonagens = new GerenciadorDePersonagens();
        gerenciadorDePersonagens.mostrarPersonagens();
        gerenciadorDePersonagens.escolherPersonagens();
        Personagem personagemEscolhido = gerenciadorDePersonagens.getPersonagem();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        //Definição do Ambiente:
        ArrayList<Ambiente> listaAmbienteDisponiveis = new ArrayList<>(5);
        ArrayList<Ambiente> historicoDeMovimentacao = new ArrayList<>(20);
        GerenciadorDeAmbientes gerenciadorDeAmbientes = new GerenciadorDeAmbientes(listaAmbienteDisponiveis, historicoDeMovimentacao);
        gerenciadorDeAmbientes.gerarAmbientes();
        gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, listaAmbienteDisponiveis.getFirst());
        Ambiente ambienteAtual = listaAmbienteDisponiveis.getFirst();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        //Criando o Inventário e Adicionando os Itens Iniciais:
        Arma cajado = new Arma("Vetrkvistr", 4, 20, "Arma à distância", 10, 10); // Durabilidade aumentada
        Remedio bandagem = new Remedio("Vefrbind", 2, 4, "Bandagem", "Tiras de linho consagrado...");
        ArrayList<Item> listaItensParaInventario = new ArrayList<>(20); // Renomeado para clareza, se 'listaItens' for usada em outro lugar
        Inventario inventarioPersonagem = new Inventario(listaItensParaInventario, 45, 22);
        personagemEscolhido.setInventarioPersonagem(inventarioPersonagem);
        System.out.println("Você começa sua jornada com os seguintes Itens:");
        if (!inventarioPersonagem.adicionarItem(cajado)) {
            System.out.println("Falha ao adicionar item inicial: Cajado (Inventário pode estar mal configurado)");
        }
        if (!inventarioPersonagem.adicionarItem(bandagem)) {
            System.out.println("Falha ao adicionar item inicial: Bandagem (Inventário pode estar mal configurado)");
        }
        inventarioPersonagem.mostrarItem(cajado);
        System.out.println(cajado.getTipoArma());
        inventarioPersonagem.mostrarItem(bandagem);
        System.out.println(bandagem.getTipoRemedio() + " - " + bandagem.getEfeitoRemedio());
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        inventarioPersonagem.mostrarInventario();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        //Sistema de Turnos:
        int turnosMaximos = 24;
        int contadorTurnos = 0;
        boolean personagemVivo = true;

        //Elementos Dinâmicos do Jogo:
        EventoClimatico eventoClimaticoAtual = null;
        EventoCriatura eventoCriaturaAtual = null;
        int turnosDesdeEncontroCriatura = -1;
        EventoDescoberta eventoDescobertaAtual = null;

        //Sistema de Itens:
        GerenciadorDeItens gerenciadorDeItens = new GerenciadorDeItens();

        //Sistema de Eventos:
        ArrayList<Evento> listaEventoPossiveisGE = new ArrayList<>(20);
        ArrayList<Evento> historicoEventoGE = new ArrayList<>(25);
        GerenciadorDeEventos gerenciadorDeEventos = new GerenciadorDeEventos(listaEventoPossiveisGE, historicoEventoGE);

        //‘Loop’ principal do jogo:
        while (contadorTurnos < turnosMaximos && personagemVivo) {

            if (personagemEscolhido.getVidaPersonagem() <= 0 || personagemEscolhido.getFomePersonagem() <= 0 || personagemEscolhido.getSedePersonagem() <= 0 || personagemEscolhido.getSanidadePersonagem() <= 0) {
                personagemVivo = false;
                if (personagemEscolhido.getVidaPersonagem() <= 0) System.out.println("Sua vida chegou a 0!");
                else if (personagemEscolhido.getFomePersonagem() <= 0) System.out.println("Seus pontos de Fome chegaram a 0, você teve desnutrição e não resistiu!.");
                else if (personagemEscolhido.getSanidadePersonagem() <= 0) System.out.println("Seus pontos de Sanidade chegaram a 0, você ficou Louco e atentou contra a própia vida!");
                else System.out.println("Seus pontos de Sede chegaram a 0, você ficou desidratado e não resistiu!");
                System.out.println("Você MORREU e perdeu o jogo!");
                break;
            }

            if (contadorTurnos == 5) {
                ambienteAtual = listaAmbienteDisponiveis.get(1);
                gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, ambienteAtual);
            } else if (contadorTurnos == 10) {
                ambienteAtual = listaAmbienteDisponiveis.get(2);
                gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, ambienteAtual);
            } else if (contadorTurnos == 15) {
                ambienteAtual = listaAmbienteDisponiveis.get(3);
                gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, ambienteAtual);
            } else if (contadorTurnos == 20) {
                ambienteAtual = listaAmbienteDisponiveis.get(4);
                gerenciadorDeAmbientes.mudarAmbiente(personagemEscolhido, ambienteAtual);
            }

            System.out.println("\n--- Turno " + (contadorTurnos + 1) + "/" + turnosMaximos + " ---");
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
                    personagemEscolhido.setEnergiaPersonagem(personagemEscolhido.getEnergiaPersonagem() - 8);
                    personagemEscolhido.setFomePersonagem(personagemEscolhido.getFomePersonagem() - 8);
                    personagemEscolhido.setSedePersonagem(personagemEscolhido.getSedePersonagem() - 8);
                    personagemEscolhido.setSanidadePersonagem(personagemEscolhido.getSanidadePersonagem() - 5);

                    System.out.println("Eventos ocorrem durante a exploração:");
                    eventoClimaticoAtual = gerenciadorDeEventos.gerarEventosClimaticos(ambienteAtual);

                    if (eventoCriaturaAtual == null || eventoCriaturaAtual.getVidaCriatura() <= 0) {
                        EventoCriatura criaturaRecemGerada = gerenciadorDeEventos.gerarEventosCriatura();
                        if (criaturaRecemGerada != null) {
                            eventoCriaturaAtual = criaturaRecemGerada;
                            turnosDesdeEncontroCriatura = 0;
                            System.out.println(">> " + eventoCriaturaAtual.getNomeEvento() + " (" + eventoCriaturaAtual.getTipoCriatura() + ") observa você! <<");
                        }
                    } else {
                        System.out.println(">> " + eventoCriaturaAtual.getNomeEvento() + " (" + eventoCriaturaAtual.getTipoCriatura() + ") ainda está por perto e te encara... <<");
                    }

                    eventoDescobertaAtual = gerenciadorDeEventos.gerarEventosDescoberta();
                    if ((contadorTurnos + 1) % 4 == 0 && contadorTurnos > 0) { //Adicionado contadorTurnos > 0 para não ocorrer no primeiro turno (turno 0)
                        System.out.println("Sua exploração atenta revela algo interessante!");
                        eventoDescobertaAtual = gerenciadorDeEventos.gerarEventosDescoberta();

                        if (eventoDescobertaAtual != null) {
                            System.out.println("Você encontrou: " + eventoDescobertaAtual.getNomeEvento() + " - " + eventoDescobertaAtual.getDescricaoEvento());
                            String recursosString = eventoDescobertaAtual.getRecursoEncontrado();
                            System.out.println("Parece conter: " + recursosString);

                            //Lista para armazenar itens encontrados nesta descoberta:
                            ArrayList<Item> itensDaDescoberta = new ArrayList<>();

                            //Lógica para gerar itens com base na String do atributo recursoEncontrado:
                            if (recursosString.contains("Alimento")) {
                                itensDaDescoberta.add(gerenciadorDeItens.gerarItemAlimento());
                            }
                            if (recursosString.contains("Agua")) {
                                itensDaDescoberta.add(gerenciadorDeItens.gerarItemAgua());
                            }
                            if (recursosString.contains("Remedio")) {
                                itensDaDescoberta.add(gerenciadorDeItens.gerarItemRemedio());
                            }

                            // Para casos como "Materiais, Ferramentas ou Armas", onde é uma escolha
                            if (recursosString.contains("Material") && recursosString.contains("Ferramenta") && recursosString.contains("Arma")) {
                                Random sorteador = new Random();
                                int escolha = sorteador.nextInt(3); // 0 para Materiais, 1 para Ferramentas, 2 para Armas
                                if (escolha == 0) {
                                    itensDaDescoberta.add(gerenciadorDeItens.gerarItemMateriais());
                                } else if (escolha == 1) {
                                    itensDaDescoberta.add(gerenciadorDeItens.gerarItemFerramentas());
                                } else {
                                    itensDaDescoberta.add(gerenciadorDeItens.gerarItemArmas());
                                }
                            } else { // Casos mais simples de OU (se houver apenas duas opções, etc.) ou "E" para os não cobertos acima
                                if (recursosString.contains("Materiais") && !recursosString.contains(",")) { // Se for SÓ Materiais
                                    itensDaDescoberta.add(gerenciadorDeItens.gerarItemMateriais());
                                }
                                if (recursosString.contains("Ferramentas") && !recursosString.contains(",")) { // Se for SÓ Ferramentas
                                    itensDaDescoberta.add(gerenciadorDeItens.gerarItemFerramentas());
                                }
                                if (recursosString.contains("Armas") && !recursosString.contains(",")) { // Se for SÓ Armas
                                    itensDaDescoberta.add(gerenciadorDeItens.gerarItemArmas());
                                }
                            }
                            //Oferecendo cada item encontrado ao jogador:
                            for (Item itemAchado : itensDaDescoberta) {
                                if (itemAchado != null) {
                                    System.out.println("Especificamente, você vê um(a) " + itemAchado.getNomeItem() + ".");
                                    System.out.print("Deseja pegar este item? (s/n): ");
                                    String decisaoPegar = usuario.nextLine().trim();
                                    if (decisaoPegar.equalsIgnoreCase("s")) {
                                        if (inventarioPersonagem.adicionarItem(itemAchado)) {
                                            System.out.println(itemAchado.getNomeItem() + " foi adicionado ao seu inventário.");
                                        } else {
                                            System.out.println("Não foi possível adicionar " + itemAchado.getNomeItem() + ". Inventário cheio ou pesado demais.");
                                        }
                                    } else {
                                        System.out.println("Você deixou " + itemAchado.getNomeItem() + " para trás.");
                                    }
                                }
                            }
                        } else {
                            System.out.println("Sua exploração não revelou nenhuma descoberta especial desta vez.");
                        }
                    }

                    System.out.println("----------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem();

                    if (personagemEscolhido.getVidaPersonagem() <= 0 || personagemEscolhido.getSedePersonagem() <= 0 || personagemEscolhido.getFomePersonagem() <= 0 || personagemEscolhido.getSanidadePersonagem() <= 0) {
                        personagemVivo = false;
                    }
                    break;

                case "2": // Atacar Criatura
                    if (eventoCriaturaAtual == null || eventoCriaturaAtual.getVidaCriatura() <= 0) {
                        System.out.println("Não há nenhuma criatura para atacar no momento.");
                        continue;
                    }

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

                    Item itemEscolhido = inventarioPersonagem.getItemPeloIndice(indiceArmaSelecionada);

                    if (itemEscolhido instanceof Arma) {
                        Arma armaRealSelecionada = (Arma) itemEscolhido;
                        System.out.println("Você empunha sua " + armaRealSelecionada.getNomeItem() + ".");
                        System.out.println("----------------------------------------------------------------------------");

                        armaRealSelecionada.atacar(personagemEscolhido, eventoCriaturaAtual, usuario);

                        //Lógica: Pós-combate e Recompensa
                        if (eventoCriaturaAtual != null && eventoCriaturaAtual.getVidaCriatura() <= 0) {
                            System.out.println("\n>> O corpo de " + eventoCriaturaAtual.getNomeEvento() + " jaz imóvel. O perigo passou, por ora. <<");

                            //Recompensa por derrotar criatura:
                            System.out.println("Você vasculha os restos de " + eventoCriaturaAtual.getNomeEvento() + " por algo de valor...");
                            Item recompensaDropada = gerenciadorDeItens.gerarItemAleatorioGlobal();

                            if (recompensaDropada != null) {
                                System.out.print("Nos restos da criatura, você encontrou " + recompensaDropada.getNomeItem() + "! Deseja pegar? (s/n): ");
                                String pegarRecompensa = usuario.nextLine().trim();
                                if (pegarRecompensa.equalsIgnoreCase("s")) {
                                    if (inventarioPersonagem.adicionarItem(recompensaDropada)) {
                                        System.out.println(recompensaDropada.getNomeItem() + " adicionado ao inventário.");
                                    } else {
                                        System.out.println("Inventário cheio ou item muito pesado. Não foi possível pegar " + recompensaDropada.getNomeItem() + ".");
                                    }
                                } else {
                                    System.out.println("Você deixou a recompensa para trás.");
                                }
                            } else {
                                System.out.println("Não havia nada de útil para recuperar dos restos da criatura.");
                            }
                            System.out.println("----------------------------------------------------------------------------");
                            //Fim: Recompensa por derrotar criatura

                            eventoCriaturaAtual = null;
                            turnosDesdeEncontroCriatura = -1;
                        }
                        //Fim: Lógica Pós-combate e Recompensa

                        //Verificando a morte do Personagem (após o combate):
                        if (personagemEscolhido.getVidaPersonagem() <= 0) {
                            personagemVivo = false; // O loop principal tratará da mensagem de morte.
                        }
                        //Verificando a Durabilidade (após o combate):
                        if (armaRealSelecionada.getDurabilidadeItem() <= 0) {
                            System.out.println("Sua arma " + armaRealSelecionada.getNomeItem() + " quebrou com o esforço da batalha!");
                            inventarioPersonagem.descartarItem(armaRealSelecionada);
                        }

                    } else {
                        System.out.println("O item no índice " + indiceArmaSelecionada + " não é uma Arma ou o índice é inválido!");
                    }
                    System.out.println("----------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem();
                    break;

                case "3": // Abrir Inventário
                    inventarioPersonagem.mostrarInventario();
                    System.out.println("\nOpções do Inventário:");
                    System.out.println("1 - Ver inventário novamente");
                    System.out.println("2 - Usar/Selecionar Item");
                    System.out.println("3 - Descartar Item (pelo índice)");
                    System.out.println("4 - Ver detalhes de um Item (pelo índice)");
                    System.out.println("0 - Fechar Inventário");
                    System.out.print("Escolha uma opção do Inventário: ");
                    String opcaoInventario = usuario.nextLine().trim();

                    switch (opcaoInventario) {
                        case "1": inventarioPersonagem.mostrarInventario(); break;
                        case "2":
                            System.out.println("Digite a posição do Item que você deseja usar/selecionar:");
                            int indiceDoItemUsado = usuario.nextInt(); usuario.nextLine();
                            inventarioPersonagem.selecionarItem(indiceDoItemUsado, personagemEscolhido);
                            break;
                        case "3":
                            System.out.println("Digite a posição do Item que você deseja descartar:");
                            int indiceDoItemDescartado = usuario.nextInt(); usuario.nextLine();
                            inventarioPersonagem.descartarItemPeloIndice(indiceDoItemDescartado);
                            break;
                        case "4":
                            System.out.println("Digite a posição do Item que você quer ver:");
                            int indiceDoItemMostrado = usuario.nextInt(); usuario.nextLine();
                            Item itemParaMostrar = inventarioPersonagem.getItemPeloIndice(indiceDoItemMostrado);
                            if (itemParaMostrar != null) {
                                System.out.println("Mostrando características do Item Selecionado:");
                                inventarioPersonagem.mostrarItem(itemParaMostrar); // mostrarItem recebe o objeto Item
                            }
                            break;
                        case "0":
                            System.out.println("Fechando inventário."); break;
                        default:
                            System.out.println("Opção inválida para o inventário."); continue; // Pula para o próximo turno sem consumir ação principal
                    }
                    System.out.println("----------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem();
                    break;

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
                    continue;
            } //Fim do Switch(comando)

            //Lógica: Fim de Turno para Criatura Encntrada:
            if (eventoCriaturaAtual != null && eventoCriaturaAtual.getVidaCriatura() > 0 && personagemVivo) {
                turnosDesdeEncontroCriatura++;
                if (turnosDesdeEncontroCriatura >= 3) {
                    System.out.println(">> " + eventoCriaturaAtual.getNomeEvento() + " se cansa de esperar e desaparece nas sombras... <<");
                    eventoCriaturaAtual = null;
                    turnosDesdeEncontroCriatura = -1;
                }
            }

            //Lógica: Iteem Aleatório por Turno
            if (personagemVivo) {
                System.out.println("\n----------------------------------------------------------------------------");
                System.out.println("Ao final do turno, você faz uma busca rápida por recursos...");
                Item itemEncontradoTurno = gerenciadorDeItens.gerarItemAleatorioGlobal();

                if (itemEncontradoTurno != null) {
                    System.out.println("Você encontrou um(a) " + itemEncontradoTurno.getNomeItem() + ".");
                    System.out.print("Deseja pegar este item? (S/N): ");
                    String decisaoPegarItem = usuario.nextLine().trim();
                    if (decisaoPegarItem.equalsIgnoreCase("s")) {
                        if (inventarioPersonagem.adicionarItem(itemEncontradoTurno)) { // CORRIGIDO: Sem ';' extra
                            System.out.println(itemEncontradoTurno.getNomeItem() + " foi adicionado ao seu inventário.");
                        } else {
                            System.out.println("Você não conseguiu adicionar " + itemEncontradoTurno.getNomeItem() + " ao inventário (talvez esteja cheio ou muito pesado).");
                        }
                    } else {
                        System.out.println("Você decidiu deixar " + itemEncontradoTurno.getNomeItem() + " para trás.");
                    }
                } else {
                    System.out.println("Sua busca não revelou nada de útil desta vez.");
                }
                System.out.println("\n----------------------------------------------------------------------------");
            }
            //Fim da Lógicaa - Item aleatório por turno

            if (personagemVivo) {
                contadorTurnos++;
            }
        } //Fim do While (Loop Principal)

        if (!personagemVivo) {
            System.out.println("\nFim de jogo. O personagem não sobreviveu.");
        } else {
            System.out.println("\nParabéns! Você sobreviveu por " + turnosMaximos + " turnos!");
        }
        usuario.close();
    }
}