package ambientes;

public class AmbienteFloresta extends Ambientes { //Falta a adição dos recursos disponíveis e ligação com os eventos
    //Atributos da subclasse:
    private boolean vegetacaoDensa; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean faunaAbundante; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean climaUmido; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    //Metodo construtor:
    public AmbienteFloresta(String nomeAmbiente, String descricaoAmbiente, int dificuldadeAmbiente, String recursosAmbiente, int probabilidadeEventos, String climaDominante,
                            boolean vegetacaoDensa, boolean faunaAbundante, boolean climaUmido) {
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente, probabilidadeEventos, climaDominante);
        this.vegetacaoDensa = vegetacaoDensa;
        this.faunaAbundante = faunaAbundante;
        this.climaUmido = climaUmido;
    }
    //Metodos acessores:
    public void setVegetacaoDensa(boolean vegetacaoDensa){
        this.vegetacaoDensa = vegetacaoDensa;
    }
    public boolean isVegetacaoDensa() {
        return vegetacaoDensa;
    }
    public void setFaunaAbundante(boolean faunaAbundante){
        this.faunaAbundante = faunaAbundante;
    }
    public boolean isFaunaAbundante() {
        return faunaAbundante;
    }
    public void setClimaUmido(boolean climaUmido){
        this.climaUmido = climaUmido;
    }
    public boolean isClimaUmido() {
        return climaUmido;
    }
}
