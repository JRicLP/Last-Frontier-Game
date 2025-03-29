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
    public void setTipoDescoberta(String tipoDescoberta){
        this.tipoDescoberta = tipoDescoberta;
    }
    public String getTipoDescoberta(){
        return tipoDescoberta;
    }
    public void setRecursoEncontrado(String recursoEncontrado){
        this.recursoEncontrado = recursoEncontrado;
    }
    public String getRecursoEncontrado(){
        return recursoEncontrado;
    }
    public void setCondicaoEspecial(boolean condicaoEspecial){
        this.condicaoEspecial = condicaoEspecial;
    }
    public boolean isCondicaoEspecial(){
        return condicaoEspecial;
    }
}
