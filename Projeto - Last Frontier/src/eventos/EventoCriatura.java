package eventos;

public class EventoCriatura extends Eventos{
    //Atributos da subclasse:
    private String tipoCriatura;
    private double nivelPerigo;
    private String opcaoAcao;
    //Métodos da subclasse:
    public EventoCriatura(String nomeEvento, String descricaoEvento, double probabilidadeEvento,
                          String impactoEvento, String condicaoEvento, String tipoCriatura, double nivelPerigo,
                          String opcaoAcao) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoCriatura = tipoCriatura;
        this.nivelPerigo = nivelPerigo;
        this.opcaoAcao = opcaoAcao;
    }
    public void setTipoCriatura(){
        this.tipoCriatura = tipoCriatura;
    }
    public String getTipoCriatura(){
        return tipoCriatura;
    }
    public void setNivelPerigo(double nivelPerigo){
        this.nivelPerigo = nivelPerigo;
    }
    public double getNivelPerigo(){
        return nivelPerigo;
    }
    public void setOpcaoAcao(){
        this.opcaoAcao = opcaoAcao;
    }
    public String getOpcaoAcao(){
        return opcaoAcao;
    }
}
