package telas;

import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JPanel {
    private Image imagemFundo;

    public TelaMenu(JFrame frame) {
        // Carrega a imagem de fundo
        imagemFundo = new ImageIcon("imagens/menu.png").getImage(); // ajuste o caminho se necessário

        setLayout(new GridBagLayout());
        setOpaque(false); // Deixa o fundo transparente para mostrar a imagem

        // Botões
        JButton botaoMapa = new JButton("Ver Mapa");
        JButton botaoPersonagens = new JButton("Ver Personagens");
        JButton botaoRegras = new JButton("Regras");
        JButton botaoItens = new JButton("Itens");

        formatarBotao(botaoItens);
        formatarBotao(botaoMapa);
        formatarBotao(botaoPersonagens);
        formatarBotao(botaoRegras);

        // Ações dos botões
        botaoItens.addActionListener(e -> {
            frame.setContentPane(new TelaItens(frame));
            frame.revalidate();
        });

        botaoMapa.addActionListener(e -> {
            frame.setContentPane(new TelaMapa(frame));
            frame.revalidate();
        });

        botaoPersonagens.addActionListener(e -> {
            frame.setContentPane(new TelaPersonagem(frame));
            frame.revalidate();
        });

        botaoRegras.addActionListener(e -> {
            frame.setContentPane(new TelaRegras(frame));
            frame.revalidate();
        });

        // Layout com GridBag
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 15, 0);
        gbc.gridy = 0;

        gbc.gridy++;
        add(botaoMapa, gbc);
        gbc.gridy++;
        add(botaoPersonagens, gbc);
        gbc.gridy++;
        add(botaoRegras, gbc);
        gbc.gridy++;
        add(botaoItens,gbc);
    }

    private void formatarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 24));
        botao.setBackground(new Color(0, 120, 215));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(240, 40));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemFundo != null) {
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}