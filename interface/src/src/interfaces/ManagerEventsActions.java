package interfaces;

import ambientes.Ambiente;
import eventos.Evento;
import personagens.Personagem;

public interface ManagerEventsActions {
    //Nessa interface serão implementados os metodos usados na classe GerenciadorDeEventos:
    public abstract void sortearEvento(Ambiente ambienteAtual);
    public abstract void aplicarEvento(Personagem personagemAtual, Evento eventoAplicado);
    public abstract void removerEvento(Evento eventoAtual);
}
