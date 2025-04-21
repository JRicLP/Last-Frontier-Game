package interfaces;

import eventos.EventoCriatura;

public interface WeaponsActions {
    //Nessa interface está a assinatura do metodo usado na subclasse Armas:
    public abstract void atacar(EventoCriatura criaturaAtacada);
}
