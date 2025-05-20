package interfaces;

import eventos.EventoCriatura;

public interface AcoesArmas {
    //Nessa ‘Interface’ está a assinatura do metodo usado na subclasse Armas:
    public abstract void atacar(EventoCriatura criaturaAtacada);
}
