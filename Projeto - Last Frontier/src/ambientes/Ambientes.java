package ambientes;

public class Ambientes {
    //Atributos da superclasse:
    private String nomeAmbiente;
    private String descricaoAmbiente;
    private double dificuldadeAmbiente;
    private String recursosAmbiente;
    private double probabilidadeEventos;
    private String climaDominante;
    //Métodos da superclasse:
    public Ambientes(String nomeAmbiente, String descricaoAmbiente, double dificuldadeAmbiente,
                     String recursosAmbiente, double probabilidadeEventos, String climaDominante){
        this.nomeAmbiente = nomeAmbiente;
        this.descricaoAmbiente = descricaoAmbiente;
        this.dificuldadeAmbiente = dificuldadeAmbiente;
        this.recursosAmbiente = recursosAmbiente;
        this.probabilidadeEventos = probabilidadeEventos;
        this.climaDominante = climaDominante;
    }
    public void explorarAmbiente(){

    }
    public void gerarEvento(){

    }
    public void modificarClima(){

    }

}
