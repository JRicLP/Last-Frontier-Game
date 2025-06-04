package construcao;

import itens.Item;
import java.util.Map;
import java.util.HashMap;

public class Receita {
    //Atributos da Classe:
    private String nomeItemResultado;
    private Item itemResultadoTemplate;
    private Map<String, Integer> ingredientesNecessarios;
    private String ferramentaNecessaria;
    private boolean eCondicaoDeVitoria;

    //Construtor da Classe:
    public Receita(String nomeItemResultado, Item itemResultadoTemplate,
                   String ferramentaNecessaria, boolean eCondicaoDeVitoria) {
        this.nomeItemResultado = nomeItemResultado;
        this.itemResultadoTemplate = itemResultadoTemplate;
        this.ingredientesNecessarios = new HashMap<>();
        this.ferramentaNecessaria = ferramentaNecessaria;
        this.eCondicaoDeVitoria = eCondicaoDeVitoria;
    }

    //Metodos Acessores (existentes):
    public String getNomeItemResultado() { return nomeItemResultado; }
    public void setNomeItemResultado(String nomeItemResultado) { this.nomeItemResultado = nomeItemResultado; }
    public Item getItemResultadoTemplate() { return itemResultadoTemplate; }
    public void setItemResultadoTemplate(Item itemResultadoTemplate) { this.itemResultadoTemplate = itemResultadoTemplate; }
    public Map<String, Integer> getIngredientesNecessarios() { return ingredientesNecessarios; }
    public void setIngredientesNecessarios(Map<String, Integer> ingredientesNecessarios) { this.ingredientesNecessarios = ingredientesNecessarios; }
    public String getFerramentaNecessaria() { return ferramentaNecessaria; }
    public void setFerramentaNecessaria(String ferramentaNecessaria) { this.ferramentaNecessaria = ferramentaNecessaria; }
    public boolean isCondicaoDeVitoria() {
        return eCondicaoDeVitoria;
    }
    public void setEhCondicaoDeVitoria(boolean ehCondicaoDeVitoria) {
        this.eCondicaoDeVitoria = ehCondicaoDeVitoria;
    }

    //Metodos Especiais:
    public void adicionarIngrediente(String nomeItemIngrediente, int quantidade) {
        this.ingredientesNecessarios.put(nomeItemIngrediente, quantidade);
    }
}