package itens;

public class Armas extends Item{
    //Atributos da subclasse:
    private String tipoArma;
    private double danoArma;
    private double alcanceArma;
    //Métodos da subclasse:
    public Armas(String nomeItem, double pesoItem, double durabilidadeItem, String tipoArma, double danoArma,
                 double alcanceArma){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoArma = tipoArma;
        this.danoArma = danoArma;
        this.alcanceArma = alcanceArma;
    }
    public void atacar(){

    }
}
