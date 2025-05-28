package interfaces;

import ambientes.Ambientes;
import eventos.EventoClimatico;
import personagens.Personagem;

public interface AcoesAmbientes {
    //Metodos implementados na superclasse abstrata Ambientes:
    public abstract void exlorar(Personagem personagemAtual);
    public abstract void gerarEvento(); //Esse metodo será evoluído em breve!
    public abstract void modificarClima(Ambientes ambienteAtual, EventoClimatico novoClima);
}
