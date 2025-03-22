package itens;

public class Agua extends Item{
    //Atributos da subclasse:
    private double purezaAgua;
    private double volumeAgua;
    //Métodos da subclasse:
    public Agua(String nomeItem, double pesoItem, double durabilidadeItem, double purezaAgua, double volumeAgua){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.purezaAgua = purezaAgua;
        this.volumeAgua = volumeAgua;
    }
    public void beberAgua(){

    }
}
