package mensagensDisplay;

public class MensagensIniciais {

    public void mensagensLoreIntroducao() {

        // Limpa a tela ou adiciona espaçamento
        for (int contador = 0; contador < 3; contador++) {
            System.out.println();
        }

        System.out.println("                    A CANÇÃO DE DRAVNIR");
        System.out.println("                 CRÔNICAS DO FIM SUSSURRADO");
        System.out.println();

        sleep(2500);

        System.out.println("No princípio existia apenas Dravnir, a Árvore Primordial. Seus galhos");
        System.out.println("tocavam as estrelas e suas raízes abraçavam o âmago do mundo.");
        System.out.println();

        sleep(3000);
        System.out.println("Do primeiro sopro nasceram os deuses antigos: Varrundr o Guardião,");
        System.out.println("Eldjarn o Forjador, Skarnir o Enganoso, Niðrys a Sombra e Vaelra");
        System.out.println("a Senhora do Véu. Juntos criaram as Terras Partidas - reinos");
        System.out.println("selvagens moldados por suas vontades divinas.");
        System.out.println();

        sleep(3000);
        System.out.println("Mas a ambição de Skarnir pela perfeição rompeu o equilíbrio.");
        System.out.println("Ele infectou uma raiz de Dravnir, espalhando a corrupção pelo mundo.");
        System.out.println("Nasceram assim doenças mágicas e criaturas terríveis. Os mortais");
        System.out.println("aprenderam a forjar armas místicas e remédios poderosos, mas não");
        System.out.println("puderam deter a Morte Silenciosa - praga que devora memórias e almas.");
        System.out.println();

        sleep(3000);
        System.out.println("Com o colapso iminente, os deuses entraram em sono profundo.");
        System.out.println("Em desespero, Dravnir sonhou os Vandrers - forasteiros capazes");
        System.out.println("de restaurar o equilíbrio por serem, eles próprios, nascidos");
        System.out.println("do desequilíbrio.");
        System.out.println();

        sleep(3000);
        System.out.println("Você desperta agora às margens do lago Mjarnvatn. Sem memórias.");
        System.out.println("Uma Vefrbind envolta em seu braço. Uma dor no peito.");
        System.out.println("E a estranha sensação de que este mundo moribundo o conhece");
        System.out.println("melhor do que você mesmo.");
        System.out.println();

        sleep(3000);
        System.out.println("Em uma terra onde até o vento mente, sua jornada começa...");
        System.out.println();

        sleep(2500);
        System.out.println("                      LAST FRONTIER");

        System.out.println();
        System.out.println();
        System.out.println("Pressione ENTER para continuar...");
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
