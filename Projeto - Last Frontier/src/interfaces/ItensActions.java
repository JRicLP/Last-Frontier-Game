package interfaces;
import itens.Item;
import personagens.Personagem;

public interface ItensActions {
    /* Metodos especiais da superclasse Item:
     * Esse metodo será sobrescrito para uma categoria de itens denominada consumíveis que incluem:
     * Subclasse Agua, Subclasse Alimentos e Subclasse Remedios
     */
    public abstract void usar(Item item, Personagem personagem);
}
