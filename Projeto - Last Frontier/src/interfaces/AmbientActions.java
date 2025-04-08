package interfaces;

import personagens.Personagem;

public interface AmbientActions {
    //Metodos implementados na superclasse abstrata Ambientes:
    public abstract void exlorar(Personagem personagemAtual);
    public abstract void gerarEvento();
    public abstract void modificarClima();
}
