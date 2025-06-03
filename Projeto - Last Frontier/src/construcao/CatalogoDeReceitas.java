package construcao;

import itens.Ferramenta;
import itens.Remedio;

import java.util.ArrayList;

public class CatalogoDeReceitas {

    private ArrayList<Receita> listaDeTodasReceitas;

    public CatalogoDeReceitas() {
        this.listaDeTodasReceitas = new ArrayList<>();
        carregarReceitas();
    }

    private void carregarReceitas() {
        //Template AbrigoSeguro:
        Ferramenta templateAbrigoSeguro = new Ferramenta("Abrigo Seguro", 15, 10, "Estrutura de Proteção Definitiva", 0);
        //Template Panaceia Runica:
        Remedio templatePanaceiaRunica = new Remedio("Panaceia Rúnica", 1, 1, "Panaceia", "Uma poção mística que restaura grandemente a vitalidade e purifica o corpo.", 50);

        // 1. Receita para o Abrigo Seguro:
        Receita receitaAbrigo = new Receita("Abrigo Seguro",templateAbrigoSeguro,"Dundrhamarr - Martelo",true);
        //Ingredientes:
        receitaAbrigo.adicionarIngrediente("Asktreplate - Madeira", 2);
        receitaAbrigo.adicionarIngrediente("Járnstykket - Ferro", 2);
        this.listaDeTodasReceitas.add(receitaAbrigo);

        // 2. Receita para a Panaceia Runica:
        Receita receitaPanaceia = new Receita("Panaceia Rúnica",templatePanaceiaRunica,null,false);
        //Ingredientes:
        receitaPanaceia.adicionarIngrediente("Myrsillblóð", 1);
        receitaPanaceia.adicionarIngrediente("Draumrlyng", 1);
        receitaPanaceia.adicionarIngrediente("Eitrskjarr", 1);
        this.listaDeTodasReceitas.add(receitaPanaceia);
    }

    public ArrayList<Receita> getTodasAsReceitas() {
        return this.listaDeTodasReceitas;
    }
}