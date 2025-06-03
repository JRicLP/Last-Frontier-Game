package gerenciadores;

import ambientes.*;
import eventos.*;
import interfaces.AcoesGerenciadorDeEventos;
import personagens.Personagem;

import java.util.ArrayList;
import java.util.Random;

public class GerenciadorDeEvento implements AcoesGerenciadorDeEventos {

    //Atributos da classe:

    //Removi o atributo int probabilidadeOcorrencia[], pois o mesmo não era utilizado
    private ArrayList<Evento> listaEventoPossiveis;
    private ArrayList<Evento> historicoEventos;

    //Metodo construtor:
    public GerenciadorDeEvento(ArrayList<Evento> listaEventoPossiveis, ArrayList<Evento> historicoEventos) {
        this.listaEventoPossiveis = listaEventoPossiveis;
        this.historicoEventos = historicoEventos;
    }

    //Metodos acessores:
    public void setListaEventosPossiveis(ArrayList <Evento> listaEventoPossiveis) {
        this.listaEventoPossiveis = listaEventoPossiveis;
    }
    public ArrayList<Evento> getListaEventosPossiveis() {
        return listaEventoPossiveis;
    }
    public void setHistoricoEventos(ArrayList<Evento> historicoEventos) {
        this.historicoEventos = historicoEventos;
    }
    public ArrayList<Evento> getHistoricoEventos() {
        return historicoEventos;
    }

    //Metodos implementados:

    //Retirei o metodo sortearEvento(); pois o mesmo não estava se encaixando na lógica do jogo

    @Override
    public void aplicarEvento(Personagem personagemAtual, Evento eventoAplicado) {
        if (eventoAplicado.isCondicaoEvento()) { //Verifica se a condição necessária para o evento está ativa
            System.out.println("O personagem " + personagemAtual.getNomePersonagem() + " está sofrendo as consequências de: " + eventoAplicado.getNomeEvento());
        }
    }

    @Override
    public void removerEvento(Evento eventoAtual) {
        System.out.println("O evento " + eventoAtual.getNomeEvento() + "foi removido com sucesso!!");
    }

    //Metodos para gerar os objetos:

