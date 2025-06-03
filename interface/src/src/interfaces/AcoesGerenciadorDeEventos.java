package interfaces;

import ambientes.Ambiente;
import eventos.Evento;
import personagens.Personagem;

public interface AcoesGerenciadorDeEventos {
    //Nessa interface serão implementados os metodos usados na classe GerenciadorDeEventos:
    public abstract Evento sortearEvento(Ambiente ambienteAtual, Personagem personagem);
    public abstract void aplicarEvento(Personagem personagemAtual, Evento eventoAplicado);
    public abstract void removerEvento(Evento eventoAtual);
}
