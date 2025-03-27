package eventos;

public class Eventos{ //Essa classe será abstrata
    //Atributos da superclasse:
    private String nomeEvento;
    private String descricaoEvento;
    private double probabilidadeEvento;
    private String impactoEvento;
    private String condicaoEvento;
    //Métodos da superclasse:
    public Eventos(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                  String impactoEvento, String condicaoEvento){
        this.nomeEvento = nomeEvento;
        this.descricaoEvento = descricaoEvento;
        this.probabilidadeEvento = probabilidadeEvento;
        this.impactoEvento = impactoEvento;
        this.condicaoEvento = condicaoEvento;
    }
    public void setNomeEvento(){
        this.nomeEvento = nomeEvento;
    }
    public String getNomeEvento(){
        return nomeEvento;
    }
    public void setDescricaoEvento(){
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
    public void setImpactoEvento(){
        this.impactoEvento = impactoEvento;
    }
    public String getImpactoEvento(){
        return impactoEvento;
    }
    public void setCondicaoEvento(){
        this.condicaoEvento = condicaoEvento;
    }
    public String getCondicaoEvento(){
        return condicaoEvento;
    }
    public void exercutarEvento(){ //Esse metodo será sobrescrito nas subclasses
    }
}
