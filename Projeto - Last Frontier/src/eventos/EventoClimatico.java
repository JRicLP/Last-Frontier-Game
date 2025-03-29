package eventos;

public class EventoClimatico extends Eventos {
    //Atributos da subclasse:
    private String tipoClima;
    private double duracaoClima;
    private String efeitoClima;

    //Métodos da subclasse:
    public EventoClimatico(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                           String impactoEvento, String condicaoEvento, String tipoClima, double duracaoClima,
                           String efeitoClima) {
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
    public void setDuracaoClima(double duracaoClima){
        this.duracaoClima = duracaoClima;
    }
    public double getDuracaoClima(){
        return duracaoClima;
    }
    public void setEfeitoClima(String efeitoClima){
        this.efeitoClima = efeitoClima;
    }
    public String getEfeitoClima(){
        return efeitoClima;
    }
}
