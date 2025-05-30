package inventario;

import java.util.ArrayList;

import interfaces.AcoesInventario;
import itens.*;
import personagens.*;

public class Inventario implements AcoesInventario {

    //Atributos da classe:
    private ArrayList<Item> listaItens;
    private int pesoSuportado;
    private int capacidadeInventario;

    //Metodo construtor:
    public Inventario(ArrayList<Item> listaItens, int pesoSuportado, int capacidadeInventario) {
        this.listaItens = listaItens; //O atributo no construtor deve estar dessa forma!!
        this.pesoSuportado = pesoSuportado;
        this.capacidadeInventario = capacidadeInventario;

    }

    //Metodos acessores:
    public void setListaItens(ArrayList<Item> listaItens) {
        this.listaItens = listaItens;
    }

    private ArrayList<Item> getListaItens() { //Esse metodo tem que ser privado?
        return listaItens;
    }

    public void setPesoSuportado(int pesoSuportado) {
        this.pesoSuportado = pesoSuportado;
    }

    public int getPesoSuportado() { //Precisamos fazer uma verificação relativamente ao peso do Inventário/Itens
        return pesoSuportado;
    }

    public void setCapacidadeInventario(int capacidadeInventario) {
        this.capacidadeInventario = capacidadeInventario;
    }

    public int getCapacidadeInventario() { //Se refere ao número de itens
        return capacidadeInventario;
    }

    //Metodos implementados:
    @Override
    public boolean adicionarItem(Item itemAdicionado) {
        if (listaItens.size() >= getCapacidadeInventario()) {
            System.out.println("Não foi possível adicionar o Item, pois seu inventário está cheio!!");
            return false;
        }
        if (itemAdicionado.getPesoItem() > this.getPesoSuportado()) { // this.getPesoSuportado() é o peso restante
            System.out.println("Não foi possível adicionar o Item, pois seu inventário está muito pesado!");
            return false;
        }
        this.listaItens.add(itemAdicionado);
        this.setPesoSuportado(this.getPesoSuportado() - itemAdicionado.getPesoItem());
        System.out.println("O item " + itemAdicionado.getNomeItem() + " foi adicionado!"); //Quero deixar aqui!
        return true;
    }

    @Override
    public void descartarItem(Item itemDescartado) { //Adicionar um verificador para limitar a quantidade de itens com relação à capacidade do inventário
        this.setPesoSuportado(this.getPesoSuportado() + itemDescartado.getPesoItem());
        this.getListaItens().remove(itemDescartado);
        System.out.println("O item " + itemDescartado.getNomeItem() + " foi descartado!");
    }

    @Override
    public void selecionarItem(int posicaoItemSelecionado, Personagem personagemEscolhido) {
        if (posicaoItemSelecionado < 0 || posicaoItemSelecionado >= listaItens.size()) {
            System.out.println("Posição inválida no inventário.");
            return; //Sai do metodo se o índice for inválido
        }
        Item itemSelecionado = this.getListaItens().get(posicaoItemSelecionado);
        //Verificando o Tipo do “Item”:
        if (itemSelecionado instanceof Agua || itemSelecionado instanceof Alimentos || itemSelecionado instanceof Remedios) { //Consumíveis
            itemSelecionado.usar(itemSelecionado, personagemEscolhido);
            System.out.println("O item " + itemSelecionado.getNomeItem() + " foi consumido!");
            this.setPesoSuportado(this.getPesoSuportado() + itemSelecionado.getPesoItem());
            this.getListaItens().remove(itemSelecionado);
        } else if (itemSelecionado instanceof Materiais) { //Irá se desenvolver com o sistema de Craft - Combináveis
            System.out.println("Material selecionado, escolha outro para poder combinar!");
            this.mostrarInventario();
        } else if (itemSelecionado instanceof Armas) { //Temos que desenvolver um slot especial do inventário para Armas - Equipáveis
            System.out.println("Arma selecionada!");
        } else if (itemSelecionado instanceof Ferramentas) { //Temos que desenvolver um slot especial do inventário para Ferramentas - Equipáveis
            System.out.println("Ferramenta pronta para uso!");
        }
    }

    @Override
    public void mostrarInventario() {
        System.out.println("\n--- Inventário ---");
        if (listaItens.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
        } else {
            for (int contador = 0; contador < listaItens.size(); contador++) {
                Item itemAtual = listaItens.get(contador);
                System.out.println(contador + " - " + itemAtual.getNomeItem() + " (Peso: " + itemAtual.getPesoItem() + ")");
            }
        }
        System.out.println("Peso Restante Suportado: " + getPesoSuportado());
        System.out.println("Slots: " + getNumeroItensAtual() + "/" + getCapacidadeInventario());
        System.out.println("------------------");
    }

    @Override
    public void mostrarItem(Item itemSelecionado) { //Metodo adicionado para o utilizador administrar o inventário!
        System.out.println("Nome do Item: " + itemSelecionado.getNomeItem());
        System.out.println("Peso do Item: " + itemSelecionado.getPesoItem());
    }

    //Metodos especiais para melhor tratamento no Main:
    public int getNumeroItensAtual() {
        return this.listaItens.size();
    }

    public Item getItemPeloIndice(int indice) {
        if (indice >= 0 && indice < this.listaItens.size()) {
            return this.listaItens.get(indice);
        } else {
            System.out.println("Erro: Tentativa de acessar um item em um índice inválido (" + indice + ") do inventário.");
            return null; // Retorna null para indicar que o item não foi encontrado ou o índice é inválido
        }
    }

    public boolean descartarItemPeloIndice(int indice) {
        if (indice >= 0 && indice < this.listaItens.size()) {
            Item itemParaDescartar = this.listaItens.get(indice);
            this.setPesoSuportado(this.getPesoSuportado() + itemParaDescartar.getPesoItem()); // Aumenta o peso restante suportado
            this.listaItens.remove(indice); // Remove pelo índice, que é eficiente para ArrayList
            System.out.println("O item '" + itemParaDescartar.getNomeItem() + "' foi descartado do inventário.");
            return true;
        } else {
            System.out.println("Índice inválido (" + indice + "). Nenhum item foi descartado.");
            return false;
        }
    }
}
