package itens;

import interfaces.ItensActions;
import personagens.Personagem;

public abstract class Item implements ItensActions {
    //Atributos da superclasse:
    private String nomeItem;
    private int pesoItem;
    private int durabilidadeItem;
    //Metodo construtor da superclasse:
    public Item(String nomeItem, int pesoItem, int durabilidadeItem) {
        this.nomeItem = nomeItem;
        this.pesoItem = pesoItem;
        this.durabilidadeItem = durabilidadeItem;
    }
    //Metodos acessores da superclasse:
    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
    public String getNomeItem() {
        return nomeItem;
    }
    public void setPesoItem(int pesoItem) {
        this.pesoItem = pesoItem;
    }
    public int getPesoItem() {
        return pesoItem;
    }
    public void setDurabilidadeItem(int durabilidadeItem) {
        this.durabilidadeItem = durabilidadeItem;
    }
    public int getDurabilidadeItem() {
        return durabilidadeItem;
    }
    //Metodos implementados:
    @Override
    public void usar(Item item, Personagem personagem) {

    }
}
