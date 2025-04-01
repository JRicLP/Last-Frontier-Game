package interfaces;

import ambientes.Ambientes;
import eventos.Eventos;

public interface ManagerEventsActions {
    //Nessa interface serão implementados os metodos usados na classe GerenciadorDeEventos:
    public abstract void sortearEvento(Ambientes ambienteAtual);
    public abstract void aplicarEvento(); //Esse metodo recebera como parâmetro um objeto Personagem
    public abstract void removerEvento(Eventos eventoAtual);
}
