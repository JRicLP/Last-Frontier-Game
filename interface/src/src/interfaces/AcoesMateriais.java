package interfaces;

import itens.Materiais;

public interface AcoesMateriais {
    //Nessa interface está a assinatura do metodo utilizado na subclasse Materiais:
    public abstract void combinarMateriais(Materiais material1, Materiais material2);
}
