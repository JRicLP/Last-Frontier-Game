package ambientes;

public class AmbienteLagoRio extends Ambientes{ //Falta a adição dos recursos disponíveis e ligação com os eventos
    //Atributos da subclasse:
    private String aguaAbundante;
    private String possibilidadePesca;
    private String terrenoLamacento;
    //Metodo construtor:
    public AmbienteLagoRio(String nomeAmbiente, String descricaoAmbiente, double dificuldadeAmbiente, String recursosAmbiente, double probabilidadeEventos, String climaDominante,
                           String aguaAbundante, String possibilidadePesca, String terrenoLamacento){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente, probabilidadeEventos, climaDominante);
        this.aguaAbundante = aguaAbundante;
        this.possibilidadePesca = possibilidadePesca;
        this.terrenoLamacento = terrenoLamacento;
    }
    //Metodos acessores:
    public void setAguaAbundante(String aguaAbundante){
        this.aguaAbundante = aguaAbundante;
    }
    public String getAguaAbundante(){
        return aguaAbundante;
    }
    public void setPossibilidadePesca(String possibilidadePesca){
        this.possibilidadePesca = possibilidadePesca;
    }
    public String getPossibilidadePesca(){
        return possibilidadePesca;
    }
    public void setTerrenoLamacento(String terrenoLamacento){
        this.terrenoLamacento = terrenoLamacento;
    }
    public String getTerrenoLamacento(){
        return terrenoLamacento;
    }
}
