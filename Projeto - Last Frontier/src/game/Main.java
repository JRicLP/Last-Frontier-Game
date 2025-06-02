package game;

import ambientes.Ambiente;
import eventos.EventoClimatico;
import eventos.EventoCriatura;
import eventos.EventoDescoberta;
import eventos.Evento;
import gerenciadores.GerenciadorDeAmbiente;
import gerenciadores.GerenciadorDeEvento;
import gerenciadores.GerenciadorDeItem;
import inventario.Inventario;
import itens.Arma;
import itens.Item;
import mensagensTela.CondicaoDeVitoriaDerrota;
import mensagensTela.MensagensIniciais;
import gerenciadores.GerenciadorDePersonagem;
import personagens.Personagem;
import construcao.Receita;
import construcao.CatalogoDeReceitas;
import gerenciadores.GerenciadorDeConstrucao;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner usuario = new Scanner(System.in);

        MensagensIniciais display = new MensagensIniciais();
        display.mensagensLoreIntroducao();
        display.sleep(3000);
        usuario.nextLine();

        CondicaoDeVitoriaDerrota display2 = new CondicaoDeVitoriaDerrota();
        display2.condicaoDisplay();
        usuario.nextLine();

        GerenciadorDePersonagem gerenciadorDePersonagem = new GerenciadorDePersonagem();
        gerenciadorDePersonagem.mostrarPersonagens();
        gerenciadorDePersonagem.escolherPersonagens();
        Personagem personagemEscolhido = gerenciadorDePersonagem.getPersonagem();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        ArrayList<Ambiente> listaAmbienteDisponiveis = new ArrayList<>(5); // Usando Ambiente (singular)
        ArrayList<Ambiente> historicoDeMovimentacao = new ArrayList<>(20); // Usando Ambiente (singular)
        GerenciadorDeAmbiente gerenciadorDeAmbiente = new GerenciadorDeAmbiente(listaAmbienteDisponiveis, historicoDeMovimentacao);
        gerenciadorDeAmbiente.gerarAmbientes();
        gerenciadorDeAmbiente.mudarAmbiente(personagemEscolhido, listaAmbienteDisponiveis.getFirst());
        Ambiente ambienteAtual = listaAmbienteDisponiveis.getFirst();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        ArrayList<Item> listaItensParaInventario = new ArrayList<>(20);
        Inventario inventarioPersonagem = new Inventario(listaItensParaInventario, 45, 22);
        personagemEscolhido.setInventarioPersonagem(inventarioPersonagem);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Preparando equipamentos iniciais...");
        gerenciadorDePersonagem.configurarInventarioInicial(personagemEscolhido);
        System.out.println("Verificando seu inventário após receber os itens iniciais:");
        inventarioPersonagem.mostrarInventario();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        inventarioPersonagem.mostrarInventario();
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

        int turnosMaximos = 24;
        int contadorTurnos = 0;
        boolean personagemVivo = true;

        EventoClimatico eventoClimaticoAtual = null;
        EventoCriatura eventoCriaturaAtual = null;
        int turnosDesdeEncontroCriatura = -1;
        EventoDescoberta eventoDescobertaAtual = null;

        GerenciadorDeItem gerenciadorDeItem = new GerenciadorDeItem();
        ArrayList<Evento> listaEventoPossiveisGE = new ArrayList<>(20);
        ArrayList<Evento> historicoEventoGE = new ArrayList<>(25);
        GerenciadorDeEvento gerenciadorDeEvento = new GerenciadorDeEvento(listaEventoPossiveisGE, historicoEventoGE);

        CatalogoDeReceitas catalogoDeReceitas = new CatalogoDeReceitas();
        ArrayList<Receita> todasAsReceitasDoJogo = catalogoDeReceitas.getTodasAsReceitas();
        GerenciadorDeConstrucao gerenciadorDeConstrucao = new GerenciadorDeConstrucao(todasAsReceitasDoJogo);

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Sistema de construção carregado com " + todasAsReceitasDoJogo.size() + " receita(s) conhecidas.");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

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
                gerenciadorDeAmbiente.mudarAmbiente(personagemEscolhido, ambienteAtual);
            } else if (contadorTurnos == 10) {
                ambienteAtual = listaAmbienteDisponiveis.get(2);
                gerenciadorDeAmbiente.mudarAmbiente(personagemEscolhido, ambienteAtual);
            } else if (contadorTurnos == 15) {
                ambienteAtual = listaAmbienteDisponiveis.get(3);
                gerenciadorDeAmbiente.mudarAmbiente(personagemEscolhido, ambienteAtual);
            } else if (contadorTurnos == 20) {
                ambienteAtual = listaAmbienteDisponiveis.get(4);
                gerenciadorDeAmbiente.mudarAmbiente(personagemEscolhido, ambienteAtual);
            }

            System.out.println("\n--- Turno " + (contadorTurnos + 1) + "/" + turnosMaximos + " ---");
            personagemEscolhido.statusPersonagem();

            System.out.println("\nEscolha sua ação:");
            System.out.println("1 - Explorar o Ambiente");
            System.out.println("2 - Atacar Criatura");
            System.out.println("3 - Abrir o Inventário");
            System.out.println("4 - Ver status do personagem");
            System.out.println("5 - Descansar");
            System.out.println("6 - Usar Habilidade Especial");

            String comando = usuario.nextLine().trim();

            switch (comando) {
                case "1": // Explorar
                    System.out.println("Você explora os arredores...");
                    personagemEscolhido.setEnergiaPersonagem(personagemEscolhido.getEnergiaPersonagem() - 8);
                    personagemEscolhido.setFomePersonagem(personagemEscolhido.getFomePersonagem() - 8);
                    personagemEscolhido.setSedePersonagem(personagemEscolhido.getSedePersonagem() - 8);
                    personagemEscolhido.setSanidadePersonagem(personagemEscolhido.getSanidadePersonagem() - 5);

                    System.out.println("Eventos ocorrem durante a exploração:");
                    eventoClimaticoAtual = gerenciadorDeEvento.gerarEventosClimaticos(ambienteAtual);

                    if (eventoCriaturaAtual == null || eventoCriaturaAtual.getVidaCriatura() <= 0) {
                        EventoCriatura criaturaRecemGerada = gerenciadorDeEvento.gerarEventosCriatura();
                        if (criaturaRecemGerada != null) {
                            eventoCriaturaAtual = criaturaRecemGerada;
                            turnosDesdeEncontroCriatura = 0;
                            System.out.println(">> " + eventoCriaturaAtual.getNomeEvento() + " (" + eventoCriaturaAtual.getTipoCriatura() + ") observa você! <<");
                        }
                    } else {
                        System.out.println(">> " + eventoCriaturaAtual.getNomeEvento() + " (" + eventoCriaturaAtual.getTipoCriatura() + ") ainda está por perto e te encara... <<");
                    }
                    //Geração e Processamento do EventoDescoberta:
                    eventoDescobertaAtual = null; //Limpa descoberta anterior para não reprocessar

                    if ((contadorTurnos + 1) % 4 == 0 && contadorTurnos > 0) {
                        System.out.println("Sua exploração atenta revela algo interessante!");
                        eventoDescobertaAtual = gerenciadorDeEvento.gerarEventosDescoberta(); // Gera SOMENTE no turno certo

                        if (eventoDescobertaAtual != null) {
                            String recursosString = eventoDescobertaAtual.getRecursoEncontrado();
                            System.out.println("Parece conter: " + recursosString);

                            ArrayList<Item> itensDaDescoberta = new ArrayList<>();
                            //Drop de acordo com o conteúdo da Descoberta:
                            if (recursosString.contains("Alimento")) itensDaDescoberta.add(gerenciadorDeItem.gerarItemAlimento());
                            if (recursosString.contains("Agua")) itensDaDescoberta.add(gerenciadorDeItem.gerarItemAgua());
                            if (recursosString.contains("Remedio")) itensDaDescoberta.add(gerenciadorDeItem.gerarItemRemedio());
                            if (recursosString.contains("Material") && recursosString.contains("Ferramenta") && recursosString.contains("Arma")) {
                                Random sorteadorTipoItem = new Random(); // Renomeado para não conflitar com 'sorteador' em GerenciadorDeItem
                                int escolha = sorteadorTipoItem.nextInt(3);
                                if (escolha == 0) itensDaDescoberta.add(gerenciadorDeItem.gerarItemMateriais());
                                else if (escolha == 1) itensDaDescoberta.add(gerenciadorDeItem.gerarItemFerramentas());
                                else itensDaDescoberta.add(gerenciadorDeItem.gerarItemArmas());
                            } else {
                                if (recursosString.contains("Material") && !recursosString.contains(",")) itensDaDescoberta.add(gerenciadorDeItem.gerarItemMateriais());
                                if (recursosString.contains("Ferramenta") && !recursosString.contains(",")) itensDaDescoberta.add(gerenciadorDeItem.gerarItemFerramentas());
                                if (recursosString.contains("Arma") && !recursosString.contains(",")) itensDaDescoberta.add(gerenciadorDeItem.gerarItemArmas());
                            }
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
                        } else { // Se gerenciadorDeEvento.gerarEventosDescoberta() retornou null no turno certo
                            System.out.println("Sua exploração não revelou nenhuma descoberta especial desta vez.");
                        }
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
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

                    if (itemEscolhido instanceof Arma armaRealSelecionada) {
                        // Dentro deste bloco, armaRealSelecionada JÁ É DO TIPO Arma
                        System.out.println("Você empunha sua " + armaRealSelecionada.getNomeItem() + ".");
                        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                        armaRealSelecionada.atacar(personagemEscolhido, eventoCriaturaAtual, usuario);

                        // --- INÍCIO: Lógica Pós-combate e Recompensa ---
                        if (eventoCriaturaAtual != null && eventoCriaturaAtual.getVidaCriatura() <= 0) { //Vou deixar essa segunda verificação por segurança
                            System.out.println("\n>> O corpo de " + eventoCriaturaAtual.getNomeEvento() + " jaz imóvel. O perigo passou, por ora. <<");

                            System.out.println("Você vasculha os restos de " + eventoCriaturaAtual.getNomeEvento() + " por algo de valor...");
                            Item recompensaDropada = gerenciadorDeItem.gerarItemAleatorioGlobal();

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
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");

                            eventoCriaturaAtual = null;
                            turnosDesdeEncontroCriatura = -1;
                        }
                        // --- FIM: Lógica Pós-combate e Recompensa ---

                        if (personagemEscolhido.getVidaPersonagem() <= 0) {
                            personagemVivo = false;
                        }
                        if (armaRealSelecionada.getDurabilidadeItem() <= 0) {
                            System.out.println("Sua arma " + armaRealSelecionada.getNomeItem() + " quebrou com o esforço da batalha!");
                            inventarioPersonagem.descartarItem(armaRealSelecionada);
                        }

                    } else {
                        System.out.println("O item no índice " + indiceArmaSelecionada + " não é uma Arma ou o índice é inválido!");
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem();
                    break;

                case "3": // Abrir Inventário
                    inventarioPersonagem.mostrarInventario();
                    System.out.println("\nOpções do Inventário:");
                    System.out.println("1 - Ver inventário novamente");
                    System.out.println("2 - Usar/Selecionar Item");
                    System.out.println("3 - Descartar Item (pelo índice)");
                    System.out.println("4 - Ver detalhes de um Item (pelo índice)");
                    System.out.println("5 - Construir Item"); // << OPÇÃO DE CONSTRUIR NO INVENTÁRIO
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
                                inventarioPersonagem.mostrarItem(itemParaMostrar);
                            }
                            break;
                        case "5": // Construir Item
                            System.out.println("\n--- Oficina de Construção ---");
                            ArrayList<Receita> receitasDisponiveis = gerenciadorDeConstrucao.getReceitasDisponiveis(inventarioPersonagem, personagemEscolhido);

                            if (receitasDisponiveis.isEmpty()) {
                                System.out.println("Você não tem materiais (ou ferramentas) suficientes para construir nada no momento.");
                                //Aqui, 'break;' apenas sairia do switch do inventário. O jogador permaneceria no inventário.
                                break;
                            }

                            System.out.println("Receitas que você pode construir agora:");
                            for (int i = 0; i < receitasDisponiveis.size(); i++) {
                                Receita r = receitasDisponiveis.get(i);
                                System.out.println("\n[" + i + "] " + r.getNomeItemResultado());
                                System.out.print("    Requer: ");
                                boolean primeiroIngrediente = true;
                                for (Map.Entry<String, Integer> ingrediente : r.getIngredientesNecessarios().entrySet()) {
                                    if (!primeiroIngrediente) System.out.print(", ");
                                    System.out.print(ingrediente.getValue() + "x " + ingrediente.getKey());
                                    primeiroIngrediente = false;
                                }
                                if (r.getFerramentaNecessaria() != null && !r.getFerramentaNecessaria().isEmpty()) {
                                    System.out.print(" (Ferramenta: " + r.getFerramentaNecessaria() + ")");
                                }
                                System.out.println();
                            }

                            System.out.print("Digite o número da receita que deseja construir (ou -1 para cancelar): ");
                            int escolhaReceita;
                            if (usuario.hasNextInt()) {
                                escolhaReceita = usuario.nextInt();
                                usuario.nextLine();
                            } else {
                                System.out.println("Entrada inválida.");
                                usuario.nextLine();
                                break; //Sai da opção de construção, volta para o menu do inventário/principal
                            }

                            if (escolhaReceita == -1) {
                                System.out.println("Construção cancelada.");
                            } else if (escolhaReceita >= 0 && escolhaReceita < receitasDisponiveis.size()) {
                                Receita receitaSelecionada = receitasDisponiveis.get(escolhaReceita);
                                System.out.println("Você selecionou para construir: " + receitaSelecionada.getNomeItemResultado());
                                System.out.print("Confirmar construção? (s/n): ");
                                if (usuario.nextLine().trim().equalsIgnoreCase("s")) {
                                    Item itemConstruido = gerenciadorDeConstrucao.construirItem(receitaSelecionada, inventarioPersonagem, personagemEscolhido);
                                    if (itemConstruido != null) {
                                        System.out.println("Construção bem-sucedida!");
                                    } else {
                                        System.out.println("A construção não pôde ser concluída.");
                                    }
                                } else {
                                    System.out.println("Construção cancelada.");
                                }
                            } else {
                                System.out.println("Opção de receita inválida.");
                            }
                            break; // Sai da opção de construção (case "5" do inventário)
                        case "0":
                            System.out.println("Fechando inventário."); break;
                        default:
                            System.out.println("Opção inválida para o inventário.");
                            break;
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
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
                    personagemEscolhido.setSedePersonagem(personagemEscolhido.getSedePersonagem() - 8); // Assumindo que descansar consome um pouco
                    personagemEscolhido.setFomePersonagem(personagemEscolhido.getFomePersonagem() - 8);  // Assumindo que descansar consome um pouco
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem();
                    break;

                case "6": // Usar Habilidade Especial
                    if (personagemEscolhido.isHabilidadeEspecialJaUsada()) {
                        System.out.println("Você já utilizou sua poderosa habilidade especial nesta jornada!");
                        System.out.println("Ela é um trunfo de uso único.");
                        continue;
                    } else {
                        System.out.println("\n--- ATIVAR HABILIDADE ESPECIAL ---");
                        System.out.println("Sua Habilidade Especial: " + personagemEscolhido.getNomeHabilidadeEspecial());
                        System.out.println("Descrição: " + personagemEscolhido.getDescricaoHabilidadeEspecial());
                        System.out.println("\nLembre-se: Esta habilidade só pode ser usada UMA VEZ durante toda a sua jornada!");
                        System.out.print("Deseja realmente ativar sua habilidade especial agora? (s/n): ");
                        String confirmarHabilidade = usuario.nextLine().trim();

                        if (confirmarHabilidade.equalsIgnoreCase("s")) {
                            //Chamando o metodo da subclasse específica de Personagem
                            boolean sucessoAoAtivar = personagemEscolhido.ativarHabilidadeEspecial(eventoCriaturaAtual,ambienteAtual,gerenciadorDeItem,inventarioPersonagem);

                            if (sucessoAoAtivar) {
                                System.out.println("'" + personagemEscolhido.getNomeHabilidadeEspecial() + "' foi ativada com sucesso!");
                                personagemEscolhido.marcarHabilidadeEspecialComoUsada(); //Marca como usada
                                //Se a habilidade do Infiltrador ("Manto Etéreo") foi usada para escapar
                                if (personagemEscolhido instanceof personagens.Infiltrador && eventoCriaturaAtual != null) {
                                    System.out.println(">> Graças ao " + personagemEscolhido.getNomeHabilidadeEspecial() + ", o perigo de " + eventoCriaturaAtual.getNomeEvento() + " foi evitado! <<");
                                    eventoCriaturaAtual = null; // Finaliza o encontro com a criatura
                                    turnosDesdeEncontroCriatura = -1; // Reseta o timer
                                }
                            } else {
                                System.out.println("Não foi possível ativar a habilidade especial nas condições atuais ou a tentativa falhou.");
                            }
                        } else {
                            System.out.println("Você decidiu guardar sua habilidade especial para outra ocasião.");
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                            personagemEscolhido.statusPersonagem();
                            continue;
                        }
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                    personagemEscolhido.statusPersonagem();
                    break;

                default:
                    System.out.println("Comando inválido. Tente novamente.");
                    continue;
            } //Fim do Switch

            //Lógica: Fim de Turno para Criatura Encontrada:
            if (eventoCriaturaAtual != null && eventoCriaturaAtual.getVidaCriatura() > 0 && personagemVivo) {
                turnosDesdeEncontroCriatura++;
                if (turnosDesdeEncontroCriatura >= 3) {
                    System.out.println(">> " + eventoCriaturaAtual.getNomeEvento() + " se cansa de esperar e desaparece nas sombras... <<");
                    eventoCriaturaAtual = null;
                    turnosDesdeEncontroCriatura = -1;
                }
            }

            //Lógica: Item Aleatório por Turno
            if (personagemVivo) {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Ao final do turno, você faz uma busca rápida por recursos...");
                Item itemEncontradoTurno = gerenciadorDeItem.gerarItemAleatorioGlobal();

                if (itemEncontradoTurno != null) {
                    System.out.println("Você encontrou um(a) " + itemEncontradoTurno.getNomeItem() + ".");
                    System.out.print("Deseja pegar este item? (S/N): ");
                    String decisaoPegarItem = usuario.nextLine().trim();
                    if (decisaoPegarItem.equalsIgnoreCase("s")) {
                        if (inventarioPersonagem.adicionarItem(itemEncontradoTurno)) {
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
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            }//Fim da Lógica - Item aleatório por turno

            if (personagemVivo) {
                contadorTurnos++;
            }

        }//Fim do While (Loop Principal)

        if (!personagemVivo) {
            System.out.println("\nFim de jogo. O personagem não sobreviveu.");
        } else {
            System.out.println("\nParabéns! Você sobreviveu por " + turnosMaximos + " turnos!");
        }
        usuario.close();
    }
}
