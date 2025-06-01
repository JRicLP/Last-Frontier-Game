package interfaces;

import itens.Material;

public interface AcoesMateriais {
    //Nessa interface está a assinatura do metodo utilizado na subclasse Materiais:
    public abstract void combinarMateriais(Material material1, Material material2);
}
