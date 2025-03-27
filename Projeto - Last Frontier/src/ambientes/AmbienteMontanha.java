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
    public void setTerrenoAcidentado(){
        this.terrenoAcidentado = terrenoAcidentado;
    }
    public String getTerrenoAcidentado(){
        return terrenoAcidentado;
    }
    public void setClimaInstavel(){
        this.climaInstavel = climaInstavel;
    }
    public String getClimaInstavel(){
        return climaInstavel;
    }
    public void setBaixaVegetacao(){
        this.baixaVegetacao = baixaVegetacao;
    }
    public String getBaixaVegetacao(){
        return baixaVegetacao;
    }
}
