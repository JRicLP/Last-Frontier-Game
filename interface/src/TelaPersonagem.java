import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaPersonagem extends JPanel {
    private Image personagensImagem;

    public TelaPersonagem(JFrame frame) {
        setLayout(new BorderLayout());

        // Painel dos personagens
        JPanel painelPersonagens = new JPanel(new GridLayout(2, 3, 5, 5));
        painelPersonagens.setBackground(Color.BLACK);
        painelPersonagens.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Informações dos personagens
        String[] nomes = {
                "Jack Nomad", "Scarlet Tempest", "Malik Ghost",
                "Virgil Explorer", "Gearhead Martinez", "Flynn Tracker"
        };

        String[] descricoes = {
                "O Nômade Rústico", "O Pirata Infame", "O Infiltrador Fantasma",
                "O Explorador Corajoso", "O Cientista Criativo", "O Caçador Destemido"
        };

        String[] arquivos = {
                "nomade.png", "pirata2.png", "infiltrador.png",
                "explorador.png", "cientista.png", "cacador.png"
        };

        for (int i = 0; i < nomes.length; i++) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBackground(Color.DARK_GRAY);
            card.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

            // Carrega e redimensiona a imagem
            ImageIcon originalIcon = new ImageIcon("imagens/" + arquivos[i]);
            Image img = originalIcon.getImage().getScaledInstance(240, 230, Image.SCALE_SMOOTH);

            ImageIcon icon = new ImageIcon(img);

            JLabel imagem = new JLabel(icon);
            imagem.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel nome = new JLabel(nomes[i], SwingConstants.CENTER);
            nome.setForeground(Color.WHITE);
            nome.setFont(new Font("Arial", Font.BOLD, 14));

            JLabel descricao = new JLabel(descricoes[i], SwingConstants.CENTER);
            descricao.setForeground(Color.LIGHT_GRAY);
            descricao.setFont(new Font("Arial", Font.ITALIC, 12));

            JButton selecionar = new JButton("Escolher");
            int index = i;
            selecionar.addActionListener((ActionEvent e) -> {
                JOptionPane.showMessageDialog(this, "Você escolheu: " + nomes[index]);
            });

            card.add(imagem, BorderLayout.CENTER);
            card.add(nome, BorderLayout.NORTH);
            card.add(selecionar, BorderLayout.SOUTH);

            painelPersonagens.add(card);
        }




        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 18));
        botaoVoltar.setBackground(Color.DARK_GRAY);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);

        botaoVoltar.addActionListener(e -> {
            frame.setContentPane(new TelaMenu(frame));
            frame.revalidate();
        });

        add(painelPersonagens, BorderLayout.CENTER);
        add(botaoVoltar, BorderLayout.SOUTH);
    }
}
