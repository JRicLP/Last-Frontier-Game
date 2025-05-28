package gerenciadores;

import ambientes.*;
import eventos.*;
import interfaces.AcoesGerenciadorDeEventos;
import personagens.Personagem;

import java.util.ArrayList;
import java.util.Random;

public class GerenciadorDeEventos implements AcoesGerenciadorDeEventos {

    //Atributos da classe:
    //Removi o atributo int probabilidadeOcorrencia[], pois o mesmo não era utilizado
    private ArrayList<Eventos> listaEventosPossiveis;
    private ArrayList<Eventos> historicoEventos;

    //Metodo construtor:
    public GerenciadorDeEventos(ArrayList<Eventos> listaEventosPossiveis, ArrayList<Eventos> historicoEventos) {
        this.listaEventosPossiveis = listaEventosPossiveis;
        this.historicoEventos = historicoEventos;
    }

    //Metodos acessores:
    public void setListaEventosPossiveis(ArrayList <Eventos>listaEventosPossiveis) {
        this.listaEventosPossiveis = listaEventosPossiveis;
    }
    public ArrayList<Eventos> getListaEventosPossiveis() {
        return listaEventosPossiveis;
    }
    public void setHistoricoEventos(ArrayList<Eventos> historicoEventos) {
        this.historicoEventos = historicoEventos;
    }
    public ArrayList<Eventos> getHistoricoEventos() {
        return historicoEventos;
    }

    //Metodos implementados:

    //Retirei o metodo sortearEvento(); pois o mesmo não estava se encaixando na lógica do jogo

    @Override
    public void aplicarEvento(Personagem personagemAtual, Eventos eventoAplicado) {
        if (eventoAplicado.isCondicaoEvento()) { //Verifica se a condição necessária para o evento está ativa
            System.out.println("O personagem " + personagemAtual.getNomePersonagem() + " está sofrendo as consequências de: " + eventoAplicado.getNomeEvento());
        }
        //Tem que aplicar no personagem, será evoluído
        //Essa aplicação será relacionada a um atributo dos itens (Eu acho)
    }

    @Override
    public void removerEvento(Eventos eventoAtual) {
        System.out.println("O evento " + eventoAtual.getNomeEvento() + "foi removido com sucesso!!");
    }

    //Metodos para gerar os objetos:

