package eventos;

public class EventoDescoberta extends Eventos{
    //Atributos da subclasse:
    private String tipoDescoberta;
    private String recursoEncontrado;
    private boolean condicaoEspecial;
    //Métodos da subclasse:
    public EventoDescoberta(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                            String impactoEvento, String condicaoEvento, String tipoDescoberta,
                            String recursoEncontrado, boolean condicaoEspecial){
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoDescoberta = tipoDescoberta;
        this.recursoEncontrado = recursoEncontrado;
        this.condicaoEspecial = condicaoEspecial;
    }
}
