package telas;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JPanel {
    private Image imagemFundo;

    public TelaInicial(JFrame frame) {
        // Carrega a imagem de fundo
        imagemFundo = new ImageIcon("imagens/capa.jpeg").getImage();

        // Define o layout como GridBagLayout, que permite posicionamento flexível
        setLayout(new GridBagLayout());

        // Torna o fundo transparente para permitir a visualização da imagem
        setOpaque(false);

        // Define uma borda branca ao redor do painel
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));

        // Criação do botão "JOGAR"
        JButton botaoJogar = new JButton("JOGAR");
        botaoJogar.setFont(new Font("Arial", Font.BOLD, 28));
        botaoJogar.setForeground(Color.WHITE);
        botaoJogar.setBackground(new Color(255, 140, 0)); // Cor laranja
        botaoJogar.setFocusPainted(false); // Remove a borda de foco ao clicar

        // Define a ação do botão: trocar para a TelaIntro
        botaoJogar.addActionListener(e -> {
            frame.setContentPane(new TelaIntro(frame));
            frame.revalidate();
        });

        // Configuração de constraints para centralizar o botão
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        gbc.anchor = GridBagConstraints.CENTER; // Alinhamento central
        gbc.insets = new Insets(0, 0, 0, 0); // Sem margens
        gbc.weightx = 1.0; // Distribuição horizontal
        gbc.weighty = 1.0; // Distribuição vertical
        gbc.fill = GridBagConstraints.NONE; // O botão mantém seu tamanho preferido

        // Adiciona o botão ao painel com as constraints definidas
        add(botaoJogar, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem de fundo ajustada ao tamanho do painel
        g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
    }
}
