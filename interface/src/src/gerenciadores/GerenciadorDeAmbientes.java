package gerenciadores;

import ambientes.*;
import eventos.Eventos;
import interfaces.AcoesGerenciadorDeAmbientes;
import personagens.Personagem;

import java.util.ArrayList;

public class GerenciadorDeAmbientes implements AcoesGerenciadorDeAmbientes {

    //Atributos da classe:
    //Removi o atributo ‘String’ climaGlobal, pois não era utilizado!
    private ArrayList<Ambientes> listaAmbientesDisponiveis;
    private ArrayList<Ambientes> historicoMovimentacao;
    //Eu não sei se declarar um atributo random é a melhor forma de fazer isso!!

    //Metodo construtor da classe:
    public GerenciadorDeAmbientes(ArrayList<Ambientes> listaAmbientesDisponiveis, ArrayList<Ambientes> historicoMovimentacao) {
        this.listaAmbientesDisponiveis = listaAmbientesDisponiveis; //O atributo no construtor deve estar dessa forma!!
        this.historicoMovimentacao = historicoMovimentacao;
    }

    //Metodos acessores:
    public void setListaAmbientesDisponiveis(ArrayList<Ambientes> listaAmbientesDisponiveis) {
        this.listaAmbientesDisponiveis = listaAmbientesDisponiveis;
    }
    public ArrayList<Ambientes> getListaAmbientesDisponiveis()  {
        return listaAmbientesDisponiveis;
    }
    public void setHistoricoMovimentacao(ArrayList<Ambientes> historicoMovimentacao) {
        this.historicoMovimentacao = historicoMovimentacao;
    }
    public ArrayList<Ambientes> getHistoricoMovimentacao() {
        return historicoMovimentacao;
    }

    //Metodos implementados:
    @Override
    public void mudarAmbiente(Personagem personagemAtual, Ambientes novoAmbiente) {
        System.out.println("Após uma longa jornada com obstáculos e desafios pelo caminho, " + personagemAtual.getNomePersonagem()
                + " chegou ao seu destino: " + novoAmbiente.getNomeAmbiente() +"!");
        personagemAtual.setLocalizacaoPersonagem(novoAmbiente.getNomeAmbiente());
        getHistoricoMovimentacao().add(novoAmbiente);
        //Temos que ver uma forma de registrar também o antigo ambiente!!
        //Precisamos modificar o atributo, para poder utilizar a classe e os seus métodos na classe Personagem
    }

    @Override
    public void gerarEvento(Ambientes ambienteAtual, Eventos eventoGerado) { //Metodo modificado!!
        //Esse metodo deverá ser revisto antes da sua implementação!!
    }

    @Override
    public void modificarRecursos(Ambientes ambienteAtual) {
        //Esse metodo será aprimorado a partir do desenvolvimento dos recursos e as suas relações com o ambiente
    }

    @Override
    public void gerarAmbientes() {
        //Floresta:
        AmbienteFloresta floresta = new AmbienteFloresta("Floresta de Skógrheimr", "Uma floresta antiga e viva, onde diz-se que os ventos sussurram em uma língua esquecida pelos homens." +
                " Espíritos da natureza e antigos guardiões habitam suas sombras. Reza a lenda que Dravnir, a Árvore do Mundo, projetava uma de suas raízes até aqui.",1, " ",
                2, "", false, false, false);
        //Montanha:
        AmbienteMontanha montanha = new AmbienteMontanha("Montanha de Hrafntindr", "Um pico escarpado perpetuamente coberto de neblina. Corvos negros o sobrevoam em círculos," +
                " e acredita-se que ali está enterrado um antigo Niðrys (gigante), guardado pelos próprios pássaros da fria Hrafntindr. Diz-se que a montanha guarda visões do futuro a quem sobrevive à escalada.",2, " ",
                2, "", false, false, false);
        //Caverna:
        AmbienteCaverna caverna = new AmbienteCaverna("Caverna de Djúpgandr", "Uma caverna úmida e abissal, lar de uma criatura serpentina esquecida pelas eras. Dizem os mais velhos que ela é um fragmento da própria Skarnir," +
                " a serpente sombria. Apenas os mais corajosos ou insensatos entram buscando o poder escondido em suas profundezas.",3, " ",
                2, "", false, false, false);

        //Lago:
        AmbienteLagoRio lagoRio = new AmbienteLagoRio("Lago de Mjarnvatn", "Um lago sereno e coberto por neblina eterna. Suas águas refletem o passado de quem ousa encará-las por muito tempo. É tido como um portal entre mundos," +
                " onde os deuses vêm observar os mortais em silêncio. Criaturas disturbadoras e visões encantadoras confundem os sentidos.",1, " ",
                2, "", false, false, false);

        //Ruínas:
        AmbienteRuinas ruinas = new AmbienteRuinas("Ruínas de Eldthórr", "Vestígios queimados de uma fortaleza ancestral forjada para resistir ao próprio Hecatombus (fim das eras). Muitos acreditam que Eldjarn lutou ali contra um exército de mortos," +
                " deixando sua marca cravada em rochas fundidas. Relíquias sagradas e amaldiçoadas jazem sob as cinzas.",3, " ",
                2, "", false, false, false);

        //Adicionando os Ambientes:
        this.getListaAmbientesDisponiveis().add(lagoRio); //Posição 0
        this.getListaAmbientesDisponiveis().add(floresta); //Posição 1
        this.getListaAmbientesDisponiveis().add(montanha);  //Posição 2
        this.getListaAmbientesDisponiveis().add(caverna);  //Posição 3
        this.getListaAmbientesDisponiveis().add(ruinas);   //Posição 4
    }
