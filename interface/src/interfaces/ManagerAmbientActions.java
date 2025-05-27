package interfaces;

import ambientes.Ambientes;
import eventos.Eventos;
import personagens.Personagem;

public interface ManagerAmbientActions {
    //Nessa ‘Interface’ serão implementados os metodos que serão usados na classe GerenciadorDeAmbientes:
    public abstract void mudarAmbiente(Personagem personagemAtual, Ambientes novoAmbiente);
    public abstract void gerarEvento(Ambientes ambienteAtual, Eventos eventoGerado);
    public abstract void modificarRecursos(Ambientes ambienteAtual);
    public abstract void gerarAmbientes();
}
