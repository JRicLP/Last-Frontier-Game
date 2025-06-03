package telas;

import eventos.EventoCriatura;
import itens.Arma;
import itens.Item;
import personagens.Personagem;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class TelaAtaque extends JDialog {
    private Personagem personagem;
    private JList<Arma> listaArmas;
    private DefaultListModel<Arma> modeloLista;
    private EventoCriatura criaturaSelecionada;

    public TelaAtaque(JFrame pai, Personagem personagem) {
        super(pai, "Atacar Criatura", true);
        this.personagem = personagem;
        this.criaturaSelecionada = criaturaSelecionada;

        setSize(400, 300);
        setLocationRelativeTo(pai);
        setLayout(new BorderLayout());

        modeloLista = new DefaultListModel<>();
        carregarArmas();

        listaArmas = new JList<>(modeloLista);
        listaArmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(listaArmas);
        add(scroll, BorderLayout.CENTER);

        JButton btnAtacar = new JButton("Atacar");
        btnAtacar.addActionListener(e -> realizarAtaque());
        add(btnAtacar, BorderLayout.SOUTH);
    }

    private void carregarArmas() {
        List<Item> itens = personagem.getInventarioPersonagem().getListaItens();
        List<Arma> armas = itens.stream()
                .filter(item -> item instanceof Arma)
                .map(item -> (Arma) item)
                .collect(Collectors.toList());

        for (Arma arma : armas) {
            modeloLista.addElement(arma);
        }

        if (armas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Você não tem armas para atacar.");
            dispose();
        }
    }

    private void realizarAtaque() {
        Arma armaSelecionada = listaArmas.getSelectedValue();
        if (armaSelecionada != null) {
            armaSelecionada.atacar(personagem,criaturaSelecionada);
            JOptionPane.showMessageDialog(this, "Você atacou usando: " + armaSelecionada.getNomeItem());
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma arma para atacar.");
        }
    }
}
