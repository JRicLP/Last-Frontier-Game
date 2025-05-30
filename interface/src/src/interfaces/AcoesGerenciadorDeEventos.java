package interfaces;

import ambientes.Ambientes;
import eventos.Eventos;
import personagens.Personagem;

public interface AcoesGerenciadorDeEventos {
    //Nessa interface serão implementados os metodos usados na classe GerenciadorDeEventos:
    public abstract void sortearEvento(Ambientes ambienteAtual);
    public abstract void aplicarEvento(Personagem personagemAtual, Eventos eventoAplicado);
    public abstract void removerEvento(Eventos eventoAtual);
}
