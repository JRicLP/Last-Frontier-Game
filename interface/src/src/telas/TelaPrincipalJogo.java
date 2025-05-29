package telas;

import gerenciadores.GerenciadorDeItens;
import itens.*;
import personagens.Personagem;
import util.DescricaoItemUtils;
import telas.PainelAmbientePersonagem;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaPrincipalJogo extends JFrame {

    private PainelAmbientePersonagem painelAmbientePersonagem;
    private JLabel labelAmbiente;
    private JLabel labelTurno;
    private JLabel labelStatus;
    private JButton btnExplorar, btnAtacar, btnInventario, btnStatus, btnDescansar;
    private GerenciadorDeItens gerenciadorDeItens = new GerenciadorDeItens();
    private Personagem personagem;
    private int contadorTurnos = 0;
    private final int turnosMaximos = 25;
    private DescricaoItemUtils descricaoUtils;
    private final List<String> ambientes = List.of("lago", "floresta", "montanha", "caverna", "ruinas");

    public TelaPrincipalJogo(Personagem personagem) {
        this.personagem = personagem;
        this.descricaoUtils = new DescricaoItemUtils();
        configurarJanela();
        configurarComponentes();
        atualizarTela();
    }

    private void configurarJanela() {
        setTitle("Jogo de Sobrevivência");
        setSize(800, 600);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void configurarComponentes() {
        // TOPO
        labelAmbiente = new JLabel("Ambiente: Lago", SwingConstants.CENTER);
        labelTurno = new JLabel("Turno: 1 / " + turnosMaximos, SwingConstants.CENTER);
        JPanel painelTopo = new JPanel(new GridLayout(1, 2));
        painelTopo.add(labelAmbiente);
        painelTopo.add(labelTurno);
        add(painelTopo, BorderLayout.NORTH);

        // PAINEL CENTRAL COM IMAGEM ÚNICA
        String caminhoImagemInicial = getCaminhoImagemAmbiente(0);
        painelAmbientePersonagem = new PainelAmbientePersonagem(caminhoImagemInicial);
        add(painelAmbientePersonagem, BorderLayout.CENTER);

        // BARRA DE STATUS EMBAIXO
        labelStatus = new JLabel("", SwingConstants.CENTER);
        labelStatus.setFont(new Font("Arial", Font.PLAIN, 14));

        // BOTÕES
        JPanel painelBotoes = new JPanel(new GridLayout(1, 5));
        btnExplorar = new JButton("Explorar");
        btnAtacar = new JButton("Atacar Criatura");
        btnInventario = new JButton("Inventário");
        btnStatus = new JButton("Ver Status");
        btnDescansar = new JButton("Descansar");

        painelBotoes.add(btnExplorar);
        painelBotoes.add(btnAtacar);
        painelBotoes.add(btnInventario);
        painelBotoes.add(btnStatus);
        painelBotoes.add(btnDescansar);

        JPanel painelInferior = new JPanel(new BorderLayout());
        painelInferior.add(painelBotoes, BorderLayout.NORTH);
        painelInferior.add(labelStatus, BorderLayout.SOUTH);
        add(painelInferior, BorderLayout.SOUTH);

        configurarAcoes();
    }

    private void configurarAcoes() {
        btnExplorar.addActionListener(e -> realizarExploracao());
        btnAtacar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Você se prepara para atacar uma criatura!"));
        btnInventario.addActionListener(e -> new TelaInventario(this, personagem).setVisible(true));
        btnStatus.addActionListener(e -> mostrarStatus());
        btnDescansar.addActionListener(e -> realizarDescanso());
    }

    private void realizarExploracao() {
        personagem.setEnergiaPersonagem(personagem.getEnergiaPersonagem() - 8);
        personagem.setFomePersonagem(personagem.getFomePersonagem() - 8);
        personagem.setSedePersonagem(personagem.getSedePersonagem() - 8);
        personagem.setSanidadePersonagem(personagem.getSanidadePersonagem() - 5);

        contadorTurnos++;

        Item itemSorteado = gerenciadorDeItens.sortearItemAleatorio();
        if (itemSorteado != null) {
            // Exibe painel temporário com imagem do item encontrado
            exibirPainelTemporarioDoItem(itemSorteado);
            String caminhoItem = "imagens/itens/" + itemSorteado.getImagem();
            String legenda = itemSorteado.getNomeItem() + " - " + descricaoUtils.gerarTextoCompleto(itemSorteado);
            painelAmbientePersonagem.setItemSorteado(caminhoItem, legenda);

            // Painel compacto com descrição do item
            JPanel painel = new JPanel(new GridLayout(0, 1));
            painel.add(new JLabel("Você encontrou: " + itemSorteado.getNomeItem()));
            painel.add(new JLabel("<html>" + descricaoUtils.gerarTextoCompleto(itemSorteado) + "</html>"));

            JDialog dialogo = new JDialog(this, "Item Encontrado", true);
            dialogo.setUndecorated(true); // remove bordas padrão
            dialogo.setLayout(new BorderLayout());
            dialogo.setSize(400, 150);
            dialogo.setLocation(getX() + getWidth() / 2 - 200, getY() + getHeight() - 200); // posiciona mais embaixo

// Descrição
            JPanel painelDescricao = new JPanel(new GridLayout(0, 1));
            painelDescricao.setBackground(new Color(30, 30, 30));
            JLabel titulo = new JLabel("                Você encontrou: " + itemSorteado.getNomeItem());
            titulo.setForeground(Color.WHITE);
            JLabel descricao = new JLabel("<html>" + descricaoUtils.gerarTextoCompleto(itemSorteado) + "</html>");
            descricao.setForeground(Color.LIGHT_GRAY);
            painelDescricao.add(titulo);
            painelDescricao.add(descricao);

// Botões
            JPanel botoes = new JPanel();
            JButton btnPegar = new JButton("Pegar Item");
            JButton btnDeixar = new JButton("Deixar");

            btnPegar.addActionListener(ev -> {
                try {
                    personagem.getInventarioPersonagem().adicionarItem(itemSorteado);
                    JOptionPane.showMessageDialog(this,
                            itemSorteado.getNomeItem() + " foi adicionado ao inventário.");
                } catch (exceptions.InventarioCheioException e) {
                    JOptionPane.showMessageDialog(this,
                            "Inventário cheio! Não foi possível adicionar o item.", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (exceptions.InventarioPesadoException e) {
                    int pesoAtual = personagem.getInventarioPersonagem().getPesoMaximo() - personagem.getInventarioPersonagem().getPesoSuportado();
                    int pesoMaximo = personagem.getInventarioPersonagem().getPesoMaximo();
                    JOptionPane.showMessageDialog(this,
                            "Item pesado!\nPeso atual: " + pesoAtual + " / " + pesoMaximo + "\nItem: " +
                                    itemSorteado.getNomeItem() + " (" + itemSorteado.getPesoItem() + "kg)",
                            "Peso Excedido", JOptionPane.ERROR_MESSAGE);
                }
                dialogo.dispose();
            });

            btnDeixar.addActionListener(ev -> {
                JOptionPane.showMessageDialog(this, "Você deixou o item para trás.");
                dialogo.dispose();
            });

            botoes.add(btnPegar);
            botoes.add(btnDeixar);

            dialogo.add(painelDescricao, BorderLayout.CENTER);
            dialogo.add(botoes, BorderLayout.SOUTH);

            dialogo.setVisible(true);
        }

        painelAmbientePersonagem.setItemSorteado(null, null);
        atualizarTela();

        if (!personagem.estaVivo()) {
            JOptionPane.showMessageDialog(this, "Você morreu! Fim de jogo.");
            System.exit(0);
        }

        if (contadorTurnos >= turnosMaximos) {
            JOptionPane.showMessageDialog(this, "Parabéns! Você sobreviveu por " + turnosMaximos + " turnos!");
            System.exit(0);
        }
    }

    private void realizarDescanso() {
        personagem.descansar(); // Chama o método encapsulado
        contadorTurnos++;
        atualizarTela();

        if (!personagem.estaVivo()) {
            JOptionPane.showMessageDialog(this, "Você morreu ao descansar! Fim de jogo.");
            System.exit(0);
        }

        if (contadorTurnos >= turnosMaximos) {
            JOptionPane.showMessageDialog(this, "Parabéns! Você sobreviveu por " + turnosMaximos + " turnos!");
            System.exit(0);
        }
    }


    private void mostrarStatus() {
        JOptionPane.showMessageDialog(this, personagem.statusFormatado());
    }

    private void atualizarTela() {
        labelTurno.setText("Turno: " + (contadorTurnos + 1) + " / " + turnosMaximos);

        int indexAmbiente = contadorTurnos / 5;
        if (indexAmbiente >= ambientes.size()) indexAmbiente = ambientes.size() - 1;

        String caminhoAmbiente = getCaminhoImagemAmbiente(indexAmbiente); //
        painelAmbientePersonagem.setImagemAmbiente(caminhoAmbiente);

        String nomeAmbiente = ambientes.get(indexAmbiente);
        labelAmbiente.setText("Ambiente: " + nomeAmbiente);

        labelStatus.setText("❤️ Vida: " + personagem.getVidaPersonagem() +
                " | 🍗 Fome: " + personagem.getFomePersonagem() +
                " | 💧 Sede: " + personagem.getSedePersonagem() +
                " | ⚡ Energia: " + personagem.getEnergiaPersonagem() +
                " | 🧠 Sanidade: " + personagem.getSanidadePersonagem());
    }

    // Este método agora constrói o caminho da imagem corretamente
    private String getCaminhoImagemAmbiente(int indexAmbiente) {
        String nomeAmbiente = ambientes.get(indexAmbiente).toLowerCase(); // Ex: "lago"
        // Agora, personagem.getImagemPersonagemNoAmbiente() retornará "cacador"
        String nomeDoArquivoDoPersonagem = personagem.getImagemPersonagemNoAmbiente();
        // Construindo o caminho completo e CORRETO
        return "imagens/ambientes/" + nomeAmbiente + "_" + nomeDoArquivoDoPersonagem + ".png";
    }
    private void exibirPainelTemporarioDoItem(Item item) {
        JPanel painelItem = new JPanel(new BorderLayout());
        painelItem.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        painelItem.setBackground(Color.BLACK);

        String caminho = "imagens/";
        if (item instanceof Armas) caminho += "armas/";
        else if (item instanceof Ferramentas) caminho += "ferramentas/";
        else if (item instanceof Remedios) caminho += "remedios/";
        else if (item instanceof Alimentos) caminho += "alimentos/";
        else if (item instanceof Agua) caminho += "agua/";
        else if (item instanceof Materiais) caminho += "materiais/";

        caminho += item.getNomeItem() + ".png";

        ImageIcon imagemIconeOriginal = new ImageIcon(caminho);
        Image imagemRedimensionada = imagemIconeOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon imagemIcone = new ImageIcon(imagemRedimensionada);
        JLabel imagemLabel = new JLabel(imagemIcone);
        imagemLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel nomeLabel = new JLabel(item.getNomeItem(), JLabel.CENTER);
        nomeLabel.setForeground(Color.WHITE);
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));

        painelItem.add(nomeLabel, BorderLayout.NORTH);
        painelItem.add(imagemLabel, BorderLayout.CENTER);

        JOptionPane optionPane = new JOptionPane(painelItem, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog("Item Encontrado!");
        dialog.setModal(false);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);

        // Fecha automaticamente após 3 segundos
        new Timer(3000, e -> dialog.dispose()).start();
    }

}
