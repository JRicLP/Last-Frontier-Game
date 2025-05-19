package ambientes;

import eventos.EventoClimatico;
import interfaces.AmbientActions;
import personagens.Personagem;

public abstract class Ambientes implements AmbientActions {
    //Atributos da superclasse:
    private String nomeAmbiente;
    private String descricaoAmbiente;
    private int dificuldadeAmbiente;
    private String recursosAmbiente; //Precisamos verificar como esse atributo irá se relacionar com a classe
    private int probabilidadeEventos; //Precisamos verificar como esse atributo irá se relacionar com a classe
    private String climaDominante; //Precisamos verificar como esse atributo irá se relacionar com a classe
    //Metodo construtor da superclasse:
    public Ambientes(String nomeAmbiente, String descricaoAmbiente, int dificuldadeAmbiente,
                     String recursosAmbiente, int probabilidadeEventos, String climaDominante){
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
    public void setDificuldadeAmbiente(int dificuldadeAmbiente){
        this.dificuldadeAmbiente =  dificuldadeAmbiente;
    }
    public int getDificuldadeAmbiente(){
        return dificuldadeAmbiente;
    }
    public void setRecursosAmbiente(String recursosAmbiente){
        this.recursosAmbiente = recursosAmbiente;
    }
    public String getRecursosAmbiente(){
        return recursosAmbiente;
    }
    public void setProbabilidadeEventos(int probabilidadeEventos){
        this.probabilidadeEventos =  probabilidadeEventos;
    }
    public int getProbabilidadeEventos(){
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
    public void exlorar(Personagem personagemAtual) {
        System.out.println("Explorar o ambiente consome pontos de Energia, Fome e Sede");
        System.out.println(personagemAtual.getNomePersonagem() + " explorou o ambiente de forma incansável e encontrou alguns recursos!");
        //Futuramente esse metodo irá mostrar os recursos encontrados no ambiente que foi explorado!
    }
    @Override
    public void gerarEvento() {
        //Esse metodo utiliza algumas questões probabilísticas que serão alteradas no futuro!
    }
    @Override
    public void modificarClima(Ambientes ambienteAtual, EventoClimatico novoClima) {
        System.out.println("Com o passar do tempo, algumas mudanças foram notadas no ar e horizonte do ambiente " +
                ambienteAtual.getNomeAmbiente() + "...");
        System.out.println("Um novo clima foi definido: " + novoClima.getNomeEvento() + " , prepare-se da melhor forma!!");
    }
}
