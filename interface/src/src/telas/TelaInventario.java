package telas;
import itens.*;
import personagens.Personagem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaInventario extends JDialog {
    private TelaPrincipalJogo telaPrincipal;
    private Personagem personagem;
    private DefaultListModel<Item> modeloLista;
    private JList<Item> listaItens;

    // Construtor do painel de inventário
    public TelaInventario(JFrame janelaPai,TelaPrincipalJogo telaPrincipal, Personagem personagem) {
        super(janelaPai, "Inventário", true);
        this.telaPrincipal =  telaPrincipal;
        this.personagem = personagem;

        setSize(400, 400);
        setLocationRelativeTo(janelaPai);
        setLayout(new BorderLayout());

        // Inicializa e preenche a lista de itens
        modeloLista = new DefaultListModel<>();
        atualizarListaItens();

        listaItens = new JList<>(modeloLista);
        listaItens.setCellRenderer(new ItemRenderer());
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
            if (telaPrincipal != null) {
                telaPrincipal.atualizarTela();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um item para usar.");
        }
    }
    private class ItemRenderer extends JPanel implements ListCellRenderer<Item> {
        private JLabel labelImagem = new JLabel();
        private JLabel labelNome = new JLabel();

        public ItemRenderer() {
            setLayout(new FlowLayout(FlowLayout.LEFT));
            labelImagem = new JLabel();
            labelNome.setFont(new Font("Arial", Font.PLAIN, 14));

            add(labelImagem);
            add(labelNome);
        }

        @Override
        public Component getListCellRendererComponent(
                JList<? extends Item> list,
                Item item,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {

            if (item != null) {

                String caminho = "imagens/";
                if (item instanceof Arma) caminho += "armas/";
                else if (item instanceof Ferramenta) caminho += "ferramentas/";
                else if (item instanceof Remedio) caminho += "remedios/";
                else if (item instanceof Alimento) caminho += "alimentos/";
                else if (item instanceof Agua) caminho += "agua/";
                else if (item instanceof Material) caminho += "materiais/";

                caminho += item.getNomeItem() + ".png";

                ImageIcon iconeOriginal = new ImageIcon(caminho);
                Image imagemRedimensionada = iconeOriginal.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
                labelImagem.setIcon(new ImageIcon(imagemRedimensionada));

                labelNome.setText(item.getNomeItem());
            }

            if (isSelected) {
                setBackground(new Color(0, 120, 215));
                setForeground(Color.WHITE);
                labelNome.setForeground(Color.WHITE);
            } else {
                setBackground(Color.WHITE);
                setForeground(Color.BLACK);
                labelNome.setForeground(Color.BLACK);
            }

            return this;

        }
    }

}
