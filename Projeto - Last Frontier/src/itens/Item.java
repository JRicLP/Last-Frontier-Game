package itens;

public class Item {
    //Atributos da superclasse:
    private String nomeItem;
    private double pesoItem;
    private double durabilidadeItem;
    //Métodos da superclassse:
    public Item(String nomeItem, double pesoItem, double durabilidadeItem) {
        this.nomeItem = nomeItem;
        this.pesoItem = pesoItem;
        this.durabilidadeItem = durabilidadeItem;
    }
}
