package interfaces;

import ambientes.Ambiente;
import personagens.Personagem;

public interface AcoesEventos {
    public abstract void executar(Personagem personagemAtual, Ambiente ambienteAtual);
}