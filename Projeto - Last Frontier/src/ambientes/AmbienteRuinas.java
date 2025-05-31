package ambientes;

public class AmbienteRuinas extends Ambiente { //Falta a adição dos recursos disponíveis e ligação com os eventos

    //Atributos da subclasse:
    private boolean estruturasInstaveis; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean presencaSobreviventes; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean baixoRiscoClimatico; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento

    //Metodo construtor:
    public AmbienteRuinas(String nomeAmbiente, String descricaoAmbiente, int dificuldadeAmbiente, String recursosAmbiente, int probabilidadeEventos, String climaDominante,
                          boolean estruturasInstaveis, boolean presencaSobreviventes, boolean baixoRiscoClimatico){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente, probabilidadeEventos, climaDominante);
        this.estruturasInstaveis = estruturasInstaveis;
        this.presencaSobreviventes = presencaSobreviventes;
        this.baixoRiscoClimatico = baixoRiscoClimatico;
    }

    //Metodos acessores:
    public void setEstruturasInstaveis(boolean estruturasInstaveis){
        this.estruturasInstaveis = estruturasInstaveis;
    }
    public boolean isEstruturasInstaveis() {
        return estruturasInstaveis;
    }
    public void setPresencaSobreviventes(boolean presencaSobreviventes){
        this.presencaSobreviventes = presencaSobreviventes;
    }
    public boolean isPresencaSobreviventes() {
        return presencaSobreviventes;
    }
    public void setBaixoRiscoClimatico(boolean baixoRiscoClimatico){
        this.baixoRiscoClimatico = baixoRiscoClimatico;
    }

    public boolean isBaixoRiscoClimatico() {
        return baixoRiscoClimatico;
    }
}
