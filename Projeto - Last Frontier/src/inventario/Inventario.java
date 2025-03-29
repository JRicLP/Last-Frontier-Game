package inventario;

public class Inventario {
    //Atributos da classe:
    private String listaItens; //Esse membro será um Array, posteriormente será modificado
    private double pesoInventario;
    private double capacidadeInventario;
    //Métodos da classe:
    public Inventario(String listaItens, double pesoInventario, double capacidadeInventario){
        this.listaItens = listaItens;
        this.pesoInventario = pesoInventario;
        this.capacidadeInventario = capacidadeInventario;
    }
    public void setListaItens(String listaItens){
        this.listaItens = listaItens;
    }
    public String getListaItens(){
        return listaItens;
    }
    public void setPesoInventario(double pesoInventario){
        this.pesoInventario = pesoInventario;
    }
    public double getPesoInventario(){
        return pesoInventario;
    }
    public void setCapacidadeInventario(){
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
}
