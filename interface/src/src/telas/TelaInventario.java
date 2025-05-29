package telas;
import itens.Item;
import personagens.Personagem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaInventario extends JDialog {

    private Personagem personagem;
    private DefaultListModel<Item> modeloLista;
    private JList<Item> listaItens;

    // Construtor do painel de inventário
    public TelaInventario(JFrame janelaPai, Personagem personagem) {
        super(janelaPai, "Inventário", true); // Janela modal
        this.personagem = personagem;

        setSize(400, 400);
        setLocationRelativeTo(janelaPai);
        setLayout(new BorderLayout());

        // Inicializa e preenche a lista de itens
        modeloLista = new DefaultListModel<>();
        atualizarListaItens();

        listaItens = new JList<>(modeloLista);
        listaItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(listaItens);

        JButton btnUsar = new JButton("Usar Item");
        btnUsar.addActionListener(e -> usarItemSelecionado());

        add(scroll, BorderLayout.CENTER);
        add(btnUsar, BorderLayout.SOUTH);
    }

    // Atualiza os itens exibidos no inventário
    private void atualizarListaItens() {
        modeloLista.clear();
        List<Item> itens = personagem.getInventarioPersonagem().getListaItens();
        for (Item item : itens) {
            modeloLista.addElement(item);
        }
    }

    // Lógica para usar um item selecionado
    private void usarItemSelecionado() {
        Item itemSelecionado = listaItens.getSelectedValue();
        if (itemSelecionado != null) {
            itemSelecionado.usar(itemSelecionado,personagem); // Aplica efeitos ao personagem
            personagem.getInventarioPersonagem().descartarItem(itemSelecionado); // Remove do inventário
            atualizarListaItens(); // Atualiza a exibição
            JOptionPane.showMessageDialog(this, "Você usou: " + itemSelecionado.getNomeItem());
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para usar.");
        }
    }
}
