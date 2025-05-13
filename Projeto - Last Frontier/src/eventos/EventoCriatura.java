package eventos;

public class EventoCriatura extends Eventos{
    //Atributos da subclasse:
    private String tipoCriatura;
    private int vidaCriatura;//Novo atributo adicionado para utilizar o metodo atacar() em Armas
    private int distanciaCriatura;//Novo atributo adicionado para utilizar o metodo atacar() em Armas, deverá ser revisado
    private int nivelPerigo;
    private String opcaoAcao; //Revisar a necessidade desse atributo
    //Métodos da subclasse:
    public EventoCriatura(String nomeEvento, String descricaoEvento, int probabilidadeEvento, String impactoEvento, String condicaoEvento,
                          String tipoCriatura, int vidaCriatura, int distanciaCriatura, int nivelPerigo, String opcaoAcao) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoCriatura = tipoCriatura;
        this.vidaCriatura = vidaCriatura;
        this.distanciaCriatura = distanciaCriatura;
        this.nivelPerigo = nivelPerigo;
        this.opcaoAcao = opcaoAcao;
    }
    public void setTipoCriatura(String tipoCriatura){
        this.tipoCriatura = tipoCriatura;
    }
    public String getTipoCriatura(){
        return tipoCriatura;
    }
    public void setVidaCriatura(int vidaCriatura) {
        this.vidaCriatura = vidaCriatura;
    }
    public int getVidaCriatura() {
        return vidaCriatura;
    }
    public void setDistanciaCriatura(int distanciaCriatura) {
        this.distanciaCriatura = distanciaCriatura;
    }
    public int getDistanciaCriatura() {
        return distanciaCriatura;
    }
    public void setNivelPerigo(int nivelPerigo){
        this.nivelPerigo = nivelPerigo;
    }
    public int getNivelPerigo(){
        return nivelPerigo;
    }
    public void setOpcaoAcao(String opcaoAcao){
        this.opcaoAcao = opcaoAcao;
    }
    public String getOpcaoAcao(){
        return opcaoAcao;
    }
}
