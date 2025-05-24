import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("LAST FRONTIER");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);

            // Começa com a tela inicial
            TelaInicial telaInicial = new TelaInicial(frame);
            frame.setContentPane(telaInicial);
            frame.setVisible(true);
        });


    }
}
