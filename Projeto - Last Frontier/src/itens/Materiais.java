package itens;

import interfaces.MaterialsActions;

public class Materiais extends Item implements MaterialsActions {
    //Atributos da classe:
    private String tipoMaterial;
    private double resistenciaMaterial;
    //Metodo construtor:
    public Materiais(String nomeItem, double pesoItem, double durabilidadeItem, String tipoMaterial, double resistenciaMaterial) {
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoMaterial = tipoMaterial;
        this.resistenciaMaterial = resistenciaMaterial;
    }
    //Metodos acessores:
    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
    public String getTipoMaterial() {
        return tipoMaterial;
    }
    public void setResistenciaMaterial(double resistenciaMaterial) {
        this.resistenciaMaterial = resistenciaMaterial;
    }
    public double getResistenciaMaterial() {
        return resistenciaMaterial;
    }
    //Metodo implementado:
    @Override
    public void combinarMateriais(String nomeItem1, String nomeItem2) { //Metodo especial para materiais

    }
}
