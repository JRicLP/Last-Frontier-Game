package eventos;

public class Eventos{
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
    public void exercutarEvento(){

    }
}
