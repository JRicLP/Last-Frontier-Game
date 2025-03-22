package ambientes;

public class AmbienteRuinas extends Ambientes{
    //Atributos da subclasse:
    private String estruturasInstaveis;
    private String presencaSobreviventes;
    private String baixoRiscoClimatico;
    //Métodos da subclasse:
    public AmbienteRuinas(String nomeAmbiente, String descricaoAmbiente, float dificuldadeAmbiente,
                          String recursosAmbiente, float probabilidadeEventos, String climaDominante,
                          String estruturasInstaveis, String presencaSobreviventes, String baixoRiscoClimatico){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente,
                probabilidadeEventos, climaDominante);
        this.estruturasInstaveis = estruturasInstaveis;
        this.presencaSobreviventes = presencaSobreviventes;
        this.baixoRiscoClimatico = baixoRiscoClimatico;
    }
}
