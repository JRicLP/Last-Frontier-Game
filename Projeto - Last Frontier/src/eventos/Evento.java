package eventos;

import ambientes.Ambiente;
import interfaces.AcoesEventos;
import personagens.Personagem;

public abstract class Evento implements AcoesEventos {

    //Atributos da superclasse:
    private String nomeEvento;
    private String descricaoEvento;
    private int probabilidadeEvento;
    private String impactoEvento;
    private boolean condicaoEvento; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento

    //Metodo construtor:
    public Evento(String nomeEvento, String descricaoEvento, int probabilidadeEvento, String impactoEvento, boolean condicaoEvento){
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
    public void setProbabilidadeEvento(int probabilidadeEvento){ //Vamos definir uma probabilidade de 0 a 10
        this.probabilidadeEvento = probabilidadeEvento;
    }
    public int getProbabilidadeEvento(){
        return probabilidadeEvento;
    }
    public void setImpactoEvento(String impactoEvento){
        this.impactoEvento = impactoEvento;
    }
    public String getImpactoEvento(){
        return impactoEvento;
    }
    public void setCondicaoEvento(boolean condicaoEvento){
        this.condicaoEvento = condicaoEvento;
    }
    public boolean isCondicaoEvento() {
        return condicaoEvento;
    }

    //Metodos implementados:
    @Override
    public void executar(Personagem personagemAtual, Ambiente ambienteAtual) {
        if (this.isCondicaoEvento()) {
            System.out.println("Evento " + this.getNomeEvento() + " aconteceu no ambiente " + ambienteAtual.getNomeAmbiente() + "!");
            System.out.println("Descrição: " + this.getDescricaoEvento());
            System.out.println("Impacto Geral: " + this.getImpactoEvento());
        } else {
            System.out.println("As condições para o evento '" + this.getNomeEvento() + "' não foram atendidas.");
        }
    }
}
