package eventos;

public class EventoClimatico extends Eventos{
    //Atributos da subclasse:
    private String tipoClima;
    private int duracaoClima;
    private String efeitoClima;
    //Métodos da subclasse:
    public EventoClimatico(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                           String impactoEvento, String condicaoEvento, String tipoClima, int duracaoClima,
                           String efeitoClima) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoClima = tipoClima;
        this.duracaoClima = duracaoClima;
        this.efeitoClima = efeitoClima;
    }
}
