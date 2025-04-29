package gerenciadores;

import ambientes.Ambientes;
import eventos.Eventos;
import interfaces.ManagerAmbientActions;
import personagens.Personagem;

import java.util.ArrayList;

public class GerenciadorDeAmbientes implements ManagerAmbientActions {
    //Atributos da classe:
    private String[] listaAmbientesDisponiveis;
    private String climaGlobal;
    private ArrayList<Ambientes> historicoMovimentacao; //Esse atributo será um Arraylist, posteriormente será modificado
    //Metodo construtor da classe:
    public GerenciadorDeAmbientes(String[] listaAmbientesDisponiveis, String climaGlobal, ArrayList<Ambientes> historicoMovimentacao) {
        this.listaAmbientesDisponiveis = listaAmbientesDisponiveis;
        this.climaGlobal = climaGlobal;
        this.historicoMovimentacao = new ArrayList<>(listaAmbientesDisponiveis.length);
    }
    //Metodos acessores:
    public void setListaAmbientesDisponiveis(String[] listaAmbientesDisponiveis) {
        this.listaAmbientesDisponiveis = listaAmbientesDisponiveis;
    }
    public String[] getListaAmbientesDisponiveis() {
        return listaAmbientesDisponiveis;
    }
    public void setClimaGlobal(String climaGlobal) {
        this.climaGlobal = climaGlobal;
    }
    public String getClimaGlobal() {
        return climaGlobal;
    }
    public void setHistoricoMovimentacao(ArrayList<Ambientes> historicoMovimentacao) {
        this.historicoMovimentacao = historicoMovimentacao;
    }
    public ArrayList<Ambientes> getHistoricoMovimentacao() {
        return historicoMovimentacao;
    }
    //Metodos implementados:
    @Override
    public void mudarAmbiente(Personagem personagemAtual, Ambientes novoAmbiente) {
        System.out.println("Após uma longa jornada com obstáculos e desafios pelo caminho, " + personagemAtual.getNomePersonagem()
        + " chegou ao seu destino: " + novoAmbiente.getNomeAmbiente() +"!");
        personagemAtual.setLocalizacaoPersonagem(novoAmbiente.getNomeAmbiente());
        getHistoricoMovimentacao().add(novoAmbiente);
        //Temos que ver uma forma de registrar também o antigo ambiente!!
    }
    @Override
    public void gerarEvento(Ambientes ambienteAtual, Eventos eventoGerado) {
        //Esse metodo irá evoluir conforme a dinâmica de eventos for aprimorada!!
        System.out.println("No ambiente " + ambienteAtual.getNomeAmbiente() + " foi aplicado: " + eventoGerado.getNomeEvento());
    }
    @Override
    public void modificarRecursos(Ambientes ambienteAtual) {
        //Esse metodo será aprimorado a partir do desenvolvimento dos recursos e suas relações com o ambiente
    }
}
