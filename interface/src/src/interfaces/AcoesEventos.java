package interfaces;

import ambientes.Ambientes;
import eventos.Eventos;
import personagens.Personagem;

public interface AcoesEventos {
    //Metodos que serão implementados na superclasse Eventos:
    public abstract void executar(Personagem personagemAtual, Ambientes ambienteAtual, Eventos eventoAplicado);
}
