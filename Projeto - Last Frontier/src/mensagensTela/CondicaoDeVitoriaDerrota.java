package mensagensTela;


public class CondicaoDeVitoriaDerrota {
    public void condicaoDisplay() {
        String separadorCurto = "-------------------------------------------------------------------";
        String separadorLongo = "-------------------------------------------------------------------------------------------------------------------------------------------";

        System.out.println("\n" + separadorCurto + " ATENÇÃO " + separadorCurto);
        System.out.println("Bravo Vandrer, preste atenção às condições que guiarão seu destino em Dravnir:");
        System.out.println();

        System.out.println("  ♦ CONDIÇÕES DE VITÓRIA ♦");
        System.out.println("    1. Construção do Refúgio: Reúna os materiais e conhecimentos ancestrais");
        System.out.println("       para erguer o 'Abrigo Seguro'. Este feito trará esperança e um");
        System.out.println("       verdadeiro santuário contra os horrores de Dravnir, garantindo sua vitória.");
        System.out.println();
        System.out.println("    2. Sobrevivência Prolongada: Demonstre sua resiliência e capacidade de adaptação");
        System.out.println("       sobrevivendo por 24 turnos nas Terras Partidas. Embora o futuro de");
        System.out.println("       Dravnir possa permanecer incerto sem o Abrigo, sua tenacidade será lembrada.");
        System.out.println("    (Outros caminhos para a salvação podem existir para aqueles que exploram os segredos mais profundos...)");
        System.out.println();

        System.out.println(separadorLongo);
        System.out.println("  ♦ CONDIÇÕES DE DERROTA ♦");
        System.out.println("    1. Vida Esgotada: Se seus pontos de Vida chegarem a 0, seja em combate");
        System.out.println("       ou por outros perigos, sua jornada terá um fim trágico.");
        System.out.println();
        System.out.println("    2. Inanição ou Desidratação Extrema: Manter-se alimentado e hidratado é crucial.");
        System.out.println("       Se seus níveis de Fome ou Sede (sua capacidade de se manter nutrido)");
        System.out.println("       chegarem a 0, você não resistirá.");
        System.out.println();
        System.out.println("    3. Colapso Mental: A sanidade é tão vital quanto o corpo. Se sua Sanidade");
        System.out.println("       chegar a 0, a loucura o consumirá, levando à perdição.");
        System.out.println();
        System.out.println("    4. Derrota em Combate: As terras estão repletas de criaturas hostis e");
        System.out.println("       errantes perigosos como os Skarnvaldr. Ser subjugado em batalha");
        System.out.println("       resultará na sua morte.");
        System.out.println(separadorLongo);
        System.out.println("Pressione ENTER para continuar e iniciar sua jornada...");
    }
}