    // Gerando Eventos Criaturas:
    public EventoCriatura gerarEventosCriatura() {
        EventoCriatura cervo = new EventoCriatura("Hjarnhyrndr", "Um cervo de pelagem prateada e chifres de cristal gélido. Dizem que ele aparece apenas sob a luz da lua cheia em florestas sagradas. É símbolo de equilíbrio, e caçá-lo é considerado blasfêmia.",
                2, "O encontro com criaturas possibilita a obtenção de recursos", false, "Criatura Neutra", 25, 5, 0, 2);
        EventoCriatura serpente = new EventoCriatura("Niðkrága", "Uma serpente subterrânea que se move por vibrações no solo. Ela cospe uma névoa negra que cega e sufoca. Suas escamas são procuradas para rituais de invisibilidade",
                2, "O encontro com criaturas possibilita a obtenção de recursos", false, "Criatura Hostil", 35, 10, 5, 5);
        EventoCriatura corvo = new EventoCriatura("Veðrhrafn", "Um corvo colossal com penas de trovão e olhos de relâmpago. Anuncia grandes mudanças ou batalhas. A presença de um Veðrhrafn pode significar bênção divina... ou desgraça inevitável.",
                2, "O encontro com criaturas possibilita a obtenção de recursos", false, "Criatura Neutra", 40, 10, 0, 2);
        EventoCriatura javali = new EventoCriatura("Grimsvártr", "Um javali titânico coberto de espinhos ósseos. Habita vales escuros e ruínas esquecidas. Quando furioso, seu grito ecoa por quilômetros e provoca avalanches.",
                2, "O encontro com criaturas possibilita a obtenção de recursos", false, "Criatura Hostil", 40, 15, 10, 10);
        EventoCriatura peixe = new EventoCriatura("Silfurskyn", "Um peixe raro que brilha com luz própria em lagos encantados como Mjarnvatn. Quem o captura e o liberta pode receber sonhos proféticos. Comer sua carne, no entanto, causa loucura.",
                2, "O encontro com criaturas possibilita a obtenção de recursos", false, "Criatura Pacífica", 10, 5, 0, 2);
        EventoCriatura lobo = new EventoCriatura("Draugrulfr", "Lobo espectral que aparece onde o véu entre mundos se rompe. Seus olhos ardem com chamas verdes e seu uivo atrai os mortos inquietos. Imune a armas normais, só teme fogo.",
                2, "O encontro com criaturas possibilita a obtenção de recursos", false, "Criatura Hostil", 20, 5, 5, 5);
        EventoCriatura cabra = new EventoCriatura("Tindgeit", "Cabra das montanhas com patas afiadas como ganchos e pelo que muda de cor com o clima. É usada por caçadores e clérigos como guia em regiões traiçoeiras.",
                2, "O encontro com criaturas possibilita a obtenção de recursos", false, "Criatura Neutra", 15, 5, 0, 2);
        EventoCriatura aranha = new EventoCriatura("Skuggadraugr", "Uma criatura que vive entre as sombras de ruínas e cavernas profundas. Não tem forma definida — apenas olhos vermelhos pairando na escuridão. Alimenta-se de medo. Matar uma exige luz.",
                2, "O encontro com criaturas possibilita a obtenção de recursos", false, "Criatura Hostil", 15, 10, 10, 10);
        EventoCriatura guerreiroCorrompido = new EventoCriatura("Skarnvaldr", "Um antigo guerreiro-sacerdote banido pelos próprios deuses após desafiar os Pactos do Céu. Usa uma armadura corroída por raios e carrega uma lança de obsidiana viva chamada Mjarkfjaldr." +
                " Ele percorre as montanhas e ruínas em busca de relíquias perdidas, amaldiçoando qualquer um que cruze seu caminho com visões de agonia eterna.", 2, "O encontro com entidades humanas permite a obtenção de recursos ou batalhas", false,
                "Humano hostil", 60, 25, 20, 20);
        EventoCriatura guardiaDoLago = new EventoCriatura("Yndra Sædis", "Uma mulher idosa que vive isolada às margens do lago Mjarnvatn. É uma vidente silenciosa, conhecida por ouvir os sussurros da névoa. Acredita-se que Yndra seja filha de um deus e uma mortal," +
                " com sangue de tempo em suas veias. Aqueles que buscam respostas em seus sonhos costumam procurá-la — mas ela só fala em enigmas.", 2, "O encontro com entidades humanas permite a obtenção de recursos ou batalhas", false,
                "Humano pacífico", 80, 0, 0, 40);
        //Adicionando na lista conforme as probabilidades de cada Evento Criatura:
        //Inicialmente, vou fazer uma Probabilidade Forçada Simples, com a mesma chance para todos os elementos:
        EventoCriatura[] listaEventosCriatura = {cervo, serpente, corvo, javali, peixe, lobo, cabra, aranha, guardiaDoLago, guerreiroCorrompido};
        //Sorteio do Evento:
        Random sorteador = new Random();
        int indiceSorteado = sorteador.nextInt(listaEventosCriatura.length);
        EventoCriatura eventoSorteado = listaEventosCriatura[indiceSorteado];
        //Mostrando o Evento sorteado:
        System.out.println("Uma criatura apareceu: " + eventoSorteado.getNomeEvento());
        System.out.println("Descrição: " + eventoSorteado.getDescricaoEvento());
        //Adicionando ao Histórico de Eventos:
        this.listaEventosPossiveis.add(eventoSorteado);
        this.historicoEventos.add(eventoSorteado);
        //Retornando a Criatura:
        return eventoSorteado;
    }

