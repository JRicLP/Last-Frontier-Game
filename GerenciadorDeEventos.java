package gerenciadores;

import ambientes.Ambientes;
import eventos.Eventos;
import interfaces.ManagerEventsActions;
import personagens.Personagem;

import java.util.ArrayList;

public class GerenciadorDeEventos implements ManagerEventsActions {
    //Atributos da classe:
    private String[] listaEventosPossiveis;
    private float[] probabilidadeOcorrencia;
    private ArrayList<Eventos> historicoEventos;
    //Metodo construtor:
    public GerenciadorDeEventos(String[] listaEventosPossiveis, float[] probabilidadeOcorrencia, ArrayList<Eventos> historicoEventos) {
        this.listaEventosPossiveis = listaEventosPossiveis;
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
        this.historicoEventos = new ArrayList<>(20);
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
    public void setHistoricoEventos(ArrayList<Eventos> historicoEventos) {
        this.historicoEventos = historicoEventos;
    }
    public ArrayList<Eventos> getHistoricoEventos() {
        return historicoEventos;
    }
    //Metodos implementados:
    @Override
    public void sortearEvento(Ambientes ambienteAtual) {
        //Esse metodo será implementado conforme a dinâmica de eventos for aprimorada!
    }
    @Override
    public void aplicarEvento(Personagem personagemAtual, Eventos eventoAplicado) {
        System.out.println("O personagem " + personagemAtual.getNomePersonagem() + " está sofrendo as consequências de: " +
                eventoAplicado.getNomeEvento());
    }
    @Override
    public void removerEvento(Eventos eventoAtual) {
        System.out.println("O evento " + eventoAtual.getNomeEvento() + "foi removido com sucesso!!");
    }
}
