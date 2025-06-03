package interfaces;

import ambientes.Ambiente;
import eventos.EventoCriatura;
import personagens.Personagem;

import java.util.Scanner;

public interface AcoesArmas {
    //Nessa ‘Interface’ está a assinatura do metodo usado na subclasse Armas:
    public abstract void atacar(Personagem personagemEscolhido, EventoCriatura criaturaAtacada, Scanner entradausuario, Ambiente ambienteAtual);
}
