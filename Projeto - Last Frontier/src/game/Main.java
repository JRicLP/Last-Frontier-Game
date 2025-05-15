package game;

import ambientes.*;
import eventos.*;
import gerenciadores.*;
import inventario.Inventario;
import itens.*;
import personagens.*;
import java.util.ArrayList;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        //Ambientes:

        //Floresta:
        AmbienteFloresta floresta = new AmbienteFloresta("Floresta de Skógrheimr", "Uma floresta antiga e viva, onde diz-se que os ventos sussurram em uma língua esquecida pelos homens." +
                " Espíritos da natureza e antigos guardiões habitam suas sombras. Reza a lenda que Dravnir, a Árvore do Mundo, projetava uma de suas raízes até aqui.",1, " ",
                 2, "Ensolarado Ameno", false, false, false);
        //Montanha:
        AmbienteMontanha montanha = new AmbienteMontanha("Montanha de Hrafntindr", "Um pico escarpado perpetuamente coberto de neblina. Corvos negros o sobrevoam em círculos," +
                " e acredita-se que ali está enterrado um antigo Niðrys (gigante), guardado pelos próprios pássaros da fria Hrafntindr. Diz-se que a montanha guarda visões do futuro a quem sobrevive à escalada.",2, " ",
                2, "Nevado Eterno", false, false, false);
        //Caverna:
        AmbienteCaverna caverna = new AmbienteCaverna("Caverna de Djúpgandr", "Uma caverna úmida e abissal, lar de uma criatura serpentina esquecida pelas eras. Dizem os mais velhos que ela é um fragmento da própria Skarnir," +
                " a serpente sombria. Apenas os mais corajosos ou insensatos entram buscando o poder escondido em suas profundezas.",3, " ",
                2, "Sombra do Orvalho", false, false, false);
        //Ruínas:
        AmbienteRuinas ruinas = new AmbienteRuinas("Ruínas de Eldthórr", "Vestígios queimados de uma fortaleza ancestral forjada para resistir ao próprio Hecatombus (fim das eras). Muitos acreditam que Eldjarn lutou ali contra um exército de mortos," +
                " deixando sua marca cravada em rochas fundidas. Relíquias sagradas e amaldiçoadas jazem sob as cinzas.",3, " ",
                2, "Sombra do Orvalho", false, false, false);
        //Lago:
        AmbienteLagoRio lagoRio = new AmbienteLagoRio("Lago de Mjarnvatn", "Um lago sereno e coberto por neblina eterna. Suas águas refletem o passado de quem ousa encará-las por muito tempo. É tido como um portal entre mundos," +
                " onde os deuses vêm observar os mortais em silêncio. Criaturas disturbadoras e visões encantadoras confundem os sentidos.",1, " ",
                2, "Neblina da Perdição", false, false, false);

        //Gerenciador de ambientes:

        //Lista de Ambientes (Nomes):
        String[] listaDeAmbientes = {floresta.getNomeAmbiente(), montanha.getNomeAmbiente(), caverna.getNomeAmbiente(), ruinas.getNomeAmbiente(), lagoRio.getNomeAmbiente()};
        //Instanciando o Gerenciador de Ambientes:
        GerenciadorDeAmbientes gerenciadorDeAmbientes = new GerenciadorDeAmbientes(listaDeAmbientes, "Indefinido", new ArrayList<>(listaDeAmbientes.length));

        //Eventos:

        //Eventos Climáticos:

        //Clima padrão - Floresta:
        EventoClimatico climaFloresta = new EventoClimatico("Skógrgufa", "Um clima úmido e perenemente enevoado. A luz do sol raramente atravessa o véu de névoa azulada que dança entre as copas." +
                " Chuva fina e sussurros no vento são constantes — alguns dizem que são vozes de espíritos.", 2, " ", false, " ", 3, " ");
        //Clima padrão - Montanha:
        EventoClimatico climaMontanha = new EventoClimatico("Hrímblóð", "Frio penetrante com ventos cortantes que parecem vivenciar uma vontade própria. Nevascas repentinas tomam tudo de surpresa," +
                " e os flocos de neve caem como cinzas pálidas. Em algumas noites, formas espectrais são vistas caminhando pela neve.", 2, " ", false, " ", 3, " ");
        //Clima padrão - Caverna:
        EventoClimatico climaCaverna = new EventoClimatico("Myrrkuldi", "Nenhuma luz penetra a atmosfera opressiva. O ar é frio e úmido, com neblinas subterrâneas que condensam em gotas escuras." +
                " Em seu interior, forma-se um microclima gélido e sufocante, como o hálito de um dragão adormecido.", 2, " ", false, " ", 3, " ");
        //Clima padrão - Ruinas:
        EventoClimatico climaRuinas = new EventoClimatico("Eldrregn", "Um clima seco e instável. Raios solares intensos esquentam o solo enegrecido, e tempestades de cinzas surgem subitamente," +
                " trazendo faíscas e ventos quentes. À noite, a temperatura despenca como se o próprio tempo congelasse.", 2, " ", false, " ", 3, " ");
        //Clima padrão - Lago:
        EventoClimatico climaLago = new EventoClimatico("Draumslóð", "Clima brando e misterioso, com névoa constante e ar parado. A umidade alta provoca ilusões ópticas, e o clima parece flutuar entre realidade e devaneio." +
                " A brisa é suave, mas carrega murmúrios vindos do além.", 2, " ", false, " ", 3, " ");
        //Climas variados - Podem ser usados em qualquer ambiente, menos na Caverna:
        EventoClimatico climaVariadoUm = new EventoClimatico("Vindkaldr", "Correntes de ar gelado uivam pelas encostas, trazendo consigo flocos de neve mesmo fora do inverno." +
                " Relâmpagos secos cortam os céus em noites silenciosas, como se os deuses estivessem em guerra.", 2, " ", false, " ", 3, " ");
        EventoClimatico climaVariadoDois = new EventoClimatico("Stormvǫr", "Céus permanentemente carregados, com nuvens escuras e trovões que rugem como bestas distantes. Ventos fortes e chuvas intensas surgem sem aviso." +
                " É dito que esse clima ocorre onde antigos deuses travaram batalhas e seus gritos ainda ecoam nos céus.", 2, " ", false, " ", 3, " ");

        //Eventos Descobertas:

        EventoDescoberta bauPerdido = new EventoDescoberta("Bau Perdido", "Um antigo baú esquecido pelos corajosos exploradores de uma era passada",3,
                "Descobertas recuperam o folego do personagem, um pouco de energia e sede serão regenerados", true, "Combináveis e Equipáveis","Materiais, Ferramentas ou Armas", false);
        EventoDescoberta caixaDeSuprimentos = new EventoDescoberta("Caixa de Suprimentos", "Uma caixa de suprimentos deixada para trás, parece que era parte de um antigo vilarejo da região", 4,
                "Caixas de Suprimentos recuperam Sede, Fome e um pouco de Sanidade!",true, "Consumíveis","Alimentos, Agua",false);
        EventoDescoberta ervasMedicinais = new EventoDescoberta("Ervas Medicinais", "Um conjunto de pequenas folhas e ramos com propriedades curativas, fazem parte da natureza do local", 3,
                "Ervas Medicinais recuperam a Saúde do personagem e dão um pouco de esperança, recuperando a Sanidade", true, "Consumíveis", "Remédios", false);
        EventoDescoberta destrocosRuinas = new EventoDescoberta("Destroços de Ruínas", "Alguns materiais conseguiram resistir ao tempo e ao intenso fevor dessa ruína, pode haver algo de útil nesse meio", 2,
                "Destroços são importantes fontes de materiais, quem sabe até ferramentas ou armas!", true, "Combináveis e Equipáveis","Materiais, Ferramentas ou Armas", false );
        EventoDescoberta jarrosConserva = new EventoDescoberta("Jarros de Conserva", "Os antigos Jarros de Conserva eram utilizados para armazenar diversos recursos por décadas, talvez ainda tenha algo útil",
                2, "Jarros de Conserva são uma ótima fonte de recursos, se encontrar um deles não irá passar necessidades", true, "Consumíveis", "Alimentos, Água, Remédios", false);

        //Eventos Criaturas:

        EventoCriatura cervo = new EventoCriatura("Hjarnhyrndr", "Um cervo de pelagem prateada e chifres de cristal gélido. Dizem que ele aparece apenas sob a luz da lua cheia em florestas sagradas. É símbolo de equilíbrio, e caçá-lo é considerado blasfêmia.",
                2, "O encontro com criaturas possibilita a obtenção de recursos",false, "Animal mágico (neutro)", 25, 5, 0, " ");
        EventoCriatura serpente = new EventoCriatura("Niðkrága", "Uma serpente subterrânea que se move por vibrações no solo. Ela cospe uma névoa negra que cega e sufoca. Suas escamas são procuradas para rituais de invisibilidade",
                2, "O encontro com criaturas possibilita a obtenção de recursos",false, "Criatura hostil", 35, 10, 5, " ");
        EventoCriatura corvo = new EventoCriatura("Veðrhrafn", "Um corvo colossal com penas de trovão e olhos de relâmpago. Anuncia grandes mudanças ou batalhas. A presença de um Veðrhrafn pode significar bênção divina... ou desgraça inevitável.",
                2, "O encontro com criaturas possibilita a obtenção de recursos",false, "Animal mágico (neutro)", 40, 10, 0, " ");
        EventoCriatura javali = new EventoCriatura("Grimsvártr", "Um javali titânico coberto de espinhos ósseos. Habita vales escuros e ruínas esquecidas. Quando furioso, seu grito ecoa por quilômetros e provoca avalanches.",
                2, "O encontro com criaturas possibilita a obtenção de recursos",false, "Criatura hostil", 40, 15, 10, " ");
        EventoCriatura peixe = new EventoCriatura("Silfurskyn", "Um peixe raro que brilha com luz própria em lagos encantados como Mjarnvatn. Quem o captura e o liberta pode receber sonhos proféticos. Comer sua carne, no entanto, causa loucura.",
                2, "O encontro com criaturas possibilita a obtenção de recursos",false, "Animal mágico (pacífico)", 10, 5, 0, " ");
        EventoCriatura lobo = new EventoCriatura("Draugrulfr", "Lobo espectral que aparece onde o véu entre mundos se rompe. Seus olhos ardem com chamas verdes e seu uivo atrai os mortos inquietos. Imune a armas normais, só teme fogo.",
                2, "O encontro com criaturas possibilita a obtenção de recursos",false, "Criatura hostil", 20, 5, 5, " ");


















    }
}
