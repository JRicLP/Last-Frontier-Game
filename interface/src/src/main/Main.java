package main;

import telas.TelaInicial;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("A CANÇÃO DE DRAVNIR");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Tamanho inicial com opção de maximizar
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null); // Centraliza na tela
            // frame.setResizable(false); // NÃO usar isso se quiser o botão de maximizar

            // ESC para sair
            frame.getRootPane().registerKeyboardAction(
                    e -> System.exit(0),
                    KeyStroke.getKeyStroke("ESCAPE"),
                    JComponent.WHEN_IN_FOCUSED_WINDOW
            );

            // Tela inicial
            TelaInicial telaInicial = new TelaInicial(frame);
            frame.setContentPane(telaInicial);
            frame.setVisible(true);
        });
    }
}
