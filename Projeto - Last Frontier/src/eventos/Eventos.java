package eventos;

import ambientes.Ambientes;
import interfaces.EventsActions;
import personagens.Personagem;

public abstract class Eventos implements EventsActions {
    //Atributos da superclasse:
    private String nomeEvento;
    private String descricaoEvento;
    private double probabilidadeEvento;
    private String impactoEvento;
    private String condicaoEvento;
    //Metodo construtor:
    public Eventos(String nomeEvento, String descricaoEvento, double probabilidadeEvento, String impactoEvento, String condicaoEvento){
        this.nomeEvento = nomeEvento;
        this.descricaoEvento = descricaoEvento;
        this.probabilidadeEvento = probabilidadeEvento;
        this.impactoEvento = impactoEvento;
        this.condicaoEvento = condicaoEvento;
    }
    //Metodos acessores:
    public void setNomeEvento(String nomeEvento){
        this.nomeEvento = nomeEvento;
    }
    public String getNomeEvento(){
        return nomeEvento;
    }
    public void setDescricaoEvento(String descricaoEvento){
        this.descricaoEvento = descricaoEvento;
    }
    public String getDescricaoEvento(){
        return descricaoEvento;
    }
    public void setProbabilidadeEvento(double probabilidadeEvento){
        this.probabilidadeEvento = probabilidadeEvento;
    }
    public double getProbabilidadeEvento(){
        return probabilidadeEvento;
    }
    public void setImpactoEvento(String impactoEvento){
        this.impactoEvento = impactoEvento;
    }
    public String getImpactoEvento(){
        return impactoEvento;
    }
    public void setCondicaoEvento(String condicaoEvento){
        this.condicaoEvento = condicaoEvento;
    }
    public String getCondicaoEvento(){
        return condicaoEvento;
    }
    //Metodos implementados:
    @Override
    public void executar(Personagem personagemAtual, Ambientes ambienteAtual, Eventos eventoAplicado) {
        System.out.println("O evento " + eventoAplicado.getNomeEvento() + " funciona da seguinte forma: " +
                eventoAplicado.getDescricaoEvento());
        System.out.println("Impacto: " + eventoAplicado.getImpactoEvento());
        //Futuramente será adicionado um verificador da condição necessária para o evento ocorrer!!
    }
}
