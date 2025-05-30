package telas;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JPanel {
    private Image imagemFundo;

    public TelaInicial(JFrame frame) {
        imagemFundo = new ImageIcon("imagens/capa.jpeg").getImage();
        setLayout(new GridBagLayout());
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));

        JButton botaoJogar = new JButton("JOGAR");
        botaoJogar.setFont(new Font("Arial", Font.BOLD, 28));
        botaoJogar.setForeground(Color.WHITE);
        botaoJogar.setBackground(new Color(255, 140, 0));
        botaoJogar.setFocusPainted(false);

        botaoJogar.addActionListener(e -> {
            frame.setContentPane(new TelaIntro(frame));
            frame.revalidate();
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 1;
        gbc.insets = new Insets(300, 0, 0, 0);
        add(botaoJogar, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
    }
}
