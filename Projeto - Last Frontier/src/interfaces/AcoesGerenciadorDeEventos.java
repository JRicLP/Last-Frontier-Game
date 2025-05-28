package interfaces;

import ambientes.Ambientes;
import eventos.Eventos;
import personagens.Personagem;

public interface AcoesGerenciadorDeEventos {
    //Nessa interface serão implementados os metodos usados na classe GerenciadorDeEventos:
    //Retirei o metodo sortearEvento(); pois o mesmo não estava se encaixando na lógica do jogo
    public abstract void aplicarEvento(Personagem personagemAtual, Eventos eventoAplicado);
    public abstract void removerEvento(Eventos eventoAtual);
}
