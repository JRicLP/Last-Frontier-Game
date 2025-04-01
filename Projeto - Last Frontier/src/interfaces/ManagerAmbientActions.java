package interfaces;

import ambientes.Ambientes;

public interface ManagerAmbientActions {
    //Nessa interface serão implementados os metodos que serão usados na classe GerenciadorDeAmbientes:
    public abstract void mudarAmbiente(); //Esse metodo recebe como parâmetros um objeto Personagem e um Ambiente
    public abstract void gerarEvento(Ambientes ambienteAtual);
    public abstract void modificarRecursos(Ambientes ambienteAtual);
}
