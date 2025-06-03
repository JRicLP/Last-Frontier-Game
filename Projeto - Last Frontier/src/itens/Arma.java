package itens;

import eventos.EventoCriatura;
import eventos.EventoDoencaFerimento;
import interfaces.AcoesArmas;
import personagens.Personagem;
import ambientes.Ambiente;

import java.util.Random;
import java.util.Scanner;

public class Arma extends Item implements AcoesArmas {

    //Atributos da subclasse:
    private String tipoArma;
    private int danoArma;
    private int alcanceArma;

    //Metodo construtor:
    public Arma(String nomeItem, int pesoItem, int durabilidadeItem, String tipoArma, int danoArma, int alcanceArma) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoArma = tipoArma;
        this.danoArma = danoArma;
        this.alcanceArma = alcanceArma;
    }

    //Metodos acessores (existentes):
    public String getTipoArma(){ return tipoArma; }
    public void setTipoArma(String tipoArma){ this.tipoArma = tipoArma; }
    public int getDanoArma(){ return danoArma; }
    public void setDanoArma( int danoArma){ this.danoArma = danoArma; }
    public int getAlcanceArma(){ return alcanceArma; }
    public void setAlcanceArma(int alcanceArma){ this.alcanceArma = alcanceArma; }

    //Metodos implementados:
    @Override
    public void atacar(Personagem personagemEscolhido, EventoCriatura criaturaAtacada, Scanner entradaUsuario, Ambiente ambienteAtual) {

        System.out.println("Atacar um alvo consome Energia e utiliza pontos de Fome e Sede, além disso sua arma será desgastada!");
        System.out.println("Dano da sua arma ("+ this.getNomeItem() +"):" + this.getDanoArma());
        System.out.println("Vida da criatura ("+ criaturaAtacada.getTipoCriatura() +"):" + criaturaAtacada.getVidaCriatura());

        if (criaturaAtacada.getDistanciaCriatura() > this.getAlcanceArma()) {
            System.out.println("Alcance da sua Arma: " + this.getAlcanceArma());
            System.out.println("Distância da Criatura: " + criaturaAtacada.getDistanciaCriatura());
            System.out.println("Essa criatura não está no seu alcance, talvez seja melhor recuar e ficar mais forte!");
            return;
        }

        System.out.println("Você cria coragem e parte para atacar " + criaturaAtacada.getTipoCriatura() + "!");
        boolean combateAtivo = true;

        while (criaturaAtacada.getVidaCriatura() > 0 && personagemEscolhido.getVidaPersonagem() > 0 && combateAtivo) {
            System.out.println("\nEscolha a sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Fugir");
            System.out.print("Opção: ");
            String opcaoUsuario = entradaUsuario.nextLine().trim();

            switch (opcaoUsuario) {
                case "1": // Atacar
                    System.out.println("Você desferiu um ataque certeiro em " + criaturaAtacada.getTipoCriatura() + " e seu sangue jorrou!");
                    System.out.println("Seu ataque causou " + this.getDanoArma() + " de dano!");
                    criaturaAtacada.setVidaCriatura(criaturaAtacada.getVidaCriatura() - this.getDanoArma());
                    System.out.println("Vida da criatura: " + criaturaAtacada.getVidaCriatura());

                    this.setDurabilidadeItem(this.getDurabilidadeItem() - 2);
                    if (this.getDurabilidadeItem() <= 0) {
                        System.out.println("Atenção! Sua arma " + this.getNomeItem() + " quebrou!");
                    }

                    if (criaturaAtacada.getVidaCriatura() <= 0) {
                        combateAtivo = false; // Criatura derrotada
                        break; //Sai do switch, o loop while verificará a condição e terminará
                    }

                    //Criatura atacando de volta:
                    System.out.println("A criatura (" + criaturaAtacada.getNomeEvento() + ") atacou você de volta, e causou: " + criaturaAtacada.getDanoCriatura() + " de dano, cuidado!!");
                    personagemEscolhido.setVidaPersonagem(personagemEscolhido.getVidaPersonagem() - criaturaAtacada.getDanoCriatura());
                    System.out.println("Sua vida: " + personagemEscolhido.getVidaPersonagem());

                    if (personagemEscolhido.getVidaPersonagem() > 0) { //Só aplica se o personagem sobreviveu ao dano direto
                        EventoDoencaFerimento efeitoColateral = criaturaAtacada.getEfeitoColateralAtaque();
                        if (efeitoColateral != null) {
                            //Adicionando uma chance de aplicar o efeito:
                            Random rng = new Random();
                            int chanceDeAplicarEfeito = 50; // Ex: 50% de chance
                            if (rng.nextInt(100) < chanceDeAplicarEfeito) {
                                System.out.println("O ataque da criatura parece ter deixado um efeito nocivo...");
                                efeitoColateral.executar(personagemEscolhido, ambienteAtual);
                            } else {
                                System.out.println("Você conseguiu evitar o pior do ataque da criatura!");
                            }
                        }
                    }

                    //Desgastes nos Status do Personagem por estar em combate/atacar
                    personagemEscolhido.setEnergiaPersonagem(personagemEscolhido.getEnergiaPersonagem() - 3);
                    personagemEscolhido.setFomePersonagem(personagemEscolhido.getFomePersonagem() - 3);
                    personagemEscolhido.setSedePersonagem(personagemEscolhido.getSedePersonagem() - 3);

                    System.out.println("\nStatus de Batalha:");
                    System.out.println("Vida: " + personagemEscolhido.getVidaPersonagem() + "/" + personagemEscolhido.getVidaInicialPersonagem());
                    System.out.println("Energia: " + personagemEscolhido.getEnergiaPersonagem() + "/" + personagemEscolhido.getEnergiaInicialPersonagem());
                    System.out.println("Fome: " + personagemEscolhido.getFomePersonagem() + "/" + personagemEscolhido.getFomeInicialPersonagem());
                    System.out.println("Sede: " + personagemEscolhido.getSedePersonagem() + "/" + personagemEscolhido.getSedeInicialPersonagem());
                    System.out.println("Durabilidade da Arma (" + this.getNomeItem() + "): " + this.getDurabilidadeItem());

                    if (personagemEscolhido.getVidaPersonagem() <= 0) {
                        System.out.println("A Criatura desferiu um golpe fatal e você morreu!!");
                        combateAtivo = false; //Personagem derrotado
                    }
                    break;

                case "2": // Fugir
                    System.out.println("Você está fugindo do combate!!");
                    combateAtivo = false;
                    break;

                default:
                    System.out.println("Opção Inválida. Você hesita e perde uma oportunidade.");
                    break;
            }
        }
        // Fim do while de combate

        // Mensagens de Resultado do Combate:
        if (criaturaAtacada.getVidaCriatura() <= 0 && personagemEscolhido.getVidaPersonagem() > 0) {
            System.out.println("Você venceu o combate e derrotou a criatura " + criaturaAtacada.getTipoCriatura() + " (" + criaturaAtacada.getNomeEvento() + ")!");
        } else if (personagemEscolhido.getVidaPersonagem() <= 0) {
            System.out.println("Você foi derrotado em combate...");
        } else if (!combateAtivo) { //Chega aqui se fugiu e ambos estão vivos
            System.out.println("Você conseguiu escapar do combate com " + criaturaAtacada.getTipoCriatura() + " (" + criaturaAtacada.getNomeEvento() + ").");
        }
    }
}