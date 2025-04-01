package interfaces;

import itens.Item;

public interface InventoryActions {
    //Metodos que serão implementados na classe Inventario:
    public abstract void adicionarItem(Item itemAdicionado);
    public abstract void removerItem(Item itemRemovido);
    public abstract void usarItem(Item itemUsado);
}
