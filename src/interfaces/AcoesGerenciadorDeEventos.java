package interfaces;

import eventos.Evento;
import personagens.Personagem;

public interface AcoesGerenciadorDeEventos {
    public abstract void aplicarEvento(Personagem personagemAtual, Evento eventoAplicado);
    public abstract void removerEvento(Evento eventoAtual);
}
