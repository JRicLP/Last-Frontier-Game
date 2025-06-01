package construcao;

import itens.Item;
import java.util.Map;
import java.util.HashMap;

public class Receita {
    //Atributos da Classe:
    private String nomeItemResultado; // Nome ou ID do item que será criado
    private Item itemResultadoTemplate; // Um template do item a ser criado (para definir seus atributos)
    private Map<String, Integer> ingredientesNecessarios; // Key: Nome/ID do item ingrediente, Value: Quantidade
    private String ferramentaNecessaria; // Nome ou ID da ferramenta (opcional)
    //Construtor da Classe:
    public Receita(String nomeItemResultado, Item itemResultadoTemplate, String ferramentaNecessaria /*, outros requisitos */) {
        this.nomeItemResultado = nomeItemResultado;
        this.itemResultadoTemplate = itemResultadoTemplate;
        this.ingredientesNecessarios = new HashMap<>();
        this.ferramentaNecessaria = ferramentaNecessaria;
    }
    //Metodos Acessores:
    public void setNomeItemResultado(String nomeItemResultado) {
        this.nomeItemResultado = nomeItemResultado;
    }
    public String getNomeItemResultado() {
        return nomeItemResultado;
    }
    public void setItemResultadoTemplate(Item itemResultadoTemplate) {
        this.itemResultadoTemplate = itemResultadoTemplate;
    }
    public Item getItemResultadoTemplate() {
        return itemResultadoTemplate;
    }
    public void setIngredientesNecessarios(Map<String, Integer> ingredientesNecessarios) {
        this.ingredientesNecessarios = ingredientesNecessarios;
    }
    public Map<String, Integer> getIngredientesNecessarios() {
        return ingredientesNecessarios;
    }
    public void setFerramentaNecessaria(String ferramentaNecessaria) {
        this.ferramentaNecessaria = ferramentaNecessaria;
    }
    public String getFerramentaNecessaria() {
        return ferramentaNecessaria;
    }
    //Metodos Especiais:
    public void adicionarIngrediente(String nomeItemIngrediente, int quantidade) {
        this.ingredientesNecessarios.put(nomeItemIngrediente, quantidade);
    }
}
