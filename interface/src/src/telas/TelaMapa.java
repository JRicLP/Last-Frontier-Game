package telas;

import javax.swing.*;
import java.awt.*;

public class TelaMapa extends JPanel {

    private Image imagemMapa;

    public TelaMapa(JFrame frame) {
        imagemMapa = new ImageIcon("imagens/mapa_antigo.png").getImage();

        setLayout(new BorderLayout());

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 18));
        botaoVoltar.setBackground(Color.GREEN.darker());
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);

        botaoVoltar.addActionListener(e -> {
            frame.setContentPane(new TelaMenu(frame));
            frame.revalidate();
        });

        add(botaoVoltar, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imagemMapa, 0, 0, getWidth(), getHeight(), this);
    }
}
