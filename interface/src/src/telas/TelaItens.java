
package telas;

import gerenciadores.GerenciadorDeItens;
import itens.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaItens extends JPanel {
    private GerenciadorDeItens gerenciador;
    private JPanel painelItens;
    private JFrame framePai;

    public TelaItens(JFrame frame) {
        this.framePai = frame;
        this.gerenciador = new GerenciadorDeItens();

        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JPanel painelBotoes = new JPanel(new GridLayout(1, 6, 15, 0)); // 1 linha, 6 colunas, espaçamento horizontal 15
        painelBotoes.setOpaque(false);

        JButton btnArmas = new JButton("Armas");
        JButton btnFerramentas = new JButton("Ferramentas");
        JButton btnRemedios = new JButton("Remédios");
        JButton btnAlimentos = new JButton("Alimentos");
        JButton btnAgua = new JButton("Água");
        JButton btnMateriais = new JButton("Materiais");

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setFont(new Font("Arial", Font.BOLD, 16));
        btnVoltar.setBackground(Color.GREEN.darker());
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setFocusPainted(false);
        btnVoltar.addActionListener(e -> {
            frame.setContentPane(new TelaMenu(frame));
            frame.revalidate();
        });

        for (JButton botao : new JButton[]{btnArmas, btnFerramentas, btnRemedios, btnAlimentos, btnAgua, btnMateriais}) {
            estilizarBotao(botao);
            painelBotoes.add(botao);
        }

        add(painelBotoes, BorderLayout.NORTH);

        painelItens = new JPanel(new GridLayout(2, 3, 10, 10));
        painelItens.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        painelItens.setBackground(Color.BLACK);

        JScrollPane scroll = new JScrollPane(painelItens);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);

        add(scroll, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        btnArmas.addActionListener(e -> exibirItens(gerenciador.listaArmas));
        btnFerramentas.addActionListener(e -> exibirItens(gerenciador.listaFerramentas));
        btnRemedios.addActionListener(e -> exibirItens(gerenciador.listaRemedios));
        btnAlimentos.addActionListener(e -> exibirItens(gerenciador.listaAlimentos));
        btnAgua.addActionListener(e -> exibirItens(gerenciador.listaAgua));
        btnMateriais.addActionListener(e -> exibirItens(gerenciador.listaMateriais));

        exibirItens(gerenciador.listaArmas);

    }

    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 15));         // Fonte maior
        botao.setPreferredSize(new Dimension(140, 30));
        botao.setBackground(new Color(180, 160, 120));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
    }

    private void exibirItens(List<? extends Item> itens) {
        painelItens.removeAll();
        painelItens.setLayout(new GridLayout(0, 3, 10, 10));

        for (Item item : itens) {
            JPanel painelItem = new JPanel(new BorderLayout());
            painelItem.setBackground(Color.BLACK);
            painelItem.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

            String caminho = "imagens/";
            if (item instanceof Armas) caminho += "armas/";
            else if (item instanceof Ferramentas) caminho += "ferramentas/";
            else if (item instanceof Remedios) caminho += "remedios/";
            else if (item instanceof Alimentos) caminho += "alimentos/";
            else if (item instanceof Agua) caminho += "agua/";
            else if (item instanceof Materiais) caminho += "materiais/";

            caminho += item.getNomeItem() + ".png";

            ImageIcon imagemIconeOriginal = new ImageIcon(caminho);
            Image imagemRedimensionada = imagemIconeOriginal.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon imagemIcone = new ImageIcon(imagemRedimensionada);
            JLabel imagemLabel = new JLabel(imagemIcone);
            imagemLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel nomeLabel = new JLabel(item.getNomeItem(), JLabel.CENTER);
            nomeLabel.setForeground(Color.WHITE);
            nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JButton detalhes = new JButton("Ver Detalhes");
            detalhes.setFont(new Font("Arial", Font.PLAIN, 12));
            detalhes.addActionListener(e -> mostrarDetalhesItem(item));

            painelItem.add(nomeLabel, BorderLayout.NORTH);
            painelItem.add(imagemLabel, BorderLayout.CENTER);
            painelItem.add(detalhes, BorderLayout.SOUTH);

            painelItens.add(painelItem);
        }

        painelItens.revalidate();
        painelItens.repaint();
    }

    private void mostrarDetalhesItem(Item item) {
        JTextArea area = new JTextArea(gerarTextoCompleto(item));
        area.setEditable(false);
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        area.setFont(new Font("Serif", Font.PLAIN, 14));
        area.setOpaque(false);

        JOptionPane.showMessageDialog(this, new JScrollPane(area),
                item.getNomeItem() + " - Detalhes",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private String gerarTextoCompleto(Item item) {
        StringBuilder sb = new StringBuilder();

        if (item instanceof Armas a) {
            sb.append("Dano: ").append(a.getDanoArma())
                    .append("\nDurabilidade: ").append(a.getDurabilidadeItem())
                    .append("\nTipo: ").append(a.getTipoArma())
                    .append("\nPeso: ").append(a.getPesoItem())
                    .append("\nAlcance: ").append(a.getAlcanceArma());
        } else if (item instanceof Ferramentas f) {
            sb.append("Durabilidade: ").append(f.getDurabilidadeItem())
                    .append("\nTipo: ").append(f.getTipoFerramenta())
                    .append("\nEficiência: ").append(f.getEficienciaFerramenta())
                    .append("\nPeso: ").append(f.getPesoItem());
        } else if (item instanceof Remedios r) {
            sb.append("Efeito: ").append(r.getEfeitoRemedio())
                    .append("\nTipo: ").append(r.getTipoRemedio())
                    .append("\nPeso: ").append(r.getPesoItem())
                    .append("\nDurabilidade: ").append(r.getDurabilidadeItem());
        } else if (item instanceof Alimentos al) {
            sb.append("Tipo: ").append(al.getTipoAlimento())
                    .append("\nValor Nutricional: ").append(al.getValorNutricional())
                    .append("\nPeso: ").append(al.getPesoItem())
                    .append("\nValidade: ").append(al.getPrazoValidade());
        } else if (item instanceof Agua ag) {
            sb.append("Volume: ").append(ag.getVolumeAgua())
                    .append("\nPureza: ").append(ag.getPurezaAgua())
                    .append("\nPeso: ").append(ag.getPesoItem())
                    .append("\nDurabilidade: ").append(ag.getDurabilidadeItem());
        } else if (item instanceof Materiais m) {
            sb.append("Tipo: ").append(m.getTipoMaterial())
                    .append("\nResistência: ").append(m.getResistenciaMaterial())
                    .append("\nPeso: ").append(m.getPesoItem())
                    .append("\nDurabilidade: ").append(m.getDurabilidadeItem());
        }

        return sb.toString();
    }
}
