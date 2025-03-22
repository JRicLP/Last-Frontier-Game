package ambientes;

public class AmbienteLagoRio extends Ambientes{
    //Atributos da subclasse:
    private String aguaAbundante;
    private String possibilidadePesca;
    private String terrenoLamacento;
    //Métodos da subclasse:
    public AmbienteLagoRio(String nomeAmbiente, String descricaoAmbiente, double dificuldadeAmbiente,
                           String recursosAmbiente, double probabilidadeEventos, String climaDominante, String aguaAbundante,
                           String possibilidadePesca, String terrenoLamacento){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente,
                probabilidadeEventos, climaDominante);
        this.aguaAbundante = aguaAbundante;
        this.possibilidadePesca = possibilidadePesca;
        this.terrenoLamacento = terrenoLamacento;
    }
}
