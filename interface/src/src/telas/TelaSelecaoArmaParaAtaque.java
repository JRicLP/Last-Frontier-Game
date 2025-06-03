package telas;

import itens.Arma;
import itens.Item;
import personagens.Personagem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaSelecaoArmaParaAtaque extends JDialog {
    private Arma armaSelecionada = null;

    public TelaSelecaoArmaParaAtaque(JFrame parent, Personagem personagem) {
        super(parent, "Selecionar Arma para Atacar", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        DefaultListModel<Arma> modelo = new DefaultListModel<>();
        List<Item> itens = personagem.getInventarioPersonagem().getListaItens();
        for (Item item : itens) {
            if (item instanceof Arma) {
                modelo.addElement((Arma) item);
            }
        }

        JList<Arma> listaArmas = new JList<>(modelo);
        listaArmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(listaArmas);
        add(scroll, BorderLayout.CENTER);

        JButton btnSelecionar = new JButton("Selecionar");
        btnSelecionar.addActionListener(e -> {
            armaSelecionada = listaArmas.getSelectedValue();
            if (armaSelecionada != null) {
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma arma!");
            }
        });

        add(btnSelecionar, BorderLayout.SOUTH);
    }

    public Arma getArmaSelecionada() {
        return armaSelecionada;
    }
}