    public EventoCriatura gerarEventosCriatura() {
        //1: Definir as instâncias de EventoDoencaFerimento que serão usadas:
        EventoDoencaFerimento efeitoFrostseidr = new EventoDoencaFerimento("Frostseidr",
                "O toque gelado de seus chifres pode causar um entorpecimento místico. A pele perde cor e a pessoa sente emoções com menos intensidade, como se estivesse congelando por dentro.",
                2, "Congelamento e torpor.", false, "Corte e Feitiço", "Ilusão e Hemorragia", true);

        EventoDoencaFerimento efeitoSotnblar = new EventoDoencaFerimento("Sotnblár",
                "A mordida da serpente Niðkrága deixa veias azul-escuras ao redor da ferida. A vítima perde a visão por algumas horas e sente uma dormência crescente nos membros.",
                2, "Envenenamento agudo.", false, "Envenenamento", "Cegueira, Perca de Energia", true);

        EventoDoencaFerimento efeitoAldrgata = new EventoDoencaFerimento("Aldrgáta",
                "Dizem que quem cruza o olhar direto de um Veðrhrafn recebe visões do seu próprio fim. A mente enfraquece, e testes de coragem ou sabedoria tornam-se mais difíceis por um tempo.",
                2, "Visões premonitórias.", false, "Feitiço", "Ilusão", true);

        EventoDoencaFerimento efeitoDrottarskor = new EventoDoencaFerimento("Dróttarskör",
                "Um ferimento profundo e irregular causado por seus chifres ósseos. Nunca cicatriza completamente, e a dor retorna em noites de lua cheia.",
                2, "Ferimento grave.", false, "Corte", "Hemorragia", true);

        EventoDoencaFerimento efeitoHundraugr = new EventoDoencaFerimento("Húndraugr",
                "Um arranhão quase imperceptível que infecciona com rapidez sobrenatural. Após três dias, o ferido começa a sonhar com terras mortas e ouvir uivos em pleno dia.",
                2, "Infecção espectral.", false, "Corte", "Ilusão e Hemorragia", true);

        EventoDoencaFerimento efeitoSkuggbrandr = new EventoDoencaFerimento("Skuggbrandr",
                "Um frio que se espalha pela pele e nunca aquece. Quem carrega a marca ouve sussurros constantes e tem dificuldade para dormir. Pode evoluir para loucura se não for purificada.",
                2, "Terror e paranoia.", false, "Feitiço", "Ilusão", true);

        //2: Instanciar as Criaturas, passando o EventoDoencaFerimento apropriado:
        EventoCriatura cervo = new EventoCriatura("Hjarnhyrndr", "Um cervo de pelagem prateada...",
                2, "Encontro majestoso.", false, "Criatura Neutra", 25, 5, 0, 2,
                efeitoFrostseidr);

        EventoCriatura serpente = new EventoCriatura("Niðkrága", "Uma serpente subterrânea...",
                2, "Perigo venenoso.", false, "Criatura Hostil", 35, 10, 5, 5,
                efeitoSotnblar);

        EventoCriatura corvo = new EventoCriatura("Veðrhrafn", "Um corvo colossal...",
                2, "Presságio nos céus.", false, "Criatura Neutra", 40, 10, 0, 2,
                efeitoAldrgata);

        EventoCriatura javali = new EventoCriatura("Grimsvártr", "Um javali titânico...",
                2, "Fúria indomável.", false, "Criatura Hostil", 40, 15, 10, 10,
                efeitoDrottarskor);

        EventoCriatura lobo = new EventoCriatura("Draugrulfr", "Lobo espectral...",
                2, "Uivo da tumba.", false, "Criatura Hostil", 20, 5, 5, 5,
                efeitoHundraugr);

        EventoCriatura aranha = new EventoCriatura("Skuggadraugr", "Uma criatura que vive entre as sombras...",
                2, "Terror Aracnídeo.", false, "Criatura Hostil", 15, 10, 10, 10,
                efeitoSkuggbrandr);

        // Criaturas restantes que não têm um efeito colateral definido (passando null):
        EventoCriatura peixe = new EventoCriatura("Silfurskyn", "Um peixe raro que brilha...",
                2, "Vislumbre aquático.", false, "Criatura Pacífica", 10, 5, 0, 2,
                null);

        EventoCriatura cabra = new EventoCriatura("Tindgeit", "Cabra das montanhas...",
                2, "Agilidade nas alturas.", false, "Criatura Neutra", 15, 5, 0, 2,
                null);

        EventoCriatura guerreiroCorrompido = new EventoCriatura("Skarnvaldr", "Um antigo guerreiro-sacerdote...",
                2, "Desafio ancestral.", false, "Humano hostil", 60, 25, 20, 20,
                null);

        EventoCriatura guardiaDoLago = new EventoCriatura("Yndra Sædis", "Uma mulher idosa que vive isolada...",
                2, "Encontro enigmático.", false, "Humano pacífico", 80, 0, 0, 40,
                null);
        //Adicionando na lista conforme as probabilidades de cada Evento Descoberta:
        //Inicialmente, vou fazer uma Probabilidade Forçada Simples, com a mesma chance para todos os elementos:
        EventoCriatura[] listaEventosCriatura = {cervo, serpente, corvo, javali, peixe, lobo, cabra, aranha, guardiaDoLago, guerreiroCorrompido};
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaEventosCriatura.length);
        EventoCriatura eventoSorteado = listaEventosCriatura[indiceSorteado];

        System.out.println("Uma criatura apareceu: " + eventoSorteado.getNomeEvento() + " (" + eventoSorteado.getTipoCriatura() + ")");
        System.out.println("Descrição: " + eventoSorteado.getDescricaoEvento());

        this.historicoEventos.add(eventoSorteado);
        this.listaEventoPossiveis.add(eventoSorteado);

