package ambientes;

public class AmbienteMontanha extends Ambientes {
    //Atributos da subclasse:
    private String terrenoAcidentado;
    private String climaInstavel;
    private String baixaVegetacao;
    public AmbienteMontanha(String nomeAmbiente, String descricaoAmbiente, double dificuldadeAmbiente,
                            String recursosAmbiente, double probabilidadeEventos, String climaDominante,
                            String terrenoAcidentado, String climaInstavel, String baixaVegetacao){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente,
                probabilidadeEventos, climaDominante);
        this.terrenoAcidentado = terrenoAcidentado;
        this.climaInstavel = climaInstavel;
        this.baixaVegetacao = baixaVegetacao;
    }

}
