package inventario;

import java.util.ArrayList;
import interfaces.InventoryActions;
import itens.*;

public class Inventario implements InventoryActions {
    //Atributos da classe:
    private ArrayList<Item> listaItens;
    private int pesoInventario;
    private int capacidadeInventario;

    //Metodo construtor:
    public Inventario(ArrayList<Item> listaItens, int pesoInventario, int capacidadeInventario) {
        this.listaItens = new ArrayList<>(capacidadeInventario);
        this.pesoInventario = pesoInventario;
        this.capacidadeInventario = capacidadeInventario;
    }

    //Metodos acessores:
    public void setListaItens(ArrayList<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public ArrayList<Item> getListaItens() {
        return listaItens;
    }

    public void setPesoInventario(int pesoInventario) {
        this.pesoInventario = pesoInventario;
    }

    public int getPesoInventario() {
        return pesoInventario;
    }

    public void setCapacidadeInventario(int capacidadeInventario) {
        this.capacidadeInventario = capacidadeInventario;
    }

    public int getCapacidadeInventario() {
        return capacidadeInventario;
    }

    //Metodos implementados:
    @Override
    public void adicionarItem(Item itemAdicionado) {
        this.getListaItens().add(itemAdicionado);
        System.out.println("O item " + itemAdicionado + " foi adicionado!");
    }

    @Override
    public void descartarItem(Item itemDescartado) {
        this.getListaItens().remove(itemDescartado);
        System.out.println("O item " + itemDescartado + " foi descartado!");
    }

    @Override
    public void selecionarItem(int posicaoItem) { //Esse metodo ainda irá evoluir
        Item itemSelecionado = this.getListaItens().get(posicaoItem);
        if (itemSelecionado instanceof Agua || itemSelecionado instanceof Alimentos || itemSelecionado instanceof Remedios) {
            itemSelecionado.usar(itemSelecionado.getNomeItem());
            System.out.println("O item " + itemSelecionado.getNomeItem() + " foi consumido!");
            this.getListaItens().remove(posicaoItem);
        } else if (itemSelecionado instanceof Materiais) {
            System.out.println("Material selecionado, escolha outro para poder combinar!");
            this.mostrarInventario();
        } else if (itemSelecionado instanceof Armas) {
            System.out.println("Arma selecionada!");
        } else if (itemSelecionado instanceof  Ferramentas) {
            System.out.println("Ferramenta pronta para uso!");
        }
    }
        @Override
        public void mostrarInventario () {
            for (int contador = 0; contador < listaItens.size(); contador++) {
                System.out.println(contador + "- " + listaItens.get(contador));
            }
        }
}