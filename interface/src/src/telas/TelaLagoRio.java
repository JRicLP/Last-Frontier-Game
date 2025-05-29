package telas;

import javax.swing.*;
import java.awt.*;
import personagens.Personagem;

public class TelaLagoRio extends JPanel {
    private Personagem personagem;

    public TelaLagoRio(JFrame frame, Personagem personagem) {
        this.personagem = personagem;

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

      //fundo com imagem do lago
        ImageIcon imagemFundo = new ImageIcon("imagens/lagoRio.png"); // coloque uma imagem com esse nome
        Image imagemRedimensionada = imagemFundo.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        JLabel fundo = new JLabel(new ImageIcon(imagemRedimensionada));
        fundo.setLayout(new BorderLayout());

        // Texto introdutório com tema nórdico
        JTextArea texto = new JTextArea();
        texto.setEditable(false);
        texto.setOpaque(false);
        texto.setForeground(Color.WHITE);
        texto.setFont(new Font("Serif", Font.BOLD, 18));
        texto.setLineWrap(true);
        texto.setWrapStyleWord(true);
        texto.setText(
                """
                O vento gélido sopra enquanto você chega às margens do Lago de Skarndal...

                Dizem que as águas calmas escondem segredos ancestrais, e que poucos voltaram vivos para contar.

                Você, %s, inicia sua jornada em Dravnir, onde coragem, astúcia e resistência serão testadas.

                Prepare-se... o destino das Crônicas está em suas mãos.
                """.formatted(personagem.getNomePersonagem())
        );

        JPanel painelTexto = new JPanel(new BorderLayout());
        painelTexto.setOpaque(false);
        painelTexto.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        painelTexto.add(texto, BorderLayout.CENTER);

        fundo.add(painelTexto, BorderLayout.CENTER);

        // Botão para avançar
        JButton avancar = new JButton("Avançar");
        avancar.setFont(new Font("Arial", Font.BOLD, 16));
        avancar.setBackground(new Color(30, 30, 30));
        avancar.setForeground(Color.WHITE);
        avancar.setFocusPainted(false);
        avancar.setPreferredSize(new Dimension(120, 40));

        avancar.addActionListener(e -> {
            JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
            janela.getContentPane().removeAll();
            janela.setContentPane(new TelaPrincipalJogo(personagem).getContentPane());
            janela.revalidate();
            janela.repaint();

        });


        JPanel painelBotao = new JPanel();
        painelBotao.setOpaque(false);
        painelBotao.add(avancar);

        fundo.add(painelBotao, BorderLayout.SOUTH);

        add(fundo, BorderLayout.CENTER);
    }
}
