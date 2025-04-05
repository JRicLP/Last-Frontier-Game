package ambientes;

public class AmbienteRuinas extends Ambientes{ //Falta a adição dos recursos disponíveis e ligação com os eventos
    //Atributos da subclasse:
    private String estruturasInstaveis;
    private String presencaSobreviventes;
    private String baixoRiscoClimatico;
    //Metodo construtor:
    public AmbienteRuinas(String nomeAmbiente, String descricaoAmbiente, float dificuldadeAmbiente,
                          String recursosAmbiente, float probabilidadeEventos, String climaDominante,
                          String estruturasInstaveis, String presencaSobreviventes, String baixoRiscoClimatico){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente,
                probabilidadeEventos, climaDominante);
        this.estruturasInstaveis = estruturasInstaveis;
        this.presencaSobreviventes = presencaSobreviventes;
        this.baixoRiscoClimatico = baixoRiscoClimatico;
    }
    //Metodos acessores:
    public void setEstruturasInstaveis(String estruturasInstaveis){
        this.estruturasInstaveis = estruturasInstaveis;
    }
    public String getEstruturasInstaveis(){
        return estruturasInstaveis;
    }
    public void setPresencaSobreviventes(String presencaSobreviventes){
        this.presencaSobreviventes = presencaSobreviventes;
    }
    public String getPresencaSobreviventes(){
        return presencaSobreviventes;
    }
    public void setBaixoRiscoClimatico(String baixoRiscoClimatico){
        this.baixoRiscoClimatico = baixoRiscoClimatico;
    }
    public String getBaixoRiscoClimatico(){
        return baixoRiscoClimatico;
    }
}
