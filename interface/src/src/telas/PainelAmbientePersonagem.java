package telas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PainelAmbientePersonagem extends JPanel {

    private BufferedImage imagemAmbiente;
    private BufferedImage imagemItem; // Se quiser mostrar um item encontrado
    private String legendaItem;

    public PainelAmbientePersonagem(String caminhoImagemInicial) {
        setImagemAmbiente(caminhoImagemInicial);
    }

    public void setImagemAmbiente(String caminhoImagem) {
        try {
            imagemAmbiente = ImageIO.read(new File(caminhoImagem));
        } catch (IOException e) {
            System.err.println("Erro ao carregar imagem do ambiente: " + caminhoImagem);
            imagemAmbiente = null;
        }
        repaint();
    }

    public void setItemSorteado(String caminhoImagemItem, String legenda) {
        if (caminhoImagemItem != null) {
            try {
                imagemItem = ImageIO.read(new File(caminhoImagemItem));
                legendaItem = legenda;
            } catch (IOException e) {
                System.err.println("Erro ao carregar imagem do item: " + caminhoImagemItem);
                imagemItem = null;
                legendaItem = null;
            }
        } else {
            imagemItem = null;
            legendaItem = null;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagemAmbiente != null) {
            g.drawImage(imagemAmbiente, 0, 0, getWidth(), getHeight(), this);
        }

        if (imagemItem != null) {
            int largura = getWidth() / 5;
            int altura = getHeight() / 5;
            int x = getWidth() - largura - 20;
            int y = getHeight() - altura - 40;

            g.drawImage(imagemItem, x, y, largura, altura, this);

            if (legendaItem != null) {
                g.setColor(Color.WHITE);
                g.fillRect(x, y + altura, largura, 20);
                g.setColor(Color.BLACK);
                g.drawString(legendaItem, x + 5, y + altura + 15);
            }
        }
    }
}
