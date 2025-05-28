package eventos;

public class EventoClimatico extends Eventos {

    //Atributos da subclasse:
    private String tipoClima; //É necessário revisar a utilidade desse atributo
    private int duracaoClima; //Baseado no número de turnos
    private String efeitoClima; //É necessário revisar como esse atributo irá funcionar

    //Métodos da subclasse:
    public EventoClimatico(String nomeEvento, String descricaoEvento, int probabilidadeEvento, String impactoEvento, boolean condicaoEvento,
                           String tipoClima, int duracaoClima, String efeitoClima) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoClima = tipoClima;
        this.duracaoClima = duracaoClima;
        this.efeitoClima = efeitoClima;
    }
    public void setTipoClima(String tipoClima) {
        this.tipoClima = tipoClima;
    }
    public String getTipoClima() {
        return tipoClima;
    }
    public void setDuracaoClima(int duracaoClima){
        this.duracaoClima = duracaoClima;
    }
    public int getDuracaoClima(){
        return duracaoClima;
    }
    public void setEfeitoClima(String efeitoClima){
        this.efeitoClima = efeitoClima;
    }
    public String getEfeitoClima(){
        return efeitoClima;
    }
}
