package personagens;

import inventario.Inventario;
import itens.Agua;
import itens.Alimento;
import ambientes.Ambiente;
import eventos.EventoCriatura;
import gerenciadores.GerenciadorDeItem;

public class Explorador extends Personagem {

    //Atributos da Classe:
    private String descricaoHabilidadeClasse;

    //Metodo Construtor
    public Explorador(String descricaoHabilidadeClasseEntrada) {
        super("Virgil Explorer - O Explorador Indomável", 90, 100, 100,75, 80);
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasseEntrada;
    }

    //Metodos Acessores para a descrição da Habilidade da classe:
    public String getDescricaoHabilidadeClasse() {
        return descricaoHabilidadeClasse;
    }

    public void setDescricaoHabilidadeClasse(String descricaoHabilidadeClasse) {
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasse;
    }

    //Implementação dos Métodos Abstratos da Habilidade Especial:
    @Override
    public String getNomeHabilidadeEspecial() {
        return "Dádivas Ocultas da Natureza";
    }

    @Override
    public String getDescricaoHabilidadeEspecial() {
        return "O Explorador usa seu conhecimento profundo dos ermos para encontrar instantaneamente uma reserva valiosa de água potável e alimentos nutritivos.";
    }

    @Override
    public boolean ativarHabilidadeEspecial(EventoCriatura criaturaAlvo, Ambiente ambienteAtual, GerenciadorDeItem gerenciadorDeItem, Inventario inventarioPersonagem) {
        System.out.println(this.getNomePersonagem() + " ativa " + getNomeHabilidadeEspecial() + "!");
        System.out.println("Com seu olhar treinado, você encontra recursos que passariam despercebidos por outros...");
        //Agua da Habilidade:
        Agua aguaEncontrada = new Agua("Cantil de Água Purificada (Habilidade)", 1, 10, 9, 5);
        //Alimento da Habilidade:
        Alimento alimentoEncontrado = new Alimento("Cesta de Frutas Silvestres Raras (Habilidade)", 2, 7, 20, "Frutas Variadas", 8);

        boolean aguaAdicionada = false;
        boolean alimentoAdicionado = false;

        System.out.println("Você encontrou: " + aguaEncontrada.getNomeItem() + "!");
        if (inventarioPersonagem.adicionarItem(aguaEncontrada)) {
            aguaAdicionada = true;
        } else {
            System.out.println("Você encontrou " + aguaEncontrada.getNomeItem() + ", mas não conseguiu espaço no inventário!");
        }
        System.out.println("Você também encontrou: " + alimentoEncontrado.getNomeItem() + "!");
        if (inventarioPersonagem.adicionarItem(alimentoEncontrado)) {
            alimentoAdicionado = true;
        } else {
            System.out.println("Você encontrou " + alimentoEncontrado.getNomeItem() + ", mas não conseguiu espaço no inventário!");
        }
        return true;
    }
    public String getHabilidadeExplorador() {
        return descricaoHabilidadeClasse;
    }
}