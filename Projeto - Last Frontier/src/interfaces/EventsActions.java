package interfaces;

import ambientes.Ambientes;
import personagens.Personagem;

public interface EventsActions {
    //Metodos que serão implementados na superclasse Eventos:
    public abstract void executar(Personagem personagemAtual, Ambientes ambienteAtual);
}
