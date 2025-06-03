package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCriatura extends JPanel {
    private TelaMenu telaMenu;
    private JLabel imagemLabel;
    private JTextArea descricaoArea;
    private int indiceAtual = 0;

    public TelaCriatura(JFrame frame) {
        setLayout(new BorderLayout());

        JPanel painelCriaturas = new JPanel(new GridLayout(5, 2, 16, 16));
        painelCriaturas.setBackground(Color.BLACK);
        painelCriaturas.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));//20
        JScrollPane scrollPane = new JScrollPane(painelCriaturas);
        add(scrollPane, BorderLayout.CENTER);


        String nomes []={"Hjarnhyrndr", "Niðkrága", "Veðrhrafn", "Grimsvártr",
                "Silfurskyn", "Draugrulfr", "Tindgeit", "Skuggadraugr",
                "Skarnvaldr", "Yndra Sædis"
        };

        String descricao[]={
                "Um cervo de pelagem prateada e chifres de cristal gélido. Dizem que ele aparece apenas sob a " +
                        "luz da lua cheia em florestas sagradas. É símbolo de equilíbrio, e caçá-lo é considerado blasfêmia.",
                "Uma serpente subterrânea que se move por vibrações no solo. Ela cospe uma névoa negra que cega e" +
                        " sufoca. Suas escamas são procuradas para rituais de invisibilidade",
                "Um corvo colossal com penas de trovão e olhos de relâmpago. Anuncia grandes mudanças ou batalhas. " +
                        "A presença de um Veðrhrafn pode significar bênção divina... ou desgraça inevitável.",
                "Um javali titânico coberto de espinhos ósseos. Habita vales escuros e ruínas esquecidas. " +
                        "Quando furioso, seu grito ecoa por quilômetros e provoca avalanches.",
                "Um peixe raro que brilha com luz própria em lagos encantados como Mjarnvatn. Quem o captura e o " +
                        "liberta pode receber sonhos proféticos. Comer sua carne, no entanto, causa loucura.",
                "Lobo espectral que aparece onde o véu entre mundos se rompe. Seus olhos ardem com chamas verdes e " +
                        "seu uivo atrai os mortos inquietos. Imune a armas normais, só teme fogo",
                "Cabra das montanhas com patas afiadas como ganchos e pelo que muda de cor com o clima. " +
                        "É usada por caçadores e clérigos como guia em regiões traiçoeiras.",
                "Uma criatura que vive entre as sombras de ruínas e cavernas profundas. Não tem forma definida — apenas " +
                        "olhos vermelhos pairando na escuridão. Alimenta-se de medo. Matar uma exige luz.",
                "Um antigo guerreiro-sacerdote banido pelos próprios deuses após desafiar os Pactos do Céu. Usa uma armadura" +
                        " corroída por raios e carrega uma lança de obsidiana viva chamada Mjarkfjaldr",
                "Uma mulher idosa que vive isolada às margens do lago Mjarnvatn. É uma vidente silenciosa, conhecida por ouvir os" +
                        " sussurros da névoa. Acredita-se que Yndra seja filha de um deus e uma mortal"

        };

        String[] arquivos = {
                "Hjarnhyrndr.png", "Niðkrága.png", "Veðrhrafn.png",
                "Grimsvártr.png", "Silfurskyn.png", "Draugrulfr.png",
                "Tindgeit.png","Skuggadraugr.png","Skarnvaldr.png",
                "Yndra Sædis.png"
        };
        for (int i = 0; i < nomes.length; i++) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBackground(Color.BLACK);
            card.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

            ImageIcon originalIcon = new ImageIcon("imagens/criaturas/" + arquivos[i]);
            Image img = originalIcon.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);

            JLabel imagem = new JLabel(icon);
            imagem.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel nome = new JLabel(nomes[i], SwingConstants.CENTER);
            nome.setForeground(Color.BLACK);
            nome.setFont(new Font("Arial", Font.BOLD, 14));

            JButton descricaoButton = new JButton("Ver Descrição");
            int index = i;

            descricaoButton.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                        frame,
                        descricao[index],
                        nomes[index],
                        JOptionPane.INFORMATION_MESSAGE
                );
            });

            JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
            bottomPanel.add(nome);
            bottomPanel.add(descricaoButton);

            card.add(imagem, BorderLayout.CENTER);
            card.add(bottomPanel, BorderLayout.SOUTH);

            painelCriaturas.add(card);
        }

        JButton voltarButton = new JButton("Voltar");
        voltarButton.setBackground(new Color(0, 128, 0)); // verde escuro
        voltarButton.setForeground(Color.WHITE); // texto branco para contraste
        voltarButton.setOpaque(true);
        voltarButton.setBorderPainted(false);
        voltarButton.addActionListener(e -> {
            frame.setContentPane(new TelaMenu(frame));
            frame.revalidate();
        });

        //add(painelCriaturas, BorderLayout.CENTER);
        add(voltarButton, BorderLayout.SOUTH);
    }
}
