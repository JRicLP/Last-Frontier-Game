package itens;

import eventos.EventoCriatura;
import interfaces.AcoesArmas;
import personagens.Personagem;

import java.util.Scanner;

public class Armas extends Item implements AcoesArmas {

    //Atributos da subclasse:
    private String tipoArma;
    private int danoArma;
    private int alcanceArma;

    //Metodo construtor:
    public Armas(String nomeItem, int pesoItem, int durabilidadeItem, String tipoArma, int danoArma, int alcanceArma) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoArma = tipoArma;
        this.danoArma = danoArma;
        this.alcanceArma = alcanceArma;
    }

    //Metodos acessores:
    public void setTipoArma(String tipoArma){
        this.tipoArma = tipoArma;
    }
    public String getTipoArma(){
        return tipoArma;
    }
    public void setDanoArma( int danoArma){
        this.danoArma = danoArma;
    }
    public int getDanoArma(){
        return danoArma;
    }
    public void setAlcanceArma(int alcanceArma){
        this.alcanceArma = alcanceArma;
    }
    public int getAlcanceArma(){
        return alcanceArma;
    }

    //Metodos implementados:
    @Override
    public void atacar(Personagem personagemEscolhido, EventoCriatura criaturaAtacada) { // Scanner passado como parâmetro

        System.out.println("Atacar um alvo consome Energia e utiliza pontos de Fome e Sede, além disso sua arma será desgastada!");
        System.out.println("Dano da sua arma ("+ this.getNomeItem() +"):" + this.getDanoArma());
        System.out.println("Vida da criatura ("+ criaturaAtacada.getTipoCriatura() +"):" + criaturaAtacada.getVidaCriatura());

        if (criaturaAtacada.getDistanciaCriatura() > this.getAlcanceArma()) {
            System.out.println("Alcance da sua Arma: " + this.getAlcanceArma());
            System.out.println("Distância da Criatura: " + criaturaAtacada.getDistanciaCriatura());
            System.out.println("Essa criatura não está no seu alcance, talvez seja melhor recuar e ficar mais forte!");
            return; //Finalizando aqui, caso a Criatura esteja fora de alcance, ai não ocorre o combate
        }

        System.out.println("Você cria coragem e parte para atacar " + criaturaAtacada.getTipoCriatura() + "!");

        boolean combateAtivo = true; // Flag de controle de combate

        //Aqui, estamos validando o Loop a partir da vida da Criatura, do Personagem ou da Flag de Combate
        while (criaturaAtacada.getVidaCriatura() > 0 && personagemEscolhido.getVidaPersonagem() > 0 && combateAtivo) {

            //Opções do Usuário:
            System.out.println("\nEscolha a sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Fugir");
            System.out.print("Opção: ");

            Scanner entradaUsuario = new Scanner(System.in);
            String opcaoUsuario = entradaUsuario.nextLine().trim();

            switch (opcaoUsuario) {
                case "1": // Atacar

                    //A Mecânica de Combate se inicia a partir daqui:

                    System.out.println("Você desferiu um ataque certeiro em " + criaturaAtacada.getTipoCriatura() + " e seu sangue jorrou!");
                    System.out.println("Seu ataque causou " + this.getDanoArma() + " de dano!");
                    criaturaAtacada.setVidaCriatura(criaturaAtacada.getVidaCriatura() - this.getDanoArma());
                    System.out.println("Vida da criatura: " + criaturaAtacada.getVidaCriatura());

                    //Caso a arma quebre:
                    this.setDurabilidadeItem(this.getDurabilidadeItem() - 2);
                    if (this.getDurabilidadeItem() <= 0) {
                        System.out.println("Atenção! Sua arma " + this.getNomeItem() + " quebrou!");
                    }

                    //Morte da Criatura que está sendo atacada:
                    if (criaturaAtacada.getVidaCriatura() <= 0) {
                        combateAtivo = false;
                        break;
                    }

                    //Criatura atacando de volta:
                    System.out.println("A criatura atacou você de volta, e causou: " + criaturaAtacada.getDanoCriatura() + " de dano, cuidado!!");
                    personagemEscolhido.setVidaPersonagem(personagemEscolhido.getVidaPersonagem() - criaturaAtacada.getDanoCriatura());
                    System.out.println("Sua vida: " + personagemEscolhido.getVidaPersonagem());

                    //Aqui, são feitos os desgastes nos Staus do Personagem:
                    personagemEscolhido.setEnergiaPersonagem(personagemEscolhido.getEnergiaPersonagem() - 3);
                    personagemEscolhido.setFomePersonagem(personagemEscolhido.getFomePersonagem() - 3);
                    personagemEscolhido.setSedePersonagem(personagemEscolhido.getSedePersonagem() - 3);

                    //Mostrando o Status do Personagem:
                    System.out.println("\nStatus de Batalha:");
                    System.out.println("Vida: " + personagemEscolhido.getVidaPersonagem());
                    System.out.println("Energia: " + personagemEscolhido.getEnergiaPersonagem());
                    System.out.println("Fome: " + personagemEscolhido.getFomePersonagem());
                    System.out.println("Sede: " + personagemEscolhido.getSedePersonagem());
                    System.out.println("Durabilidade da Arma (" + this.getNomeItem() + "): " + this.getDurabilidadeItem());

                    //Aqui, verificamos se o Personagem morreu:
                    if (personagemEscolhido.getVidaPersonagem() <= 0) {
                        System.out.println("A Criatura desferiu um golpe fatal e você morreu!!");
                        combateAtivo = false;
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
        //Mensagens de Resultado do Combate:
        if (criaturaAtacada.getVidaCriatura() <= 0 && personagemEscolhido.getVidaPersonagem() > 0) {
            System.out.println("Você venceu o combate e derrotou a criatura " + criaturaAtacada.getTipoCriatura() + "!");
        } else if (personagemEscolhido.getVidaPersonagem() <= 0) {
            System.out.println("Você foi derrotado em combate...");
        } else if (!combateAtivo) {
            System.out.println("Você conseguiu escapar do combate com " + criaturaAtacada.getTipoCriatura() + ".");
        }
    }
}
