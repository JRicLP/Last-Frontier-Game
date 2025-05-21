package inventario;

import java.util.ArrayList;

import exceptions.InventarioCheioException;
import exceptions.InventarioPesadoException;
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

    public ArrayList<Item> getListaItens() { //Esse metodo tem que ser privado?
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
    public void adicionarItem(Item itemAdicionado) { //Adicionar um verificador para limitar a quantidade de itens com relação à capacidade do inventário
        if (getCapacidadeInventario() <= listaItens.size()) { //Rever essa condição para não disparar a Exception
            throw new InventarioCheioException("Não foi possível adicionar o Item, pois seu inventário está cheio!!");
        } else {
            if (this.getPesoSuportado() >= itemAdicionado.getPesoItem()) {
                this.setPesoSuportado(this.getPesoSuportado() - itemAdicionado.getPesoItem());
                this.getListaItens().add(itemAdicionado);
                System.out.println("O item " + itemAdicionado.getNomeItem() + " foi adicionado!");
            } else {
                throw new InventarioPesadoException("Não foi possível adicionar o Item, pois seu inventário está muito pesado!");
            }
        }
    }

    @Override
    public void descartarItem(Item itemDescartado) { //Adicionar um verificador para limitar a quantidade de itens com relação à capacidade do inventário
        this.setPesoSuportado(this.getPesoSuportado() + itemDescartado.getPesoItem());
        this.getListaItens().remove(itemDescartado);
        System.out.println("O item " + itemDescartado.getNomeItem() + " foi descartado!");
    }

    @Override
    public void selecionarItem(int posicaoItemSelecionado, Personagem personagemEscolhido) { //Esse metodo ainda irá evoluir
        Item itemSelecionado = this.getListaItens().get(posicaoItemSelecionado);
        //Verificando o Tipo do “Item”:
        if (itemSelecionado instanceof Agua || itemSelecionado instanceof Alimentos || itemSelecionado instanceof Remedios) { //Consumíveis
            itemSelecionado.usar(itemSelecionado, personagemEscolhido);
            System.out.println("O item " + itemSelecionado.getNomeItem() + " foi consumido!");
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
    public void mostrarInventario() { //Metodo testado e funcionando!!
        System.out.println("Inventário:");
        for (int contador = 0; contador < listaItens.size(); contador++) {
            System.out.println(contador + " - " + listaItens.get(contador).getNomeItem());
        }
    }

    @Override
    public void mostraItem(Item itemSelecionado) { //Metodo adicionado para o utilizador administrar o inventário!
        System.out.println("Nome do Item: " + itemSelecionado.getNomeItem());
        System.out.println("Peso do Item: " + itemSelecionado.getPesoItem());
    }
}
