package ambientes;

public class AmbienteCaverna extends Ambiente { //Falta a adição dos recursos disponíveis e ligação com os eventos

    //Atributos da subclasse:
    private boolean poucaLuz; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean criaturasEstranhas; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento
    private boolean aguaGotejamento; //Como esse atributo é uma condição, iremos torná-lo boolean para verificar e atribuir um evento

    //Metodo construtor:
    public AmbienteCaverna(String nomeAmbiente, String descricaoAmbiente, int dificuldadeAmbiente, String recursosAmbiente, int probabilidadeEventos, String climaDominante,
                           boolean poucaLuz, boolean criaturasEstranhas, boolean aguaGotejamento){
        super(nomeAmbiente, descricaoAmbiente, dificuldadeAmbiente, recursosAmbiente, probabilidadeEventos, climaDominante);
        this.poucaLuz = poucaLuz;
        this.criaturasEstranhas = criaturasEstranhas;
        this.aguaGotejamento = aguaGotejamento;
    }

    //Metodos acessores:
    public void setPoucaLuz(boolean poucaLuz){
        this.poucaLuz = poucaLuz;
    }
    public boolean isPoucaLuz() {
        return poucaLuz;
    }
    public void setCriaturasEstranhas(boolean criaturasEstranhas){
        this.criaturasEstranhas = criaturasEstranhas;
    }
    public boolean isCriaturasEstranhas() {
        return criaturasEstranhas;
    }
    public void setAguaGotejamento(boolean aguaGotejamento){
        this.aguaGotejamento = aguaGotejamento;
    }
    public boolean isAguaGotejamento() {
        return aguaGotejamento;
    }
}
