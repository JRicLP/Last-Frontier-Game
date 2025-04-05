package ambientes;

import interfaces.AmbientActions;

public abstract class Ambientes implements AmbientActions {
    //Atributos da superclasse:
    private String nomeAmbiente;
    private String descricaoAmbiente;
    private double dificuldadeAmbiente;
    private String recursosAmbiente;
    private double probabilidadeEventos;
    private String climaDominante;
    //Métodos construtor da superclasse:
    public Ambientes(String nomeAmbiente, String descricaoAmbiente, double dificuldadeAmbiente,
                     String recursosAmbiente, double probabilidadeEventos, String climaDominante){
        this.nomeAmbiente = nomeAmbiente;
        this.descricaoAmbiente = descricaoAmbiente;
        this.dificuldadeAmbiente = dificuldadeAmbiente;
        this.recursosAmbiente = recursosAmbiente;
        this.probabilidadeEventos = probabilidadeEventos;
        this.climaDominante = climaDominante;
    }
    //Metodos acessores da superclasse:
    public void setNomeAmbiente(String nomeAmbiente){
        this.nomeAmbiente = nomeAmbiente;
    }
    public String getNomeAmbiente(){
        return nomeAmbiente;
    }
    public void setDescricaoAmbiente(String descricaoAmbiente){
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
    public void setRecursosAmbiente(String recursosAmbiente){
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
    public void setClimaDominante(String climaDominante){
        this.climaDominante = climaDominante;
    }
    public String getClimaDominante(){
        return climaDominante;
    }
    //Metodos implementados na superclasse:
    @Override
    public void exlorar() {

    }

    @Override
    public void gerarEvento() {

    }
    @Override
    public void modificarClima() {

    }
}
