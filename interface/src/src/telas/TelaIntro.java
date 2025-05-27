package telas;

import javax.swing.*;
import java.awt.*;

public class TelaIntro extends JPanel {
    public TelaIntro(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        // Área de texto de introdução
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

        // Painel inferior com campo de nome e botão
        JPanel painelInferior = new JPanel(new GridBagLayout());
        painelInferior.setBackground(Color.BLACK);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel labelNome = new JLabel("Escolha seu nome:");
        labelNome.setForeground(Color.WHITE);
        labelNome.setFont(new Font("Arial", Font.PLAIN, 18));

        JTextField campoNome = new JTextField(15);
        campoNome.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton botaoContinuar = new JButton("CONTINUAR");
        botaoContinuar.setFont(new Font("Arial", Font.BOLD, 20));
        botaoContinuar.setBackground(new Color(34, 139, 34)); // verde escuro
        botaoContinuar.setForeground(Color.WHITE);
        botaoContinuar.setFocusPainted(false);

        botaoContinuar.addActionListener(e -> {
            String nickname = campoNome.getText().trim();
            if (nickname.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Por favor, digite um nome para continuar.");
            } else {
                // Aqui o nickname pode ser salvo se necessário
                frame.setContentPane(new TelaMenu(frame)); // sem nickname
                frame.revalidate();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelInferior.add(labelNome, gbc);
        gbc.gridx = 1;
        painelInferior.add(campoNome, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        painelInferior.add(botaoContinuar, gbc);

        add(scrollPane, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);
    }
}
