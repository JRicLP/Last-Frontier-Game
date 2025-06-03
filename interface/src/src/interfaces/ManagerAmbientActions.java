package interfaces;

import ambientes.Ambiente;
import eventos.Evento;
import personagens.Personagem;

public interface ManagerAmbientActions {
    //Nessa ‘Interface’ serão implementados os metodos que serão usados na classe GerenciadorDeAmbientes:
    public abstract void mudarAmbiente(Personagem personagemAtual, Ambiente novoAmbiente);
    public abstract void gerarEvento(Ambiente ambienteAtual, Evento eventoGerado);
    public abstract void modificarRecursos(Ambiente ambienteAtual);
    public abstract void gerarAmbientes();
}
