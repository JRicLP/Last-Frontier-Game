package gerenciadores;

import ambientes.Ambientes;
import eventos.Eventos;
import interfaces.ManagerEventsActions;
import personagens.Personagem;

public class GerenciadorDeEventos implements ManagerEventsActions {
    //Atributos da classe:
    private String[] listaEventosPossiveis;
    private float[] probabilidadeOcorrencia;
    private String[] historicoEventos;
    //Metodo construtor:
    public GerenciadorDeEventos(String[] listaEventosPossiveis, float[] probabilidadeOcorrencia, String[] historicoEventos) {
        this.listaEventosPossiveis = listaEventosPossiveis;
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
        this.historicoEventos = historicoEventos;
    }
    //Metodos acessores:
    public void setListaEventosPossiveis(String[] listaEventosPossiveis) {
        this.listaEventosPossiveis = listaEventosPossiveis;
    }
    public String[] getListaEventosPossiveis() {
        return listaEventosPossiveis;
    }
    public void setProbabilidadeOcorrencia(float[] probabilidadeOcorrencia) {
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
    }
    public float[] getProbabilidadeOcorrencia() {
        return probabilidadeOcorrencia;
    }
    public void setHistoricoEventos(String[] historicoEventos) {
        this.historicoEventos = historicoEventos;
    }
    public String[] getHistoricoEventos() {
        return historicoEventos;
    }
    //Metodos implementados:
    @Override
    public void sortearEvento(Ambientes ambienteAtual) {

    }
    @Override
    public void aplicarEvento(Personagem personagemAtual) {

    }
    @Override
    public void removerEvento(Eventos eventoAtual) {

    }
}
