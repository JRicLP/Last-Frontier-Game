package itens;

public class Alimentos extends Item {
    //Atributos da subclasse
    private double valorNutricional;
    private String tipoAlimento;
    int prazoValidade;
    //Métodos da subclasse:
    public Alimentos(String nomeItem, double pesoItem, double durabilidadeItem, double valorNutricional, String tipoAlimento){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.valorNutricional = valorNutricional;
        this.tipoAlimento = tipoAlimento;
    }
    public void consumirAlimento(){

    }
}

