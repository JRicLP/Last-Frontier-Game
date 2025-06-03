package itens;

import interfaces.AcoesItens;
import personagens.Personagem;

public abstract class Item implements AcoesItens {
    //Atributos da superclasse:
    private String nomeItem;
    private int pesoItem;
    private int durabilidadeItem;
    private String imagem;
    private String caminhoImagem;
    //Metodo construtor da superclasse:
    public Item(String nomeItem, int pesoItem, int durabilidadeItem) {
        this.nomeItem = nomeItem;
        this.pesoItem = pesoItem;
        this.durabilidadeItem = durabilidadeItem;
    }
    //Metodos acessores da superclasse:

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

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
    public void setImagem(String imagem){
        this.imagem=imagem;
    }
    public String getImagem(){
        return imagem;
    }
    //Metodos implementados:
    @Override
    public void usar(Item item, Personagem personagem) {

    }
    @Override
    public String toString() {
        return getNomeItem() + " | Tipo: " + this.getClass().getSimpleName() + " | Peso: " + getPesoItem();
    }

}