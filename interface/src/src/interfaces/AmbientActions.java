package interfaces;

import ambientes.Ambiente;
import eventos.EventoClimatico;
import personagens.Personagem;

public interface AmbientActions {
    //Metodos implementados na superclasse abstrata Ambientes:
    public abstract void exlorar(Personagem personagemAtual);
    public abstract void gerarEvento(); //Esse metodo será evoluído em breve!
    public abstract void modificarClima(Ambiente ambienteAtual, EventoClimatico novoClima);
}
