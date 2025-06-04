package inventario;

import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;


import interfaces.AcoesInventario;
import itens.*;
import personagens.*;

public class Inventario implements AcoesInventario {

    //Atributos da Classe:
    private ArrayList<Item> listaItens;
    private int pesoSuportado;
    private int capacidadeInventario;

    //Metodo Construtor da Classe::
    public Inventario(ArrayList<Item> listaItens, int pesoSuportado, int capacidadeInventario) {
        this.listaItens = listaItens;
        this.pesoSuportado = pesoSuportado;
        this.capacidadeInventario = capacidadeInventario;
    }

    //Metodos Acessores:
    public void setListaItens(ArrayList<Item> listaItens) {
        this.listaItens = listaItens;
    }

    private ArrayList<Item> getListaItens() {
        return listaItens;
    }

    public void setPesoSuportado(int pesoSuportado) {
        this.pesoSuportado = pesoSuportado;
    }

    public int getPesoSuportado() {
        return pesoSuportado;
    }

    public void setCapacidadeInventario(int capacidadeInventario) {
        this.capacidadeInventario = capacidadeInventario;
    }

    public int getCapacidadeInventario() {
        return capacidadeInventario;
    }

    //Metodos Implementados:
    @Override
    public boolean adicionarItem(Item itemAdicionado) {
        if (this.listaItens.size() >= getCapacidadeInventario()) {
            System.out.println("Não foi possível adicionar o Item '" + itemAdicionado.getNomeItem() + "', pois seu inventário está cheio!!");
            return false;
        }
        if (itemAdicionado.getPesoItem() > this.getPesoSuportado()) {
            System.out.println("Não foi possível adicionar o Item '" + itemAdicionado.getNomeItem() + "', pois seu inventário está muito pesado!");
            return false;
        }
        this.listaItens.add(itemAdicionado);
        this.setPesoSuportado(this.getPesoSuportado() - itemAdicionado.getPesoItem());
        System.out.println("O item " + itemAdicionado.getNomeItem() + " foi adicionado!");
        return true;
    }

    @Override
    public void descartarItem(Item itemDescartado) {
        if (this.listaItens.contains(itemDescartado)) {
            this.setPesoSuportado(this.getPesoSuportado() + itemDescartado.getPesoItem());
            this.listaItens.remove(itemDescartado);
            System.out.println("O item " + itemDescartado.getNomeItem() + " foi descartado!");
        } else {
            System.out.println("Item " + itemDescartado.getNomeItem() + " não encontrado para descarte.");
        }
    }

    @Override
    public void selecionarItem(int posicaoItemSelecionado, Personagem personagemEscolhido) {
        if (posicaoItemSelecionado < 0 || posicaoItemSelecionado >= this.listaItens.size()) {
            System.out.println("Posição inválida no inventário.");
            return;
        }
        Item itemSelecionado = this.getListaItens().get(posicaoItemSelecionado);

        if (itemSelecionado instanceof Agua || itemSelecionado instanceof Alimento || itemSelecionado instanceof Remedio) {
            itemSelecionado.usar(itemSelecionado, personagemEscolhido);
            System.out.println("O item " + itemSelecionado.getNomeItem() + " foi consumido!");
            this.setPesoSuportado(this.getPesoSuportado() + itemSelecionado.getPesoItem());
            this.getListaItens().remove(itemSelecionado);
        } else if (itemSelecionado instanceof Material) {
            System.out.println("Material selecionado: " + itemSelecionado.getNomeItem() + ". Escolha outro para poder combinar!");
            this.mostrarInventario();
        } else if (itemSelecionado instanceof Arma) {
            System.out.println("Arma selecionada: " + itemSelecionado.getNomeItem() + "!");
        } else if (itemSelecionado instanceof Ferramenta) {
            System.out.println("Ferramenta selecionada: " + itemSelecionado.getNomeItem() + "!");
        }
    }

    @Override
    public void mostrarInventario() {
        System.out.println("\n--- Inventário ---");
        if (this.listaItens.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
        } else {
            for (int contador = 0; contador < this.listaItens.size(); contador++) {
                Item itemAtual = this.listaItens.get(contador);
                System.out.println(contador + " - " + itemAtual.getNomeItem() + " (Peso: " + itemAtual.getPesoItem() + ")");
            }
        }
        System.out.println("Peso Restante Suportado: " + getPesoSuportado());
        System.out.println("Slots: " + getNumeroItensAtual() + "/" + getCapacidadeInventario());
        System.out.println("------------------");
    }

