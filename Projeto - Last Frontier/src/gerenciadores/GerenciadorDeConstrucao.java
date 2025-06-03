package gerenciadores;

import construcao.Receita;
import inventario.Inventario;
import itens.Item;
import itens.Arma;
import itens.Ferramenta;
import itens.Remedio;
import itens.Material;
import itens.Agua;
import itens.Alimento;
import personagens.Personagem;

import java.util.ArrayList;
import java.util.Map;

public class GerenciadorDeConstrucao {
    //Atributos da Classe:
    private ArrayList<Receita> todasAsReceitas;

    //Construtor da Classe:
    public GerenciadorDeConstrucao(ArrayList<Receita> receitas) {
        this.todasAsReceitas = receitas;
        if (this.todasAsReceitas == null) {
            this.todasAsReceitas = new ArrayList<>(); //Aqui, eu garanto que a lista não seja nula
        }
    }

    //Metodos Acessores:
    public void setTodasAsReceitas(ArrayList<Receita> receitas) {
        this.todasAsReceitas = receitas;
    }

    public ArrayList<Receita> getTodasAsReceitas() {
        return todasAsReceitas;
    }

    //Metodos Especiais:
    public boolean construcaoDisponivel(Receita receita, Inventario inventario, Personagem personagem) {
        if (receita == null || inventario == null || personagem == null) {
            System.out.println("DEBUG: Receita, inventário ou personagem nulo em construcaoDisponivel.");
            return false;
        }

        // 1. Verificar Ingredientes Necessários:
        for (Map.Entry<String, Integer> entry : receita.getIngredientesNecessarios().entrySet()) {
            String nomeIngrediente = entry.getKey();
            int quantidadeNecessaria = entry.getValue();
            if (!inventario.temItem(nomeIngrediente, quantidadeNecessaria)) {
                System.out.println("DEBUG: Falta ingrediente para " + receita.getNomeItemResultado() + ": " + nomeIngrediente + " (x" + quantidadeNecessaria + ")");
                return false; //Falta um ou mais ingredientes
            }
        }

        // 2. Verificar Ferramenta Necessária:
        String nomeFerramentaNecessaria = receita.getFerramentaNecessaria();
        if (nomeFerramentaNecessaria != null && !nomeFerramentaNecessaria.trim().isEmpty()) {
            if (!inventario.temItem(nomeFerramentaNecessaria, 1)) { // Verifica se tem pelo menos 1 da ferramenta
                System.out.println("DEBUG: Falta ferramenta para " + receita.getNomeItemResultado() + ": " + nomeFerramentaNecessaria);
                return false; //Falta a ferramenta
            }
        }
        return true; //Todos os requisitos verificados foram atendidos
    }

    public ArrayList<Receita> getReceitasDisponiveis(Inventario inventario, Personagem personagem) {
        ArrayList<Receita> receitasConstruiveis = new ArrayList<>();
        if (this.todasAsReceitas == null) {
            return receitasConstruiveis; // Retorna lista vazia se não houver receitas carregadas
        }
        for (Receita receita : this.todasAsReceitas) {
            if (construcaoDisponivel(receita, inventario, personagem)) {
                receitasConstruiveis.add(receita);
            }
        }
        return receitasConstruiveis;
    }

    public Item construirItem(Receita receita, Inventario inventario, Personagem personagem) {
        if (!construcaoDisponivel(receita, inventario, personagem)) {
            System.out.println("Não é possível construir '" + receita.getNomeItemResultado() + "'. Verifique os materiais, ferramentas ou habilidades necessárias.");
            return null;
        }

        // 1. Consumir os ingredientes do inventário:
        if (!inventario.removerIngredientes(receita.getIngredientesNecessarios())) {
            System.err.println("ERRO INESPERADO: Falha ao remover ingredientes para '" + receita.getNomeItemResultado() + "' mesmo após verificação. Construção cancelada.");
            return null;
        }
        System.out.println("Ingredientes consumidos para: " + receita.getNomeItemResultado());

        // 2. Criar um Objeto do item resultado:
        Item itemResultadoTemplate = receita.getItemResultadoTemplate();
        Item itemConstruido = null;

        if (itemResultadoTemplate != null) {
            if (itemResultadoTemplate instanceof Arma) {
                Arma template = (Arma) itemResultadoTemplate;
                itemConstruido = new Arma(template.getNomeItem(), template.getPesoItem(), template.getDurabilidadeItem(),
                        template.getTipoArma(), template.getDanoArma(), template.getAlcanceArma());
            } else if (itemResultadoTemplate instanceof Remedio) {
                Remedio template = (Remedio) itemResultadoTemplate;
                itemConstruido = new Remedio(template.getNomeItem(), template.getPesoItem(), template.getDurabilidadeItem(),
                        template.getTipoRemedio(), template.getEfeitoRemedio(), template.getCuraRemedio());
            } else if (itemResultadoTemplate instanceof Ferramenta) {
                Ferramenta template = (Ferramenta) itemResultadoTemplate;
                itemConstruido = new Ferramenta(template.getNomeItem(), template.getPesoItem(), template.getDurabilidadeItem(),
                        template.getTipoFerramenta(), template.getEficienciaFerramenta());
            } else if (itemResultadoTemplate instanceof Alimento) {
                Alimento template = (Alimento) itemResultadoTemplate;
                itemConstruido = new Alimento(template.getNomeItem(), template.getPesoItem(), template.getDurabilidadeItem(),
                        template.getValorNutricional(), template.getTipoAlimento(), template.getPrazoValidade());
            } else if (itemResultadoTemplate instanceof Agua) {
                Agua template = (Agua) itemResultadoTemplate;
                itemConstruido = new Agua(template.getNomeItem(), template.getPesoItem(), template.getDurabilidadeItem(),
                        template.getPurezaAgua(), template.getVolumeAgua());
            } else if (itemResultadoTemplate instanceof Material) {
                Material template = (Material) itemResultadoTemplate;
                itemConstruido = new Material(template.getNomeItem(), template.getPesoItem(), template.getDurabilidadeItem(),
                        template.getTipoMaterial(), template.getResistenciaMaterial());
            }
        }
        if (itemConstruido == null) {
            if (itemResultadoTemplate != null) {
                System.out.println("Erro crítico: Não foi possível criar a instância do item resultado para '" + receita.getNomeItemResultado() +
                        "'. O tipo de item '" + itemResultadoTemplate.getClass().getSimpleName() + "' pode não ser suportado para construção ou o template é inválido.");
            } else {
                System.out.println("Erro crítico: O template do item resultado para '" + receita.getNomeItemResultado() + "' é nulo.");
            }
            return null;
        }
        // 3. Adicionar o item construído ao inventário:
        System.out.println("Tentando adicionar '" + itemConstruido.getNomeItem() + "' ao inventário...");
        if (inventario.adicionarItem(itemConstruido)) {
            System.out.println("Você construiu com sucesso: " + itemConstruido.getNomeItem() + "!");
            return itemConstruido;
        } else {
            System.out.println("Você construiu '" + itemConstruido.getNomeItem() + "', mas não conseguiu guardá-lo. O item foi perdido!");
            return null;
        }
    }
}