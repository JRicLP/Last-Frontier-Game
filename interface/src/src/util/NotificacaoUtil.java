package util;

import javax.swing.JOptionPane;

public class NotificacaoUtil {

    public void mostrarNotificacao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Notificação", JOptionPane.INFORMATION_MESSAGE);
    }
}
