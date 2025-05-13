package itens;

import eventos.EventoCriatura;
import interfaces.WeaponsActions;

public class Armas extends Item implements WeaponsActions {
    //Atributos da subclasse:
    private String tipoArma;
    private int danoArma;
    private int alcanceArma;
    //Metodo construtor:
    public Armas(String nomeItem, int pesoItem, int durabilidadeItem, String tipoArma, int danoArma, int alcanceArma) {
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
    public void setDanoArma( int danoArma){
        this.danoArma = danoArma;
    }
    public int getDanoArma(){
        return danoArma;
    }
    public void setAlcanceArma(int alcanceArma){
        this.alcanceArma = alcanceArma;
    }
    public int getAlcanceArma(){
        return alcanceArma;
    }
    //Metodos implementados:
    @Override
    public void atacar(EventoCriatura criaturaAtacada) {
        System.out.println("Atacar um alvo consome Energia e utiliza pontos de Fome e Sede");
        //Esse mecanismo de diminuição de pontos será adicionado futuramente
        if (criaturaAtacada.getDistanciaCriatura() > this.getAlcanceArma()) {
            System.out.println("Este alvo está muito do longe do seu alcance!");
        } else {
            System.out.println("Você está atacando " + criaturaAtacada.getTipoCriatura() + "!");
            while (criaturaAtacada.getVidaCriatura() > 0 ) {
                System.out.println("Você desferiu um ataque certeiro em " + criaturaAtacada.getTipoCriatura() + " e seu sangue jorrou!");
                criaturaAtacada.setVidaCriatura(criaturaAtacada.getVidaCriatura() - this.getDanoArma());
                System.out.println(criaturaAtacada.getVidaCriatura());
            }
        }
    }
}
