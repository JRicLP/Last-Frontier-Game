package ambientes;

public class Ambientes { //Essa classe será abstrata
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
    public void setNomeAmbiente(){
        this.nomeAmbiente = nomeAmbiente;
    }
    public String getNomeAmbiente(){
        return nomeAmbiente;
    }
    public void setDescricaoAmbiente(){
        this.descricaoAmbiente = descricaoAmbiente;
    }
    public String getDescricaoAmbiente(){
        return descricaoAmbiente;
    }
    public void setDificuldadeAmbiente(double dificuldadeAmbiente){
        this.dificuldadeAmbiente =  dificuldadeAmbiente;
    }
    public double getDificuldadeAmbiente(){
        return dificuldadeAmbiente;
    }
    public void setRecursosAmbiente(){
        this.recursosAmbiente = recursosAmbiente;
    }
    public String getRecursosAmbiente(){
        return recursosAmbiente;
    }
    public void setProbabilidadeEventos(double probabilidadeEventos){
        this.probabilidadeEventos =  probabilidadeEventos;
    }
    public double getProbabilidadeEventos(){
        return probabilidadeEventos;
    }
    public void setClimaDominante(){
        this.climaDominante = climaDominante;
    }
    public String getClimaDominante(){
        return climaDominante;
    }
    public void explorarAmbiente(){ //Metodo geral
    }
    public void gerarEvento(){ //Metodo geral
    }
    public void modificarClima(){ //Metodo geral
    }
}
