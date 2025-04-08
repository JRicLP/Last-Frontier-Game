package eventos;

public class EventoDoencaFerimento extends Eventos{
    //Atributos da subclasse:
    private String tipoDoenca;
    private String impactoDoencaFerimento;
    private boolean curaDisponivel;
    //Metodo construtor:
    public EventoDoencaFerimento(String nomeEvento, String descricaoEvento, double probabilidadeEvento, String impactoEvento, String condicaoEvento,
                                 String tipoDoenca, String impactoDoencaFerimento, boolean curaDisponivel) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoDoenca = tipoDoenca;
        this.impactoDoencaFerimento = impactoDoencaFerimento;
        this.curaDisponivel = curaDisponivel;
    }
    //Metodos acessores:
    public void setTipoDoenca(String tipoDoenca){
        this.tipoDoenca = tipoDoenca;
    }
    public String getTipoDoenca(){
        return tipoDoenca;
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
