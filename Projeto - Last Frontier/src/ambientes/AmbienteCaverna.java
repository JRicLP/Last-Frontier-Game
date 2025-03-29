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
    public void setPoucaLuz(String poucaLuz){
        this.poucaLuz = poucaLuz;
    }
    public String getPoucaLuz(){
        return poucaLuz;
    }
    public void setCriaturasEstranhas(String criaturasEstranhas){
        this.criaturasEstranhas = criaturasEstranhas;
    }
    public String getCriaturasEstranhas(){
        return criaturasEstranhas;
    }
    public void setAguaGotejamento(String aguaGotejamento){
        this.aguaGotejamento = aguaGotejamento;
    }
    public String getAguaGotejamento(){
        return aguaGotejamento;
    }
}
