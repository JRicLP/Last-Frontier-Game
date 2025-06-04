package personagens;

import inventario.Inventario;
import itens.Item;
import itens.Alimento;
import itens.Agua;
import ambientes.Ambiente;
import eventos.EventoCriatura;
import gerenciadores.GerenciadorDeItem;

public class Pirata extends Personagem {

    //Atributos da Classe:
    private String descricaoHabilidadeClasse;

    //Metodo Construtor:
    public Pirata(String descricaoHabilidadeClasseEntrada) {
        super("Scarlet Tempest - A Pirata Infame",100,90,90,70,100);
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasseEntrada;
    }

    //Metodos acessores para a descrição da Habilidade da classe:
    public String getDescricaoHabilidadeClasse() {
        return descricaoHabilidadeClasse;
    }

    public void setDescricaoHabilidadeClasse(String descricaoHabilidadeClasse) {
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasse;
    }

    //Implementação dos Métodos Abstratos da Habilidade Especial:
    @Override
    public String getNomeHabilidadeEspecial() {
        return "Pilhagem Afortunada";
    }

    @Override
    public String getDescricaoHabilidadeEspecial() {
        return "O Pirata usa seu instinto aguçado para 'encontrar' um pequeno tesouro escondido, garantindo alguns suprimentos valiosos.";
    }

    @Override
    public boolean ativarHabilidadeEspecial(EventoCriatura criaturaAlvo, Ambiente ambienteAtual, GerenciadorDeItem gerenciadorDeItem, Inventario inventarioPersonagem) {

        System.out.println(this.getNomePersonagem() + " exclama: 'Arrr, a sorte me sorri!' e ativa " + getNomeHabilidadeEspecial() + "!");

        boolean algoAdicionado = false;

        //Item 1: Um alimento bom:
        Alimento alimentoValioso = new Alimento("Pote de Vaelra (Pilhagem)", 3, 6, 20, "Pote de Vaelra", 10);
        System.out.println("Você 'encontra' um " + alimentoValioso.getNomeItem() + "!");
        if (inventarioPersonagem.adicionarItem(alimentoValioso)) {
            algoAdicionado = true;
        } else {
            System.out.println("...mas seu inventário está cheio para o " + alimentoValioso.getNomeItem() + ".");
        }

        //Item 2: Agua boa:
        Agua aguaBoa = new Agua("Cantil de Rum... digo, Água Fresca (Pilhagem)", 1, 10, 9, 5);
        System.out.println("Você também 'descobre' um " + aguaBoa.getNomeItem() + "!");
        if (inventarioPersonagem.adicionarItem(aguaBoa)) {
            algoAdicionado = true;
        } else {
            System.out.println("...mas seu inventário está cheio para o " + aguaBoa.getNomeItem() + ".");
        }

        //Item 3: Um material aleatorio:
        System.out.println("E parece que havia mais alguma coisa...");
        Item materialExtra = gerenciadorDeItem.gerarItemMateriais();
        if (materialExtra != null) {
            System.out.println("Um " + materialExtra.getNomeItem() + " estava junto com o resto!");
            if (inventarioPersonagem.adicionarItem(materialExtra)) {
                algoAdicionado = true;
            } else {
                System.out.println("...mas seu inventário está cheio para o " + materialExtra.getNomeItem() + ".");
            }
        } else {
            System.out.println("...mas era apenas poeira.");
        }
        return true;
    }

    public String getHabilidadePirata() {
        return descricaoHabilidadeClasse;
    }
}