package eventos;

public class EventoCriatura extends Eventos{

    //Atributos da subclasse:
    private String tipoCriatura; //Atributo mantido, pois identifica a criatura
    private int vidaCriatura;//Novo atributo adicionado para utilizar o metodo atacar() em Armas
    private int distanciaCriatura;//Novo atributo adicionado para utilizar o metodo atacar() em Armas, deverá ser revisto
    private int nivelPerigo; //Atributo mantido, se relaciona com o dano da Criatura
    private int danoCriatura; //Esse atributo substitui opcaoAcao e será utilizado na dinâmica de combates do metodo atacar() em Armas

    //Métodos da subclasse:
    public EventoCriatura(String nomeEvento, String descricaoEvento, int probabilidadeEvento, String impactoEvento, boolean condicaoEvento,
                          String tipoCriatura, int vidaCriatura, int distanciaCriatura, int nivelPerigo, int danoCriatura) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoCriatura = tipoCriatura;
        this.vidaCriatura = vidaCriatura;
        this.distanciaCriatura = distanciaCriatura;
        this.nivelPerigo = nivelPerigo;
        this.danoCriatura = danoCriatura;
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
    public void setDanoCriatura(int danoCriatura){
        this.danoCriatura = danoCriatura;
    }
    public int getDanoCriatura(){
        return danoCriatura;
    }
}