    //Gerando Eventos Descoberta:
    public EventoDescoberta gerarEventosDescoberta() {
        EventoDescoberta bauPerdido = new EventoDescoberta("Bau Perdido", "Um antigo baú esquecido pelos corajosos exploradores de uma era passada", 3,
                "Descobertas recuperam o folego do personagem, um pouco de energia e sede serão regenerados", true, "Combináveis e Equipáveis", "Materiais, Ferramentas ou Armas", false);
        EventoDescoberta caixaDeSuprimentos = new EventoDescoberta("Caixa de Suprimentos", "Uma caixa de suprimentos deixada para trás, parece que era parte de um antigo vilarejo da região", 4,
                "Caixas de Suprimentos recuperam Sede, Fome e um pouco de Sanidade!", true, "Consumíveis", "Alimentos, Agua", false);
        EventoDescoberta ervasMedicinais = new EventoDescoberta("Ervas Medicinais", "Um conjunto de pequenas folhas e ramos com propriedades curativas, fazem parte da natureza do local", 3,
                "Ervas Medicinais recuperam a Saúde do personagem e dão um pouco de esperança, recuperando a Sanidade", true, "Consumíveis", "Remédios", false);
        EventoDescoberta destrocosRuinas = new EventoDescoberta("Destroços de Ruínas", "Alguns materiais conseguiram resistir ao tempo e ao intenso fevor dessa ruína, pode haver algo de útil nesse meio", 2,
                "Destroços são importantes fontes de materiais, quem sabe até ferramentas ou armas!", true, "Combináveis e Equipáveis", "Materiais, Ferramentas ou Armas", false);
        EventoDescoberta jarrosConserva = new EventoDescoberta("Jarros de Conserva", "Os antigos Jarros de Conserva eram utilizados para armazenar diversos recursos por décadas, talvez ainda tenha algo útil",
                2, "Jarros de Conserva são uma ótima fonte de recursos, se encontrar um deles não irá passar necessidades", true, "Consumíveis", "Alimentos, Água, Remédios", false);
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
        this.listaEventosPossiveis.add(eventoSorteado);
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
        this.listaEventosPossiveis.add(eventoSorteado);
        this.historicoEventos.add(eventoSorteado);
        //Retornando a Doença/Ferimento:
        return eventoSorteado;

    }

