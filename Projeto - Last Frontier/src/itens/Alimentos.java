package itens;

public class Alimentos extends Item {
    //Atributos da subclasse
    private double valorNutricional;
    private String tipoAlimento;
    private int prazoValidade;
    //Métodos da subclasse:
    public Alimentos(String nomeItem, double pesoItem, double durabilidadeItem, double valorNutricional, String tipoAlimento){
        super(nomeItem, pesoItem, durabilidadeItem);
        this.valorNutricional = valorNutricional;
        this.tipoAlimento = tipoAlimento;
    }
    public void setValorNutricional(double valorNutricional){
        this.valorNutricional = valorNutricional;
    }
    public double getValorNutricional(){
        return valorNutricional;
    }
    public void setTipoAlimento(){
        this.tipoAlimento = tipoAlimento;
    }
    public String getTipoAlimento(){
        return tipoAlimento;
    }
    public void setPrazoValidade(int prazoValidade){
        this.prazoValidade = prazoValidade;
    }
    public int getPrazoValidade(){
        return prazoValidade;
    }
    public void consumirAlimento(){ //Metodo sobrescrito
    }
}
