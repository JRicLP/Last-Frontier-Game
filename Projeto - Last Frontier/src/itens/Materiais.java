package itens;

public class Materiais extends Item {
    //Atributos da classe:
    private String tipoMaterial;
    private double resistenciaMaterial;
    //Métodos da classe:
    public Materiais(String nomeItem, double pesoItem, double durabilidadeItem, String tipoMaterial, double resistenciaMaterial){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoMaterial = tipoMaterial;
        this.resistenciaMaterial = resistenciaMaterial;
    }
    public void setTipoMaterial(){
        this.tipoMaterial = tipoMaterial;
    }
    public String getTipoMaterial(){
        return tipoMaterial;
    }
    public void setResistenciaMaterial(double resistenciaMaterial){
        this.resistenciaMaterial = resistenciaMaterial;
    }
    public double getResistenciaMaterial(){
        return resistenciaMaterial;
    }
    public void combinarMaterial(){ //Metodo que será sobrescrito
    }
}
