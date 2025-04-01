package inventario;

import interfaces.InventoryActions;
import itens.Item;

public class Inventario implements InventoryActions {
    //Atributos da classe:
    private String[] listaItens; //Esse membro será um Array, posteriormente será modificado
    private double pesoInventario;
    private double capacidadeInventario;
    //Metodo construtor:
    public Inventario(String[] listaItens, double pesoInventario, double capacidadeInventario){
        this.listaItens = listaItens;
        this.pesoInventario = pesoInventario;
        this.capacidadeInventario = capacidadeInventario;
    }
    //Metodos acessores:
    public void setListaItens(String[] listaItens){
        this.listaItens = listaItens;
    }
    public String[] getListaItens(){
        return listaItens;
    }
    public void setPesoInventario(double pesoInventario){
        this.pesoInventario = pesoInventario;
    }
    public double getPesoInventario(){
        return pesoInventario;
    }
    public void setCapacidadeInventario(double capacidadeInventario){
        this.capacidadeInventario = capacidadeInventario;
    }
    public double getCapacidadeInventario(){
        return capacidadeInventario;
    }
    public void adicionarItem(){ //Metodo geral
    }
    public void removerItem(){ //Metodo geral
    }
    public void usarItem(){ //Metodo geral
    }
    //Metodos implementados:
    @Override
    public void adicionarItem(Item itemAdicionado) {

    }

    @Override
    public void removerItem(Item itemRemovido) {

    }

    @Override
    public void usarItem(Item itemUsado) {

    }
}
