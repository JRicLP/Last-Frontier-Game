package itens;

import interfaces.WeaponsActions;

public class Armas extends Item implements WeaponsActions {
    //Atributos da subclasse:
    private String tipoArma;
    private double danoArma;
    private double alcanceArma;
    //Metodo construtor:
    public Armas(String nomeItem, double pesoItem, double durabilidadeItem, String tipoArma, double danoArma,
                 double alcanceArma){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.tipoArma = tipoArma;
        this.danoArma = danoArma;
        this.alcanceArma = alcanceArma;
    }
    //Metodos acessores:
    public void setTipoArma(String tipoArma){
        this.tipoArma = tipoArma;
    }
    public String getTipoArma(){
        return tipoArma;
    }
    public void setDanoArma(double danoArma){
        this.danoArma =  danoArma;
    }
    public double getDanoArma(){
        return danoArma;
    }
    public void setAlcanceArma(double alcanceArma){
        this.alcanceArma = alcanceArma;
    }
    public double getAlcanceArma(){
        return alcanceArma;
    }
    public void atacar(){ //Metodo que será sobrescrito
    }
    //Metodos implementados:
    @Override
    public void atacar(String alvo) {

    }
}
