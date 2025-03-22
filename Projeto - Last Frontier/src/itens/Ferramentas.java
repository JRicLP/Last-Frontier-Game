package itens;

public class Ferramentas extends Item {
    //Atributos da subclasse:
    private String tipoFerramenta;
    private double eficienciaFerramenta;
    //Metodos da subclasse:
    public Ferramentas(String nomeItem, double pesoItem, double durabilidadeItem,
                       String tipoFerramenta, double eficienciaFerramenta){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoFerramenta = tipoFerramenta;
        this.eficienciaFerramenta = eficienciaFerramenta;
    }
    public void usarFerramenta(){

    }
}
