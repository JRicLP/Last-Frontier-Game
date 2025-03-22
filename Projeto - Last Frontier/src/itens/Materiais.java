package itens;

public class Materiais extends Item {
    //Atributos da classe:
    private String tipoMaterial;
    private double resistenciaMaterial;
    //Métodos da classe:
    public Materiais(String nomeItem, double pesoItem, double durabilidadeItem, String tipoMaterial,
                     double resistenciaMaterial){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoMaterial = tipoMaterial;
        this.resistenciaMaterial = resistenciaMaterial;
    }
    public void combinarMaterial(){

    }
}
