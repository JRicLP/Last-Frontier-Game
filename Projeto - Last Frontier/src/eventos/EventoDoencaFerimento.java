package eventos;

public class EventoDoencaFerimento extends Eventos{
    //Atributos da subclasse:
    private String tipoCondicao;
    private String impactoDoencaFerimento;
    private boolean curaDisponivel;
    //Métodos da subclasse:
    public EventoDoencaFerimento(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                                 String impactoEvento, String condicaoEvento, String tipoCondicao,
                                 String impactoDoencaFerimento, boolean curaDisponivel) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoCondicao = tipoCondicao;
        this.impactoDoencaFerimento = impactoDoencaFerimento;
        this.curaDisponivel = curaDisponivel;
    }
    public void setTipoCondicao(String tipoCondicao){
        this.tipoCondicao = tipoCondicao;
    }
    public String getTipoCondicao(){
        return tipoCondicao;
    }
    public void setImpactoDoencaFerimento(String impactoDoencaFerimento){
        this.impactoDoencaFerimento = impactoDoencaFerimento;
    }
    public String getImpactoDoencaFerimento(){
        return impactoDoencaFerimento;
    }
    public void setCuraDisponivel(boolean curaDisponivel){
        this.curaDisponivel = curaDisponivel;
    }
    public boolean isCuraDisponivel(){
        return curaDisponivel;
    }
}
