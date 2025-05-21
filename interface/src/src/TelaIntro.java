import javax.swing.*;
import java.awt.*;

public class TelaIntro extends JPanel {
    public TelaIntro(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JTextArea textoIntro = new JTextArea(
                "A CANÇÃO DE DRAVNIR  \n" +
                        "CRÔNICAS DO FIM SUSSURRADO  \n" +
                        "\n" +
                        "No princípio existia apenas Dravnir, a Árvore Primordial. Seus galhos  \n" +
                        "tocavam as estrelas e suas raízes abraçavam o âmago do mundo.  \n" +
                        "\n" +
                        "Do primeiro sopro nasceram os deuses antigos: Varrundr o Guardião,  \n" +
                        "Eldjarn o Forjador, Skarnir o Enganoso, Niðrys a Sombra e Vaelra  \n" +
                        "a Senhora do Véu. Juntos criaram as Terras Partidas - reinos  \n" +
                        "selvagens moldados por suas vontades divinas.  \n" +
                        "\n" +
                        "Mas a ambição de Skarnir pela perfeição rompeu o equilíbrio.  \n" +
                        "Ele infectou uma raiz de Dravnir, espalhando a corrupção pelo mundo.  \n" +
                        "Nasceram assim doenças mágicas e criaturas terríveis. Os mortais  \n" +
                        "aprenderam a forjar armas místicas e remédios poderosos, mas não  \n" +
                        "puderam deter a Morte Silenciosa - praga que devora memórias e almas.  \n" +
                        "\n" +
                        "Com o colapso iminente, os deuses entraram em sono profundo.  \n" +
                        "Em desespero, Dravnir sonhou os Vandrers - forasteiros capazes  \n" +
                        "de restaurar o equilíbrio por serem, eles próprios, nascidos  \n" +
                        "do desequilíbrio.  \n" +
                        "\n" +
                        "Você desperta agora às margens do lago Mjarnvatn. Sem memórias.  \n" +
                        "Uma Vefrbind envolta em seu braço. Uma dor no peito.  \n" +
                        "E a estranha sensação de que este mundo moribundo o conhece  \n" +
                        "melhor do que você mesmo.  \n" +
                        "\n" +
                        "Em uma terra onde até o vento mente, sua jornada começa...  \n" +
                        "\n" +
                        "LAST FRONTIER\n"
        );
        textoIntro.setFont(new Font("Serif", Font.PLAIN, 20));
        textoIntro.setWrapStyleWord(true);
        textoIntro.setLineWrap(true);
        textoIntro.setEditable(false);
        textoIntro.setForeground(Color.WHITE);
        textoIntro.setBackground(Color.BLACK);
        textoIntro.setMargin(new Insets(30, 40, 30, 40));

        JScrollPane scrollPane = new JScrollPane(textoIntro);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.BLACK);

        JButton botaoContinuar = new JButton("CONTINUAR");
        botaoContinuar.setFont(new Font("Arial", Font.BOLD, 22));
        botaoContinuar.setBackground(Color.GREEN.darker());
        botaoContinuar.setForeground(Color.WHITE);
        botaoContinuar.addActionListener(e -> {
            frame.setContentPane(new TelaMenu(frame));
            frame.revalidate();
        });

        add(scrollPane, BorderLayout.CENTER);
        add(botaoContinuar, BorderLayout.SOUTH);
    }
}
