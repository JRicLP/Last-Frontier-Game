package itens;

import interfaces.MaterialsActions;

public class Materiais extends Item implements MaterialsActions {
    //Atributos da classe:
    private String tipoMaterial;
    private int resistenciaMaterial;
    //Metodo construtor:
    public Materiais(String nomeItem, int pesoItem, int durabilidadeItem, String tipoMaterial, int resistenciaMaterial) {
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
    public void setResistenciaMaterial(int resistenciaMaterial) {
        this.resistenciaMaterial = resistenciaMaterial;
    }
    public int getResistenciaMaterial() {
        return resistenciaMaterial;
    }
    //Metodo implementado:
    @Override
    public void combinarMateriais(Materiais material1, Materiais material2) { //Metodo especial para materiais
        System.out.println("Os materiais foram combinados para formar um novo item!");
        //O metodo irá evoluir em breve.
    }
}
