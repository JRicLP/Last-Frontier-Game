package interfaces;

import itens.Item;

public interface InventoryActions {
    //Metodos que serão implementados na classe Inventario:
    public abstract void adicionarItem(Item itemAdicionado);
    public abstract void descartarItem(Item itemRemovido);
    public abstract void selecionarItem(int posicaoItem);
    public abstract void mostrarInventario();
}
