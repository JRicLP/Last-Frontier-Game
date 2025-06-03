package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import gerenciadores.GerenciadorDeEventos;
import gerenciadores.GerenciadorDeItens;
import personagens.*;

public class TelaPersonagem extends JPanel {
    private Personagem personagemSelecionado;
    GerenciadorDeItens gerenciadorDeItens;


    public TelaPersonagem(JFrame frame) {
        setLayout(new BorderLayout());

        JPanel painelPersonagens = new JPanel(new GridLayout(2, 3, 5, 5));
        painelPersonagens.setBackground(Color.BLACK);
        painelPersonagens.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] nomes = {
                "Jack Nomad", "Scarlet Tempest", "Malik Ghost",
                "Virgil Explorer", "Gearhead Martinez", "Flynn Tracker"
        };

        String[] descricoes = {
                "O Nômade Rústico", "O Pirata Infame", "O Infiltrador Fantasma",
                "O Explorador Corajoso", "O Cientista Criativo", "O Caçador Destemido"
        };

        String[] arquivos = {
                "nomade2.png", "pirata3.png", "infiltrador2.png",
                "explorador2.png", "cientista2.png", "cacador1.png"
        };

        for (int i = 0; i < nomes.length; i++) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBackground(Color.BLACK); //cor da alça do nome dos personagens
            card.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

            ImageIcon originalIcon = new ImageIcon("imagens/" + arquivos[i]);
            Image img = originalIcon.getImage().getScaledInstance(240, 230, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);

            JLabel imagem = new JLabel(icon);
            imagem.setHorizontalAlignment(SwingConstants.CENTER);

            JLabel nome = new JLabel(nomes[i], SwingConstants.CENTER);
            nome.setForeground(Color.WHITE);
            nome.setFont(new Font("Arial", Font.BOLD, 14));

            JLabel descricao = new JLabel(descricoes[i], SwingConstants.CENTER);
            descricao.setForeground(Color.BLACK);
            descricao.setFont(new Font("Arial", Font.ITALIC, 12));

            JButton selecionar = new JButton("Escolher");
            int index = i;

            selecionar.addActionListener((ActionEvent e) -> {
                personagemSelecionado = criarPersonagemPorIndice(index);
                this.gerenciadorDeItens = new GerenciadorDeItens(personagemSelecionado);


                String mensagem = String.format(
                        "Nome: %s\n\nVida: %d\nFome: %d\nSede: %d\nEnergia: %d\nSanidade: %d\n\nDeseja escolher este personagem?",
                        personagemSelecionado.getNomePersonagem(),
                        personagemSelecionado.getVidaPersonagem(),
                        personagemSelecionado.getFomePersonagem(),
                        personagemSelecionado.getSedePersonagem(),
                        personagemSelecionado.getEnergiaPersonagem(),
                        personagemSelecionado.getSanidadePersonagem()
                );

                int confirm = JOptionPane.showConfirmDialog(
                        this, mensagem, "Confirmar Escolha", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    // Mensagem temática antes de iniciar
                    JOptionPane.showMessageDialog(this,
                            """
                            Que os deuses do Norte estejam com você.
                            As Crônicas de Dravnir começam agora...
                            """, "Jogo Iniciado", JOptionPane.INFORMATION_MESSAGE);

                    // Mudar para a tela inicial do jogo
                    frame.setContentPane(new TelaLagoRio(frame, personagemSelecionado));

                    frame.revalidate();
                }
            });

            card.add(nome, BorderLayout.NORTH);
            card.add(imagem, BorderLayout.CENTER);
            card.add(selecionar, BorderLayout.SOUTH);

            painelPersonagens.add(card);
        }

        // Botão Voltar
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setFont(new Font("Arial", Font.BOLD, 18));
        botaoVoltar.setBackground(Color.GREEN.darker());
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.addActionListener(e -> {
            frame.setContentPane(new TelaMenu(frame));
            frame.revalidate();
        });

        add(painelPersonagens, BorderLayout.CENTER);
        add(botaoVoltar, BorderLayout.SOUTH);
    }

    private Personagem criarPersonagemPorIndice(int index) {
        return switch (index) {
            case 0 -> new Nomade("Ótimo médico");
            case 1 -> new Pirata("Sobrevivente nato");
            case 2 -> new Infiltrador("Alta camuflagem");
            case 3 -> new Explorador("Rastreador nato");
            case 4 -> new Cientista("Ótimo construtor");
            case 5 -> new Cacador("Ótimo lutador");
            default -> null;
        };
    }

    public Personagem getPersonagemSelecionado() {
        return personagemSelecionado;
    }
}
