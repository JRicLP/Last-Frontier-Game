package ambientes;

public class AmbienteLagoRio extends Ambientes{ //Falta a adição dos recursos disponíveis e ligação com os eventos
    //Atributos da subclasse:
    private boolean aguaAbundante; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean possibilidadePesca; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean terrenoLamacento; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    //Metodo construtor:
    public AmbienteLagoRio(String nomeAmbiente, String descricaoAmbiente, int dificuldadeAmbiente, String recursosAmbiente, int probabilidadeEventos, String climaDominante,
                           boolean aguaAbundante, boolean possibilidadePesca, boolean terrenoLamacento){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente, probabilidadeEventos, climaDominante);
        this.aguaAbundante = aguaAbundante;
        this.possibilidadePesca = possibilidadePesca;
        this.terrenoLamacento = terrenoLamacento;
    }
    //Metodos acessores:
    public void setAguaAbundante(boolean aguaAbundante){
        this.aguaAbundante = aguaAbundante;
    }
    public boolean isAguaAbundante() {
        return aguaAbundante;
    }
    public void setPossibilidadePesca(boolean possibilidadePesca){
        this.possibilidadePesca = possibilidadePesca;
    }
    public boolean isPossibilidadePesca() {
        return possibilidadePesca;
    }
    public void setTerrenoLamacento(boolean terrenoLamacento){
        this.terrenoLamacento = terrenoLamacento;
    }
    public boolean isTerrenoLamacento() {
        return terrenoLamacento;
    }
}