    //Os Eventos Climáticos Não Padrão não serão sorteados
    //Gerando Eventos Climáticos:
    public EventoClimatico gerarEventosClimaticos(Ambientes ambienteAtual) {

        if (ambienteAtual instanceof AmbienteFloresta) {
            //Clima padrão - Floresta:
            EventoClimatico climaFloresta = new EventoClimatico("Skógrgufa", "Um clima úmido e perenemente enevoado. A luz do sol raramente atravessa o véu de névoa azulada que dança entre as copas." +
                    " Chuva fina e sussurros no vento são constantes — alguns dizem que são vozes de espíritos.", 2, " ", false, " ", 3, " ");
            EventoClimatico climaVariadoUm = new EventoClimatico("Vindkaldr", "Correntes de ar gelado uivam pelas encostas, trazendo consigo flocos de neve mesmo fora do inverno." +
                    " Relâmpagos secos cortam os céus em noites silenciosas, como se os deuses estivessem em guerra.", 2, " ", false, " ", 3, " ");
            EventoClimatico climaVariadoDois = new EventoClimatico("Stormvǫr", "Céus permanentemente carregados, com nuvens escuras e trovões que rugem como bestas distantes. Ventos fortes e chuvas intensas surgem sem aviso." +
                    " É dito que esse clima ocorre onde antigos deuses travaram batalhas e seus gritos ainda ecoam nos céus.", 2, " ", false, " ", 3, " ");
            //Sorteando o microclima:
            Random sorteador = new Random();
            EventoClimatico[] listaEventosClimaticos = {climaFloresta, climaVariadoUm, climaVariadoDois};
            int indiceSorteado = sorteador.nextInt(listaEventosClimaticos.length);
            EventoClimatico climaSorteado = listaEventosClimaticos[indiceSorteado];
            ambienteAtual.setClimaDominante(climaSorteado.getNomeEvento()); //Inicialmente, vamos tratar como String, mas mudaremos o atributo de Ambientes, posteriormente.
            System.out.println(climaSorteado.getNomeEvento() + "está acontecendo");
            System.out.println(climaSorteado.getDescricaoEvento());
            this.listaEventosPossiveis.add(climaSorteado);
            this.historicoEventos.add(climaSorteado);
            return climaSorteado;
        } else if (ambienteAtual instanceof AmbienteMontanha) {
            //Clima padrão - Montanha:
            EventoClimatico climaMontanha = new EventoClimatico("Hrímblóð", "Frio penetrante com ventos cortantes que parecem vivenciar uma vontade própria. Nevascas repentinas tomam tudo de surpresa," +
                    " e os flocos de neve caem como cinzas pálidas. Em algumas noites, formas espectrais são vistas caminhando pela neve.", 2, " ", false, " ", 3, " ");
            EventoClimatico climaVariadoUm = new EventoClimatico("Vindkaldr", "Correntes de ar gelado uivam pelas encostas, trazendo consigo flocos de neve mesmo fora do inverno." +
                    " Relâmpagos secos cortam os céus em noites silenciosas, como se os deuses estivessem em guerra.", 2, " ", false, " ", 3, " ");
            EventoClimatico climaVariadoDois = new EventoClimatico("Stormvǫr", "Céus permanentemente carregados, com nuvens escuras e trovões que rugem como bestas distantes. Ventos fortes e chuvas intensas surgem sem aviso." +
                    " É dito que esse clima ocorre onde antigos deuses travaram batalhas e seus gritos ainda ecoam nos céus.", 2, " ", false, " ", 3, " ");
            //Sorteando o microclima:
            Random sorteador = new Random();
            EventoClimatico[] listaEventosClimaticos = {climaMontanha, climaVariadoUm, climaVariadoDois};
            int indiceSorteado = sorteador.nextInt(listaEventosClimaticos.length);
            EventoClimatico climaSorteado = listaEventosClimaticos[indiceSorteado];
            ambienteAtual.setClimaDominante(climaSorteado.getNomeEvento());//Inicialmente, vamos tratar como String, mas mudaremos o atributo de Ambientes, posteriormente.
            System.out.println(climaSorteado.getNomeEvento() + "está acontecendo");
            System.out.println(climaSorteado.getDescricaoEvento());
            this.listaEventosPossiveis.add(climaSorteado);
            this.historicoEventos.add(climaSorteado);
            return climaSorteado;
        } else if (ambienteAtual instanceof AmbienteCaverna) {
            //Clima padrão - Caverna:
            EventoClimatico climaCaverna = new EventoClimatico("Myrrkuldi", "Nenhuma luz penetra a atmosfera opressiva. O ar é frio e úmido, com neblinas subterrâneas que condensam em gotas escuras." +
                    " Em seu interior, forma-se um microclima gélido e sufocante, como o hálito de um dragão adormecido.", 2, " ", false, " ", 3, " ");
            ambienteAtual.setClimaDominante(climaCaverna.getNomeEvento()); //Inicialmente, vamos tratar como String, mas mudaremos o atributo de Ambientes, posteriormente.
            System.out.println(climaCaverna.getNomeEvento() + "está acontecendo!");
            System.out.println(climaCaverna.getDescricaoEvento());
            this.listaEventosPossiveis.add(climaCaverna);
            this.historicoEventos.add(climaCaverna);
            return climaCaverna;

        } else if (ambienteAtual instanceof AmbienteRuinas) {
            //Clima padrão - Ruinas:
            EventoClimatico climaRuinas = new EventoClimatico("Eldrregn", "Um clima seco e instável. Raios solares intensos esquentam o solo enegrecido, e tempestades de cinzas surgem subitamente," +
                    " trazendo faíscas e ventos quentes. À noite, a temperatura despenca como se o próprio tempo congelasse.", 2, " ", false, " ", 3, " ");
            EventoClimatico climaVariadoUm = new EventoClimatico("Vindkaldr", "Correntes de ar gelado uivam pelas encostas, trazendo consigo flocos de neve mesmo fora do inverno." +
                    " Relâmpagos secos cortam os céus em noites silenciosas, como se os deuses estivessem em guerra.", 2, " ", false, " ", 3, " ");
            EventoClimatico climaVariadoDois = new EventoClimatico("Stormvǫr", "Céus permanentemente carregados, com nuvens escuras e trovões que rugem como bestas distantes. Ventos fortes e chuvas intensas surgem sem aviso." +
                    " É dito que esse clima ocorre onde antigos deuses travaram batalhas e seus gritos ainda ecoam nos céus.", 2, " ", false, " ", 3, " ");
            //Sorteando o microclima:
            Random sorteador = new Random();
            EventoClimatico[] listaEventosClimaticos = {climaRuinas, climaVariadoUm, climaVariadoDois};
            int indiceSorteado = sorteador.nextInt(listaEventosClimaticos.length);
            EventoClimatico climaSorteado = listaEventosClimaticos[indiceSorteado];
            ambienteAtual.setClimaDominante(climaSorteado.getNomeEvento()); //Inicialmente, vamos tratar como String, mas mudaremos o atributo de Ambientes, posteriormente.
            System.out.println(climaSorteado.getNomeEvento() + "está acontecendo");
            System.out.println(climaSorteado.getDescricaoEvento());
            this.listaEventosPossiveis.add(climaSorteado);
            this.historicoEventos.add(climaSorteado);
            return climaSorteado;
        } else if (ambienteAtual instanceof AmbienteLagoRio) {
            //Clima padrão - Lago:
            EventoClimatico climaLago = new EventoClimatico("Draumslóð", "Clima brando e misterioso, com névoa constante e ar parado. A umidade alta provoca ilusões ópticas, e o clima parece flutuar entre realidade e devaneio." +
                    " A brisa é suave, mas carrega murmúrios vindos do além.", 2, " ", false, " ", 3, " ");
            EventoClimatico climaVariadoUm = new EventoClimatico("Vindkaldr", "Correntes de ar gelado uivam pelas encostas, trazendo consigo flocos de neve mesmo fora do inverno." +
                    " Relâmpagos secos cortam os céus em noites silenciosas, como se os deuses estivessem em guerra.", 2, " ", false, " ", 3, " ");
            EventoClimatico climaVariadoDois = new EventoClimatico("Stormvǫr", "Céus permanentemente carregados, com nuvens escuras e trovões que rugem como bestas distantes. Ventos fortes e chuvas intensas surgem sem aviso." +
                    " É dito que esse clima ocorre onde antigos deuses travaram batalhas e seus gritos ainda ecoam nos céus.", 2, " ", false, " ", 3, " ");
            //Sorteando o microclima:
            Random sorteador = new Random();
            EventoClimatico[] listaEventosClimaticos = {climaLago, climaVariadoUm, climaVariadoDois};
            int indiceSorteado = sorteador.nextInt(listaEventosClimaticos.length);
            EventoClimatico climaSorteado = listaEventosClimaticos[indiceSorteado];
            ambienteAtual.setClimaDominante(climaSorteado.getNomeEvento()); //Inicialmente, vamos tratar como String, mas mudaremos o atributo de Ambientes, posteriormente.
            System.out.println("Clima " + climaSorteado.getNomeEvento() + "está acontecendo:");
            System.out.println(climaSorteado.getDescricaoEvento());
            this.listaEventosPossiveis.add(climaSorteado);
            this.historicoEventos.add(climaSorteado);
            return climaSorteado;
        }
        return null;
    }
}