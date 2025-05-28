package eventos;

import ambientes.Ambientes;
import interfaces.AcoesEventos;
import personagens.Personagem;

public abstract class Eventos implements AcoesEventos {

    //Atributos da superclasse:
    private String nomeEvento;
    private String descricaoEvento;
    private int probabilidadeEvento;
    private String impactoEvento; //É necessário revisar esse atributo e sua relação com a classe
    private boolean condicaoEvento; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento

    //Metodo construtor:
    public Eventos(String nomeEvento, String descricaoEvento, int probabilidadeEvento, String impactoEvento, boolean condicaoEvento){
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
    public void executar(Personagem personagemAtual, Ambientes ambienteAtual, Eventos eventoAplicado) {
        if (condicaoEvento) {
            System.out.println("Evento " + eventoAplicado.getNomeEvento() + " aconteceu: " +
                    eventoAplicado.getDescricaoEvento());
            System.out.println("Impacto: " + eventoAplicado.getImpactoEvento());
            //Futuramente será adicionado um verificador da condição necessária para o evento ocorrer!! - Exception
        }
    }
}
