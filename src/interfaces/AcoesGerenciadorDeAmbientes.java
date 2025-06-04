package interfaces;

import ambientes.Ambiente;
import personagens.Personagem;

public interface AcoesGerenciadorDeAmbientes {
    //Nessa ‘Interface’ serão implementados os metodos que serão usados na classe GerenciadorDeAmbientes:
    public abstract void mudarAmbiente(Personagem personagemAtual, Ambiente novoAmbiente);
    public abstract void gerarAmbientes();
}
