package eventos;

import ambientes.Ambiente;
import personagens.Personagem;

public class EventoCriatura extends Evento {

    //Atributos da subclasse:
    private String tipoCriatura;
    private int vidaCriatura;
    private int distanciaCriatura;
    private int nivelPerigo;
    private int danoCriatura;
    private EventoDoencaFerimento efeitoColateralAtaque; //Pode ser null se a criatura não causa doença/ferimento

    //Metodo Construtor:
    public EventoCriatura(String nomeEvento, String descricaoEvento, int probabilidadeEvento, String impactoEvento, boolean condicaoEvento, String tipoCriatura, int vidaCriatura, int distanciaCriatura,
                          int nivelPerigo, int danoCriatura, EventoDoencaFerimento efeitoColateralAtaque) {
        super(nomeEvento, descricaoEvento, probabilidadeEvento, impactoEvento, condicaoEvento);
        this.tipoCriatura = tipoCriatura;
        this.vidaCriatura = vidaCriatura;
        this.distanciaCriatura = distanciaCriatura;
        this.nivelPerigo = nivelPerigo;
        this.danoCriatura = danoCriatura;
        this.efeitoColateralAtaque = efeitoColateralAtaque;
    }

    //Metodos acessores (existentes):
    public String getTipoCriatura() { return tipoCriatura; }
    public void setTipoCriatura(String tipoCriatura) { this.tipoCriatura = tipoCriatura; }

    public int getVidaCriatura() { return vidaCriatura; }
    public void setVidaCriatura(int vidaCriatura) { this.vidaCriatura = vidaCriatura; }

    public int getDistanciaCriatura() { return distanciaCriatura; }
    public void setDistanciaCriatura(int distanciaCriatura) { this.distanciaCriatura = distanciaCriatura; }

    public int getNivelPerigo() { return nivelPerigo; }
    public void setNivelPerigo(int nivelPerigo) { this.nivelPerigo = nivelPerigo; }

    public int getDanoCriatura() { return danoCriatura; }
    public void setDanoCriatura(int danoCriatura) { this.danoCriatura = danoCriatura; }

    public EventoDoencaFerimento getEfeitoColateralAtaque() {
        return efeitoColateralAtaque;
    }

    public void setEfeitoColateralAtaque(EventoDoencaFerimento efeitoColateralAtaque) {
        this.efeitoColateralAtaque = efeitoColateralAtaque;
    }

    @Override
    public void executar(Personagem personagemAfetado, Ambiente ambienteAtual) {
        super.executar(personagemAfetado, ambienteAtual);
        System.out.println("A criatura " + getNomeEvento() + " está presente e parece " + getTipoCriatura().toLowerCase() + "!");
    }

}