    @Override
    public void mostrarItem(Item itemSelecionado) {
        if (itemSelecionado != null) {
            System.out.println("\n--- Detalhes do Item ---");
            System.out.println("Nome do Item: " + itemSelecionado.getNomeItem());
            System.out.println("Peso do Item: " + itemSelecionado.getPesoItem());
            System.out.println("Durabilidade do Item: " + itemSelecionado.getDurabilidadeItem());
        }
    }
    //Metodos Especiais para melhor tratamento do Inventário no Main:
    public int getNumeroItensAtual() {
        return this.listaItens.size();
    }

    public Item getItemPeloIndice(int indice) {
        if (indice >= 0 && indice < this.listaItens.size()) {
            return this.listaItens.get(indice);
        } else {
            System.out.println("Erro: Tentativa de acessar um item em um índice inválido (" + indice + ") do inventário.");
            return null;
        }
    }

    public boolean descartarItemPeloIndice(int indice) { //Paola, estou usando boolean para melhorar o retorno das validações
        if (indice >= 0 && indice < this.listaItens.size()) {
            Item itemParaDescartar = this.listaItens.get(indice);
            this.setPesoSuportado(this.getPesoSuportado() + itemParaDescartar.getPesoItem());
            this.listaItens.remove(indice);
            System.out.println("O item '" + itemParaDescartar.getNomeItem() + "' foi descartado do inventário.");
            return true;
        } else {
            System.out.println("Índice inválido (" + indice + "). Nenhum item foi descartado.");
            return false;
        }
    }

    //Métodos para o Sistema de Craft:
    public boolean temItem(String nomeItem, int quantidadeNecessaria) { //Paola, estou usando boolean para melhorar o retorno das validações
        if (nomeItem == null || quantidadeNecessaria <= 0) {
            return false; //Não faz sentido procurar por quantidade nula/negativa ou nome nulo
        }
        int contador = 0;
        for (Item item : this.listaItens) {
            if (item.getNomeItem().equals(nomeItem)) {
                contador++;
            }
        }
        return contador >= quantidadeNecessaria;
    }

    public boolean removerItemPorNomeEQuantidade(String nomeItem, int quantidadeParaRemover) {
        if (nomeItem == null || quantidadeParaRemover <= 0) {
            return false;
        }

        //Primeiro, verificamos se realmente temos o suficiente:
        if (!temItem(nomeItem, quantidadeParaRemover)) {
            System.out.println("Tentativa de remover " + nomeItem + " falhou na verificação interna de quantidade.");
            return false;
        }

        int removidos = 0;
        //Usar um Iterator é mais seguro para remover enquanto itera sobre uma ArrayList:
        Iterator<Item> iterador = this.listaItens.iterator();
        while (iterador.hasNext()) {
            if (removidos >= quantidadeParaRemover) {
                break;
            }
            Item itemAtual = iterador.next();
            if (itemAtual.getNomeItem().equals(nomeItem)) {
                this.setPesoSuportado(this.getPesoSuportado() + itemAtual.getPesoItem());
                iterador.remove();
                removidos++;
            }
        }
        //Confirmando se o número correto foi removido. Deve ser sempre true se temItem() passou.
        return removidos == quantidadeParaRemover;
    }

    public boolean removerIngredientes(Map<String, Integer> ingredientesNecessarios) {
        if (ingredientesNecessarios == null || ingredientesNecessarios.isEmpty()) {
            return true; //Nenhum ingrediente para remover
        }

        //1: Verificando se os ingredientes estão disponíveis nas quantidades necessárias:
        for (Map.Entry<String, Integer> entrada : ingredientesNecessarios.entrySet()) {
            String nomeIngrediente = entrada.getKey();
            int quantidadeRequerida = entrada.getValue();
            if (!temItem(nomeIngrediente, quantidadeRequerida)) {
                System.out.println("Falta ingrediente para construção: " + nomeIngrediente + ", necessário: " + quantidadeRequerida);
                return false; //Se um único ingrediente faltar, a operação inteira falha
            }
        }

        //2: Se todos os ingredientes foram verificados, proceder com a remoção:
        for (Map.Entry<String, Integer> entrada : ingredientesNecessarios.entrySet()) {
            String nomeIngrediente = entrada.getKey();
            int quantidadeRequerida = entrada.getValue();
            //Aqui, esperamos que removerItemPorNomeEQuantidade retorne true, pois já verificamos com temItem.
            if (!removerItemPorNomeEQuantidade(nomeIngrediente, quantidadeRequerida)) {
                //Se chegar aqui, então a construção falhou parcialmente.
                System.err.println("Falha ao remover '" + nomeIngrediente + "' após verificação. Inventário pode estar inconsistente.");
                return false;
            }
        }
        return true; //Todos os ingredientes foram removidos com sucesso
    }
}