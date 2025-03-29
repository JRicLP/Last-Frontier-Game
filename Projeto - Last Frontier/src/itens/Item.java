package itens;

public class Item { //Essa classe deverá ser abstrata
    //Atributos da superclasse:
    private String nomeItem;
    private double pesoItem;
    private double durabilidadeItem;
    //Métodos da superclassse:
    public Item(String nomeItem, double pesoItem, double durabilidadeItem){
        this.nomeItem = nomeItem;
        this.pesoItem = pesoItem;
        this.durabilidadeItem = durabilidadeItem;
    }
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
    public void usarItem(){ //É necessário revisar classes abstratas para a utilização desse metodo.
    }
}
