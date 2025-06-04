package personagens;

import inventario.Inventario;
import itens.Item;
import itens.Arma;
import itens.Ferramenta;

import ambientes.Ambiente;
import eventos.EventoCriatura;
import gerenciadores.GerenciadorDeItem;
import java.util.ArrayList;
import java.util.Scanner;

public class Cientista extends Personagem {
    //Atributos da Classe:
    private String descricaoHabilidadeClasse;
    //Metodo Construtor:
    public Cientista(String descricaoHabilidadeClasseEntrada) {
        super("GearHead Martinez - O Cientista Criativo", 80, 90, 90, 100, 100);
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasseEntrada;
    }
    //Metodos Acessores para a descrição da Habilidade da classe:
    public String getDescricaoHabilidadeClasse() {
        return descricaoHabilidadeClasse;
    }
    public void setDescricaoHabilidadeClasse(String descricaoHabilidadeClasse) {
        this.descricaoHabilidadeClasse = descricaoHabilidadeClasse;
    }
    //Metodos Abstratos herdados para implementação da Habilidade Especial:
    @Override
    public String getNomeHabilidadeEspecial() {
        return "Reparo de Mestre";
    }
    @Override
    public String getDescricaoHabilidadeEspecial() {
        return "O Cientista aplica seu conhecimento técnico para restaurar significativamente a durabilidade de uma arma ou ferramenta danificada em seu inventário.";
    }
    @Override
    public boolean ativarHabilidadeEspecial(EventoCriatura criaturaAlvo, Ambiente ambienteAtual, GerenciadorDeItem gerenciadorDeItem, Inventario inventarioPersonagem) {
        System.out.println(this.getNomePersonagem() + " se prepara para um " + getNomeHabilidadeEspecial() + "!");
        ArrayList<Item> itensReparaveis = new ArrayList<>();
        System.out.println("Itens danificados que podem ser reparados:");
        int contadorReparaveis = 0;
        for (int contador = 0; contador < inventarioPersonagem.getNumeroItensAtual(); contador++) {
            Item itemNoInventario = inventarioPersonagem.getItemPeloIndice(contador);
            if (itemNoInventario instanceof Arma || itemNoInventario instanceof Ferramenta) {
                System.out.println(contadorReparaveis + " - " + itemNoInventario.getNomeItem() + " (Durabilidade Atual: " + itemNoInventario.getDurabilidadeItem() + ")");
                itensReparaveis.add(itemNoInventario);
                contadorReparaveis++;
            }
        }
        if (itensReparaveis.isEmpty()) {
            System.out.println("Você não possui armas ou ferramentas danificadas que possa reparar agora.");
            return false;
        }
        System.out.print("Digite o número do item que deseja reparar (conforme listado acima, ou -1 para cancelar): ");
        Scanner entradaHabilidade = new Scanner(System.in);
        int escolhaIndiceRelativo;
        if (entradaHabilidade.hasNextInt()) {
            escolhaIndiceRelativo = entradaHabilidade.nextInt();
            entradaHabilidade.nextLine();
        } else {
            System.out.println("Entrada inválida. Reparo cancelado.");
            entradaHabilidade.nextLine();
            return false;
        }
        if (escolhaIndiceRelativo == -1) {
            System.out.println("Reparo cancelado.");
            return false;
        }
        if (escolhaIndiceRelativo >= 0 && escolhaIndiceRelativo < itensReparaveis.size()) {
            Item itemEscolhidoParaReparo = itensReparaveis.get(escolhaIndiceRelativo);
            int durabilidadeRestaurada = itemEscolhidoParaReparo.getDurabilidadeItem() + 25;
            System.out.println("Reparando " + itemEscolhidoParaReparo.getNomeItem() + " de " + itemEscolhidoParaReparo.getDurabilidadeItem() + " para " + durabilidadeRestaurada + "...");
            itemEscolhidoParaReparo.setDurabilidadeItem(durabilidadeRestaurada);
            System.out.println(itemEscolhidoParaReparo.getNomeItem() + " foi reparado! Durabilidade atual: " + itemEscolhidoParaReparo.getDurabilidadeItem());
            return true;
        } else {
            System.out.println("Escolha inválida. Nenhum item foi reparado.");
            return false;
        }
    }
    public String getHabilidadeCientista() {
        return descricaoHabilidadeClasse;
    }
}