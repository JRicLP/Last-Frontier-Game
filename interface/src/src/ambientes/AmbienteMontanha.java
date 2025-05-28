package ambientes;

public class AmbienteMontanha extends Ambientes { //Falta a adição dos recursos disponíveis e ligação com os eventos

    //Atributos da subclasse:
    private boolean terrenoAcidentado; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean climaInstavel; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean baixaVegetacao; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento

    //Metodo construtor:
    public AmbienteMontanha(String nomeAmbiente, String descricaoAmbiente, int dificuldadeAmbiente, String recursosAmbiente, int probabilidadeEventos, String climaDominante,
                            boolean terrenoAcidentado, boolean climaInstavel, boolean baixaVegetacao){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente, probabilidadeEventos, climaDominante);
        this.terrenoAcidentado = terrenoAcidentado;
        this.climaInstavel = climaInstavel;
        this.baixaVegetacao = baixaVegetacao;
    }

    //Metodos acessores:
    public void setTerrenoAcidentado(boolean terrenoAcidentado){
        this.terrenoAcidentado = terrenoAcidentado;
    }

    public boolean isTerrenoAcidentado() {
        return terrenoAcidentado;
    }
    public void setClimaInstavel(boolean climaInstavel){
        this.climaInstavel = climaInstavel;
    }
    public boolean isClimaInstavel() {
        return climaInstavel;
    }
    public void setBaixaVegetacao(boolean baixaVegetacao){
        this.baixaVegetacao = baixaVegetacao;
    }
    public boolean isBaixaVegetacao() {
        return baixaVegetacao;
    }
}
