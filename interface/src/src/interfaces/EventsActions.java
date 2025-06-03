package interfaces;

import ambientes.Ambiente;
import eventos.Evento;
import personagens.Personagem;

public interface EventsActions {
    //Metodos que serão implementados na superclasse Eventos:
    public abstract void executar(Personagem personagemAtual, Ambiente ambienteAtual, Evento eventoAplicado);
}
