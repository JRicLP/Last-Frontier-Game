package ambientes;

public class AmbienteCaverna extends Ambientes {
    //Atributos da subclasse:
    private String poucaLuz;
    private String criaturasEstranhas;
    private String aguaGotejamento;
    //Métodos da classe:
    public AmbienteCaverna(String nomeAmbiente, String descricaoAmbiente, double dificuldadeAmbiente,
                           String recursosAmbiente, double probabilidadeEventos, String climaDominante,
                           String poucaLuz, String criaturasEstranhas, String aguaGotejamento){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente,
                probabilidadeEventos, climaDominante);
        this.poucaLuz = poucaLuz;
        this.criaturasEstranhas = criaturasEstranhas;
        this.aguaGotejamento = aguaGotejamento;
    }
}
