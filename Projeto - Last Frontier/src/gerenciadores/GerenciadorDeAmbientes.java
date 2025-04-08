package gerenciadores;

import ambientes.Ambientes;
import interfaces.ManagerAmbientActions;
import personagens.Personagem;

public class GerenciadorDeAmbientes implements ManagerAmbientActions {
    //Atributos da classe:
    private String[] listaAmbientesDisponiveis;
    private String climaGlobal;
    private String[] historicoMovimentacao; //Esse atributo será um Arraylist, posteriormente será modificado
    //Metodo construtor da classe:
    public GerenciadorDeAmbientes(String[] listaAmbientesDisponiveis, String climaGlobal, String[] historicoMovimentacao) {
        this.listaAmbientesDisponiveis = listaAmbientesDisponiveis;
        this.climaGlobal = climaGlobal;
        this.historicoMovimentacao = historicoMovimentacao;
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
    public void setHistoricoMovimentacao(String[] historicoMovimentacao) {
        this.historicoMovimentacao = historicoMovimentacao;
    }
    public String[] getHistoricoMovimentacao() {
        return historicoMovimentacao;
    }
    //Metodos implementados:
    @Override
    public void mudarAmbiente(Personagem personagemAtual, Ambientes novoAmbiente) {
        System.out.println("Após uma longa jornada com obstáculos e desafios pelo caminho, " + personagemAtual.getNomePersonagem()
        + " chegou ao seu destino: " + novoAmbiente.getNomeAmbiente() +"!");
        personagemAtual.setLocalizacaoPersonagem(novoAmbiente.getNomeAmbiente());
    }
    @Override
    public void gerarEvento(Ambientes ambienteAtual) {

    }
    @Override
    public void modificarRecursos(Ambientes ambienteAtual) {

    }
}
