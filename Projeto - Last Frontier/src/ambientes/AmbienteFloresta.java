package ambientes;

public class AmbienteFloresta extends Ambientes {
    //Atributos da subclasse:
    private String vegetacaoDensa;
    private String faunaAbundante;
    private String climaUmido;
    //Metodo construtor:
    public AmbienteFloresta(String nomeAmbiente, String descricaoAmbiente, double dificuldadeAmbiente,
                            String recursosAmbiente, double probabilidadeEventos, String climaDominante, String vegetacaoDensa,
                            String faunaAbundante, String climaUmido) {
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente,
                probabilidadeEventos, climaDominante);
        this.vegetacaoDensa = vegetacaoDensa;
        this.faunaAbundante = faunaAbundante;
        this.climaUmido = climaUmido;
    }
    //Metodos acessores:
    public void setVegetacaoDensa(String vegetacaoDensa){
        this.vegetacaoDensa = vegetacaoDensa;
    }
    public String getVegetacaoDensa(){
        return vegetacaoDensa;
    }
    public void setFaunaAbundante(String faunaAbundante){
        this.faunaAbundante = faunaAbundante;
    }
    public String getFaunaAbundante(){
        return faunaAbundante;
    }
    public void setClimaUmido(String climaUmido){
        this.climaUmido = climaUmido;
    }
    public String getClimaUmido(){
        return climaUmido;
    }
}