        return eventoSorteado;
    }

    //Gerando Eventos Descoberta:
    public EventoDescoberta gerarEventosDescoberta() {
        EventoDescoberta bauPerdido = new EventoDescoberta("Bau Perdido", "Um antigo baú esquecido pelos corajosos exploradores de uma era passada", 3,
                "Descobertas recuperam o folego do personagem, um pouco de energia e sede serão regenerados", true, "Combináveis e Equipáveis", "Material, Ferramenta, Arma", false);
        EventoDescoberta caixaDeSuprimentos = new EventoDescoberta("Caixa de Suprimentos", "Uma caixa de suprimentos deixada para trás, parece que era parte de um antigo vilarejo da região", 4,
                "Caixas de Suprimentos recuperam Sede, Fome e um pouco de Sanidade!", true, "Consumíveis", "Alimento, Agua", false);
        EventoDescoberta ervasMedicinais = new EventoDescoberta("Ervas Medicinais", "Um conjunto de pequenas folhas e ramos com propriedades curativas, fazem parte da natureza do local", 3,
                "Ervas Medicinais recuperam a Saúde do personagem e dão um pouco de esperança, recuperando a Sanidade", true, "Consumíveis", "Remedio", false);
        EventoDescoberta destrocosRuinas = new EventoDescoberta("Destroços de Ruínas", "Alguns materiais conseguiram resistir ao tempo e ao intenso fevor dessa ruína, pode haver algo de útil nesse meio", 2,
                "Destroços são importantes fontes de materiais, quem sabe até ferramentas ou armas!", true, "Combináveis e Equipáveis", "Material, Ferramenta, Arma", false);
        EventoDescoberta jarrosConserva = new EventoDescoberta("Jarros de Conserva", "Os antigos Jarros de Conserva eram utilizados para armazenar diversos recursos por décadas, talvez ainda tenha algo útil",
                2, "Jarros de Conserva são uma ótima fonte de recursos, se encontrar um deles não irá passar necessidades", true, "Consumíveis", "Alimento, Agua, Remedio", false);
        //Adicionando na lista conforme as probabilidades de cada Evento Descoberta:
        //Inicialmente, vou fazer uma Probabilidade Forçada Simples, com a mesma chance para todos os elementos:
        EventoDescoberta[] listaEventosDescoberta = {bauPerdido, caixaDeSuprimentos, ervasMedicinais, destrocosRuinas, jarrosConserva};
        //Sorteio do Evento:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaEventosDescoberta.length);
        EventoDescoberta eventoSorteado = listaEventosDescoberta[indiceSorteado];
        //Mostrando o Evento sorteado:
        System.out.println("Você encontrou um tesouro: " + eventoSorteado.getNomeEvento());
        System.out.println("Descrição: " + eventoSorteado.getDescricaoEvento());
        //Adicionando ao Histórico de Eventos:
        this.listaEventoPossiveis.add(eventoSorteado);
        this.historicoEventos.add(eventoSorteado);
        //Retornando a Descoberta
        return eventoSorteado;
    }

    //Gerando Eventos de Doença e Ferimento:
    public EventoDoencaFerimento gerarEventoDoencaFerimento() {
        //Mordida da Cobra:
        EventoDoencaFerimento mordida = new EventoDoencaFerimento("Sotnblár", "A mordida da serpente Niðkrága deixa veias azul-escuras ao redor da ferida. A vítima perde a visão por algumas horas e sente uma dormência crescente nos membros.", 2,
                " ", false, "Envenenamento", "Cegueira, Perca de Energia", true);
        //Chifrada do Javali:
        EventoDoencaFerimento chifrada = new EventoDoencaFerimento("Dróttarskör", "Um ferimento profundo e irregular causado por seus chifres ósseos. Nunca cicatriza completamente, e a dor retorna em noites de lua cheia.", 2,
                " ", false, "Corte", "Hemorragia", true);
        //Contato com a Aranha:
        EventoDoencaFerimento contato = new EventoDoencaFerimento("Skuggbrandr", "Um frio que se espalha pela pele e nunca aquece. Quem carrega a marca ouve sussurros constantes e tem dificuldade para dormir. Pode evoluir para loucura se não for purificada.", 2,
                " ", false, "Feitiço", "Ilusão", true);
        //Arranhão do Lobo:
        EventoDoencaFerimento arranhao = new EventoDoencaFerimento("Húndraugr", "Um arranhão quase imperceptível que infecciona com rapidez sobrenatural. Após três dias, o ferido começa a sonhar com terras mortas e ouvir uivos em pleno dia.", 2,
                " ", false, "Corte", "Ilusão e Hemorragia", true);
        //Olhar do Pássaro:
        EventoDoencaFerimento olhar = new EventoDoencaFerimento("Aldrgáta", "Dizem que quem cruza o olhar direto de um Veðrhrafn recebe visões do seu próprio fim. A mente enfraquece, e testes de coragem ou sabedoria tornam-se mais difíceis por um tempo.", 2,
                " ", false, "Feitiço", "Ilusão", true);
        //Toque do Cervo:
        EventoDoencaFerimento toque = new EventoDoencaFerimento("Frostseidr", "O toque gelado de seus chifres pode causar um entorpecimento místico. A pele perde cor e a pessoa sente emoções com menos intensidade, como se estivesse congelando por dentro.", 2,
                " ", false, "Corte e Feitiço", "Ilusão e Hemorragia", true);
        //Adicionando na lista conforme as probabilidades de cada Evento Descoberta:
        //Inicialmente, vou fazer uma Probabilidade Forçada Simples, com a mesma chance para todos os elementos:
        EventoDoencaFerimento[] listaEventosDoencaFerimento = {mordida, chifrada, contato, arranhao, olhar, toque};
        //Sorteio do Evento:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaEventosDoencaFerimento.length);
        EventoDoencaFerimento eventoSorteado = listaEventosDoencaFerimento[indiceSorteado];
        //Mostrando o Evento sorteado:
        System.out.println("Você está se sentindo mal: " + eventoSorteado.getNomeEvento() + " atingiu-o!");
        System.out.println("Descrição: " + eventoSorteado.getDescricaoEvento());
        //Adicionando ao Histórico de Eventos:
        this.listaEventoPossiveis.add(eventoSorteado);
        this.historicoEventos.add(eventoSorteado);
        //Retornando a Doença/Ferimento:
        return eventoSorteado;

    }

    //Gerando Eventos Climáticos:
    public EventoClimatico gerarEventosClimaticos(Ambiente ambienteAtual) {
        Random sorteador = new Random();
        EventoClimatico climaSorteado = null;

        // Valores padrão para parâmetros do construtor de EventoClimatico:
        int probPadrao = 2;
        boolean condPadrao = true;
        int duracaoPadrao = 1;

        //Definição dos Climas com os seus Impactos Específicos:

        //Climas Comuns:
        EventoClimatico vindkaldr = new EventoClimatico("Vindkaldr", "Correntes de ar gelado uivam pelas encostas, trazendo consigo flocos de neve mesmo fora do inverno. Relâmpagos secos cortam os céus em noites silenciosas, como se os deuses estivessem em guerra.",
                probPadrao, "Frio intenso que drena energia e aumenta a fome.", condPadrao,
                "Frio", duracaoPadrao, "Efeito de frio moderado.",
                0, -5, 0, -10, 0);
        EventoClimatico stormvor = new EventoClimatico("Stormvǫr", "Céus permanentemente carregados, com nuvens escuras e trovões que rugem como bestas distantes. Ventos fortes e chuvas intensas surgem sem aviso. É dito que esse clima ocorre onde antigos deuses travaram batalhas e seus gritos ainda ecoam nos céus.",
                probPadrao, "Tempestade que afeta a sanidade e a energia.", condPadrao,
                "Tempestade", duracaoPadrao, "Efeito de tempestade moderada.",
                0, 0, 0, -7, -10);

        //Lógica de Geração baseada no Ambiente Atual:
        switch (ambienteAtual) {
            case AmbienteFloresta ambienteFloresta -> {
                //Clima Padrão do Ambiente + 2 Climas Comuns:
                EventoClimatico floresta = new EventoClimatico("Skógrgufa", "Um clima úmido e perenemente enevoado. A luz do sol raramente atravessa o véu de névoa azulada que dança entre as copas. Chuva fina e sussurros no vento são constantes — alguns dizem que são vozes de espíritos.",
                        probPadrao, "Névoa densa que afeta levemente a sanidade.", condPadrao,
                        "Névoa", duracaoPadrao, "Efeito de névoa leve.",
                        0, 0, 0, -2, -5);
                EventoClimatico[] listaEventosClimaticos = {floresta, vindkaldr, stormvor};
                climaSorteado = listaEventosClimaticos[sorteador.nextInt(listaEventosClimaticos.length)];

            }
            case AmbienteMontanha ambienteMontanha -> {
                //Clima Padrão do Ambiente + 2 Climas Comuns:
                EventoClimatico montanha = new EventoClimatico("Hrímblóð", "Frio penetrante com ventos cortantes que parecem vivenciar uma vontade própria. Nevascas repentinas tomam tudo de surpresa, e os flocos de neve caem como cinzas pálidas. Em algumas noites, formas espectrais são vistas caminhando pela neve.",
                        probPadrao, "Frio extremo que causa dano, drena muita energia e aumenta a fome.", condPadrao,
                        "Nevasca", duracaoPadrao, "Efeito de nevasca severa.",
                        -5, -8, 0, -15, -3);
                EventoClimatico[] listaEventosClimaticos = {montanha, vindkaldr, stormvor};
                climaSorteado = listaEventosClimaticos[sorteador.nextInt(listaEventosClimaticos.length)];

            }
            case AmbienteCaverna ambienteCaverna ->
                //Caverna - Clima Único:
                    climaSorteado = new EventoClimatico("Myrrkuldi", "Nenhuma luz penetra a atmosfera opressiva. O ar é frio e úmido, com neblinas subterrâneas que condensam em gotas escuras. Em seu interior, forma-se um microclima gélido e sufocante, como o hálito de um dragão adormecido.",
                            probPadrao, "Atmosfera opressora que afeta sanidade e energia.", condPadrao,
                            "Caverna Úmida", duracaoPadrao, "Efeito de ambiente fechado e frio.",
                            0, 0, 0, -7, -7);
            case AmbienteRuinas ambienteRuinas -> {
                //Clima Padrão do Ambiente + 2 Climas Comuns:
                EventoClimatico ruinas = new EventoClimatico("Eldrregn", "Um clima seco e instável. Raios solares intensos esquentam o solo enegrecido, e tempestades de cinzas surgem subitamente, trazendo faíscas e ventos quentes. À noite, a temperatura despenca como se o próprio tempo congelasse.",
                        probPadrao, "Clima instável que aumenta a sede e afeta a sanidade.", condPadrao,
                        "Aridez/Cinzas", duracaoPadrao, "Efeito de ambiente árido e poluído.",
                        0, 0, -10, 0, -5);
                EventoClimatico[] listaEventosClimaticos = {ruinas, vindkaldr, stormvor};
                climaSorteado = listaEventosClimaticos[sorteador.nextInt(listaEventosClimaticos.length)];

            }
            case AmbienteLagoRio lagoRio -> {
                //Clima Padrão do Ambiente + 2 Climas Comuns:
                EventoClimatico lago = new EventoClimatico("Draumslóð", "Clima brando e misterioso, com névoa constante e ar parado. A umidade alta provoca ilusões ópticas, e o clima parece flutuar entre realidade e devaneio. A brisa é suave, mas carrega murmúrios vindos do além.",
                        probPadrao, "Névoa misteriosa que afeta levemente a sanidade.", condPadrao,
                        "Névoa Mística", duracaoPadrao, "Efeito de névoa leve e ilusória.",
                        0, 0, +2, 0, -3);
                EventoClimatico[] listaEventosClimaticos = {lago, vindkaldr, stormvor};
                climaSorteado = listaEventosClimaticos[sorteador.nextInt(listaEventosClimaticos.length)];
            }
            case null, default -> {
                System.out.println("O tempo permanece neutro neste local desconhecido.");
                return null; // Retorna null se o tipo de ambiente não for reconhecido ou não tiver climas definidos
            }
        }

        if (climaSorteado != null) {
            ambienteAtual.setClimaDominante(climaSorteado.getNomeEvento());
            this.historicoEventos.add(climaSorteado);
            this.listaEventoPossiveis.add(climaSorteado);
        }
        return climaSorteado;
    }
}