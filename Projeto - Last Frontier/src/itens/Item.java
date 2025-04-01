package itens;

import interfaces.ItensActions;

public abstract class Item implements ItensActions { //Essa classe deverá ser abstrata
    //Atributos da superclasse:
    private String nomeItem;
    private double pesoItem;
    private double durabilidadeItem;
    //Metodo construtor da superclasse:
    public Item(String nomeItem, double pesoItem, double durabilidadeItem){
        this.nomeItem = nomeItem;
        this.pesoItem = pesoItem;
        this.durabilidadeItem = durabilidadeItem;
    }
    //Metodos acessores da superclasse:
    public void setNomeItem(String nomeItem){
        this.nomeItem = nomeItem;
    }
    public String getNomeItem(){
        return nomeItem;
    }
    public void setPesoItem(double pesoItem){
        this.pesoItem = pesoItem;
    }
    public double getPesoItem(){
        return pesoItem;
    }
    public void setDurabilidadeItem(double durabilidadeItem){
        this.durabilidadeItem = durabilidadeItem;
    }
    public double getDurabilidadeItem(){
        return durabilidadeItem;
    }
    //Metodos implementados:
    @Override
    public void usar(String nomeItem) {

    }
}
