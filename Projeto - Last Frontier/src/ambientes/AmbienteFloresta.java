package ambientes;

public class AmbienteFloresta extends Ambientes {
    //Atributos da subclasse:
    private String vegetacaoDensa;
    private String faunaAbundante;
    private String climaUmido;
    //Metodos da subclasse:
    public AmbienteFloresta(String nomeAmbiente, String descricaoAmbiente, double dificuldadeAmbiente,
                            String recursosAmbiente, double probabilidadeEventos, String climaDominante, String vegetacaoDensa,
                            String faunaAbundante, String climaUmido) {
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente,
                probabilidadeEventos, climaDominante);
        this.vegetacaoDensa = vegetacaoDensa;
        this.faunaAbundante = faunaAbundante;
        this.climaUmido = climaUmido;
    }
    public void setVegetacaoDensa(){
        this.vegetacaoDensa = vegetacaoDensa;
    }
    public String getVegetacaoDensa(){
        return vegetacaoDensa;
    }
    public void setFaunaAbundante(){
        this.faunaAbundante = faunaAbundante;
    }
    public String getFaunaAbundante(){
        return faunaAbundante;
    }
    public void setClimaUmido(){
        this.climaUmido = climaUmido;
    }
    public String getClimaUmido(){
        return climaUmido;
    }
}
