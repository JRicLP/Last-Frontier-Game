import javax.swing.*;
import java.awt.*;

public class TelaMenu extends JPanel {
    private Image imagemMapa;
    private Image personagensImagem;

    public TelaMenu(JFrame frame) {
        setLayout(new GridBagLayout());
        setBackground(new Color(25, 25, 25));

        JButton botaoMapa = new JButton("Ver Mapa");
        JButton botaoPersonagens = new JButton("Ver Personagens");
        JButton botaoRegras = new JButton("Regras"); // Novo botão

        formatarBotao(botaoMapa);
        formatarBotao(botaoPersonagens);
        formatarBotao(botaoRegras); // Formata o botão de regras também

        botaoMapa.addActionListener(e -> {
            frame.setContentPane(new TelaMapa(frame));
            frame.revalidate();
        });

        botaoPersonagens.addActionListener(e -> {
            frame.setContentPane(new TelaPersonagem(frame));
            frame.revalidate();
        });

        botaoRegras.addActionListener(e -> {
            frame.setContentPane(new TelaRegras(frame)); // Redireciona para TelaRegras
            frame.revalidate();
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 15, 0);
        gbc.gridy = 0;
        add(botaoMapa, gbc);
        gbc.gridy++;
        add(botaoPersonagens, gbc);
        gbc.gridy++;
        add(botaoRegras, gbc); // Adiciona o botão na sequência
    }

    private void formatarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 24));
        botao.setBackground(new Color(0, 120, 215));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setPreferredSize(new Dimension(250, 60));
    }
}
