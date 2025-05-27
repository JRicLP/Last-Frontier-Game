package telas;

import javax.swing.*;
import java.awt.*;

public class TelaRegras extends JPanel {
    public TelaRegras(JFrame frame) {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JTextArea textoRegras = new JTextArea("ATENÇÃO\n" +
                "Preste atenção para as condições de vitória, bravo aventureiro:\n\n" +
                "1. Sobrevivência por Tempo Determinado:\n" +
                "   Se você conseguir sobreviver até o final do último ambiente, terá a vitória conquistada.\n\n" +
                "2. Descoberta de um Refúgio Seguro:\n" +
                "   Se você encontrar um refúgio seguro para se instalar, sem criaturas ou qualquer perigo, conquistará a vitória.\n\n" +
                "3. Construção de um Abrigo Permanente:\n" +
                "   Se você conseguir materiais suficientes para construir um abrigo seguro, vencerá!\n\n" +
                "4. Resgate Bem-Sucedido:\n" +
                "   Se você conseguir ativar um pedido de resgate e sobreviver até ser salvo, vencerá!\n\n" +
                "-------------------------------------------------------------------------------------------------------------\n\n" +
                "Preste atenção para as condições de derrota, bravo aventureiro:\n\n" +
                "1. Vida Chegando a Zero:\n" +
                "   Cuidado! Se sua vida chegar a zero, você MORRERÁ e perderá o jogo.\n\n" +
                "2. Morte por Fome ou Sede:\n" +
                "   Cuidado! Se os pontos de fome ou sede chegarem a 0, você MORRERÁ por desnutrição ou desidratação, e perderá o jogo.\n\n" +
                "3. Perda Total de Sanidade:\n" +
                "   Cuidado! Se a sua sanidade chegar a 0, você FICARÁ LOUCO e MORRERÁ.\n\n" +
                "4. Esgotamento de Recursos Essenciais:\n" +
                "   Cuidado! Sem comida, sem água e sem ferramentas, a sobrevivência será IMPOSSÍVEL, você morrerá e perderá o jogo.\n\n" +
                "5. Captura ou Morte por Outros Sobreviventes:\n" +
                "   Cuidado! Há os Skarnvaldr, guerreiros corrompidos. Eles irão te atacar e querer matar você. Se você for derrotado por eles, MORRERÁ e perderá o jogo.\n"



        );
        textoRegras.setFont(new Font("Serif", Font.PLAIN, 18));
        textoRegras.setWrapStyleWord(true);
        textoRegras.setLineWrap(true);
        textoRegras.setEditable(false);
        textoRegras.setForeground(Color.WHITE);
        textoRegras.setBackground(Color.BLACK);
        textoRegras.setMargin(new Insets(30, 40, 30, 40));

        JScrollPane scrollPane = new JScrollPane(textoRegras);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.BLACK);

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 20));
        botaoVoltar.setBackground(Color.GREEN.darker());
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.addActionListener(e -> {
            frame.setContentPane(new TelaMenu(frame));
            frame.revalidate();
        });

        add(scrollPane, BorderLayout.CENTER);
        add(botaoVoltar, BorderLayout.SOUTH);
    }
}
